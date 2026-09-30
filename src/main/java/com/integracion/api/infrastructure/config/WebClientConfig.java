package com.integracion.api.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timeLimiter.TimeLimiterConfig;
import io.github.resilience4j.timeLimiter.TimeLimiterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.ReactorClientHttpConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;
import java.util.function.Function;

@Configuration
public class WebClientConfig {

    private static final Logger log = LoggerFactory.getLogger(WebClientConfig.class);

    @Value("${external.transaction-service.connection-timeout-ms:5000}")
    private int connectionTimeoutMs;

    @Value("${external.transaction-service.response-timeout-ms:10000}")
    private int responseTimeoutMs;

    @Value("${external.transaction-service.pool-max-connections:100}")
    private int poolMaxConnections;

    @Value("${external.transaction-service.pool-max-pending-requests:100}")
    private int poolMaxPendingRequests;

    @Value("${resilience.circuit-breaker.failure-rate-threshold:50}")
    private int circuitBreakerFailureRateThreshold;

    @Value("${resilience.circuit-breaker.wait-duration-open-state-ms:30000}")
    private long circuitBreakerWaitDurationOpenStateMs;

    @Value("${resilience.circuit-breaker.sliding-window-size:10}")
    private int circuitBreakerSlidingWindowSize;

    @Value("${resilience.retry.max-attempts:3}")
    private int retryMaxAttempts;

    @Value("${resilience.retry.wait-duration-ms:1000}")
    private long retryWaitDurationMs;

    @Value("${resilience.time-limiter.timeout-duration-ms:5000}")
    private long timeLimiterTimeoutDurationMs;

    @Bean
    public ConnectionProvider connectionProvider() {
        log.info("Configuring connection provider with max connections: {} and max pending requests: {}",
                poolMaxConnections, poolMaxPendingRequests);

        return ConnectionProvider.builder("transaction-service-pool")
                .maxConnections(poolMaxConnections)
                .maxPendingRequests(poolMaxPendingRequests)
                .pendingAcquireTimeout(Duration.ofMillis(responseTimeoutMs))
                .build();
    }

    @Bean
    public HttpClient httpClient(ConnectionProvider connectionProvider) {
        return HttpClient.create(connectionProvider)
                .responseTimeout(Duration.ofMillis(responseTimeoutMs))
                .option(io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeoutMs)
                .doOnConnected(conn -> conn
                        .addHandlerLast(new io.netty.handler.timeout.ReadTimeoutHandler(connectionTimeoutMs))
                        .addHandlerLast(new io.netty.handler.timeout.WriteTimeoutHandler(connectionTimeoutMs)));
    }

    @Bean
    public WebClient webClient(HttpClient httpClient) {
        log.info("Creating WebClient with connection timeout: {}ms and response timeout: {}ms",
                connectionTimeoutMs, responseTimeoutMs);

        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(16 * 1024 * 1024))
                .build();

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .exchangeStrategies(strategies)
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    @Bean
    public CircuitBreakerRegistry circuitBreakerRegistry() {
        log.info("Configuring CircuitBreaker with failure rate threshold: {}% and wait duration: {}ms",
                circuitBreakerFailureRateThreshold, circuitBreakerWaitDurationOpenStateMs);

        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(circuitBreakerFailureRateThreshold)
                .waitDurationInOpenState(Duration.ofMillis(circuitBreakerWaitDurationOpenStateMs))
                .slidingWindowSize(circuitBreakerSlidingWindowSize)
                .minimumNumberOfCalls(5)
                .permittedNumberOfCallsInHalfOpenState(3)
                .automaticTransitionFromOpenToHalfOpenEnabled(true)
                .build();

        return CircuitBreakerRegistry.of(config);
    }

    @Bean
    public CircuitBreaker transactionServiceCircuitBreaker(CircuitBreakerRegistry circuitBreakerRegistry) {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("transactionService");
        log.info("CircuitBreaker 'transactionService' created with config: failureRateThreshold={}%, waitDurationInOpenState={}ms",
                circuitBreakerFailureRateThreshold, circuitBreakerWaitDurationOpenStateMs);
        return circuitBreaker;
    }

    @Bean
    public RetryRegistry retryRegistry() {
        log.info("Configuring Retry with max attempts: {} and wait duration: {}ms",
                retryMaxAttempts, retryWaitDurationMs);

        RetryConfig config = RetryConfig.custom()
                .maxAttempts(retryMaxAttempts)
                .waitDuration(Duration.ofMillis(retryWaitDurationMs))
                .retryExceptions(
                        io.github.resilience4j.retry.exceptions.RetriesExceededException.class,
                        org.springframework.web.reactive.function.client.WebClientResponseException.ServiceUnavailable.class,
                        org.springframework.web.reactive.function.client.WebClientResponseException.GatewayTimeout.class)
                .ignoreExceptions(
                        org.springframework.web.reactive.function.client.WebClientResponseException.NotFound.class)
                .build();

        return RetryRegistry.of(config);
    }

    @Bean
    public Retry transactionServiceRetry(RetryRegistry retryRegistry) {
        Retry retry = retryRegistry.retry("transactionService");
        log.info("Retry 'transactionService' created with config: maxAttempts={}, waitDuration={}ms",
                retryMaxAttempts, retryWaitDurationMs);
        return retry;
    }

    @Bean
    public TimeLimiterRegistry timeLimiterRegistry() {
        log.info("Configuring TimeLimiter with timeout duration: {}ms", timeLimiterTimeoutDurationMs);

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofMillis(timeLimiterTimeoutDurationMs))
                .cancelRunningFuture(true)
                .build();

        return TimeLimiterRegistry.of(config);
    }

    @Bean
    public Function<io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator.Builder, 
                      io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator<?>> circuitBreakerOperator() {
        return builder -> builder.build();
    }
}