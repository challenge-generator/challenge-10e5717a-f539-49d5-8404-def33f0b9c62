# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Diseño y Mantenimiento de API en un Sistema de Integración**.

| | |
|---|---|
| Tema | Implementación SOA - API - MicroServicios |
| Nivel | advanced-l2 |
| Chapter | Integración — Desarrollo |
| Especialidad | Api |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | microservicio reactivo con capas hexagonal |
| Tiempo estimado | 20 horas |

## Receta del stack

Esqueleto obligatorio:

- `openapi.yaml con paths, schemas y responses completos`
- `policies/ con las politicas del gateway (rate limit, auth, transformacion)`
- `environments/ con la configuracion por ambiente`
- `tests/ con la coleccion de contrato`
- `README.md con el contrato y los codigos de error`

Dependencias:

- org.springframework.boot:spring-boot-starter-webflux 3.5.6
- org.springframework.boot:spring-boot-starter-validation 3.5.6
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.6.0
- io.github.resilience4j:resilience4j-spring-boot2 2.2.0
- org.projectlombok:lombok 1.18.30
- org.springframework.boot:spring-boot-starter-test 3.5.6
- org.junit.jupiter:junit-jupiter-api 5.10.3
- org.mockito:mockito-core 5.12.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `npx --yes @redocly/cli lint src/main/resources/api/openapi.yaml` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `npx --yes @redocly/cli lint src/main/resources/api/openapi.yaml` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Exploración del Sistema de Integración**: Documento que detalla las necesidades y restricciones del sistema de integración para el diseño de la API.
- **Fase 2 — Diseño de la API**: Documento que detalla el diseño de la API, incluyendo los endpoints, métodos, parámetros y respuestas esperadas.
- **Fase 3 — Documentación de la API**: Documentación completa de la API que incluye una descripción de cada endpoint, los métodos permitidos, los parámetros requeridos y las respuestas esperadas.
- **Fase 4 — Implementación del Ciclo de Vida de la API**: Documento que detalla el ciclo de vida de la API, incluyendo su creación, evolución y retiro.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/resources/api/openapi.yaml` — El topic pide el contrato de API: openapi.yaml es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (48)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/integracion/api/domain/port/TransactionRepository.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/application/service/ApiService.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/application/service/ApiService.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/application/service/ApiService.java` — `reactor.core.scheduler`
      El import reactor.core.scheduler.Schedulers pertenece a reactor.core.scheduler, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/adapter/TransactionAdapter.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/adapter/TransactionAdapter.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/adapter/TransactionAdapter.java` — `reactor.util.retry`
      El import reactor.util.retry.Retry pertenece a reactor.util.retry, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/config/WebClientConfig.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/config/WebClientConfig.java` — `reactor.netty.http`
      El import reactor.netty.http.client.HttpClient pertenece a reactor.netty.http, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/config/WebClientConfig.java` — `reactor.netty.resources`
      El import reactor.netty.resources.ConnectionProvider pertenece a reactor.netty.resources, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/exception/GlobalExceptionHandler.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.id`
      Se invoca `id` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.accountId`
      Se invoca `accountId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.transactionType`
      Se invoca `transactionType` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.amount`
      Se invoca `amount` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.currency`
      Se invoca `currency` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.status`
      Se invoca `status` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.timestamp`
      Se invoca `timestamp` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.description`
      Se invoca `description` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.correlationId`
      Se invoca `correlationId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.createdAt`
      Se invoca `createdAt` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.updatedAt`
      Se invoca `updatedAt` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.accountId`
      Se invoca `accountId` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.transactionType`
      Se invoca `transactionType` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.amount`
      Se invoca `amount` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.currency`
      Se invoca `currency` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.description`
      Se invoca `description` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/application/service/ApiService.java` — `Transaction.id`
      Se invoca `id` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `TransactionRequest.getType`
      Se invoca `getType` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `TransactionRequest.getAmount`
      Se invoca `getAmount` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `TransactionRequest.getAccountId`
      Se invoca `getAccountId` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `TransactionRequest.getDescription`
      Se invoca `getDescription` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionAdapter.saveTransaction`
      Se invoca `saveTransaction` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionResponse.transactionId`
      Se invoca `transactionId` sobre `TransactionResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionAdapter.getTransactionById`
      Se invoca `getTransactionById` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionAdapter.updateTransactionStatus`
      Se invoca `updateTransactionStatus` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionAdapter.deleteTransaction`
      Se invoca `deleteTransaction` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `Transaction.transactionId`
      Se invoca `transactionId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `Transaction.timestamp`
      Se invoca `timestamp` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `TransactionAdapter.saveTransaction`
      Se invoca `saveTransaction` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `ApiService.processTransaction`
      Se invoca `processTransaction` sobre `ApiService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `ApiService.getTransactionsByAccount`
      Se invoca `getTransactionsByAccount` sobre `ApiService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `ApiService.getTransactionsByStatus`
      Se invoca `getTransactionsByStatus` sobre `ApiService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (17)

- `pom.xml`
- `src/main/java/com/integracion/api/ApiApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/integracion/api/domain/model/Transaction.java`
- `src/main/java/com/integracion/api/domain/port/TransactionRepository.java`
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionRequest.java`
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java`
- `src/main/resources/api/openapi.yaml`
- `src/main/java/com/integracion/api/application/service/ApiService.java`
- `src/main/java/com/integracion/api/infrastructure/adapter/TransactionAdapter.java`
- `src/main/java/com/integracion/api/infrastructure/config/WebClientConfig.java`
- `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java`
- `src/main/java/com/integracion/api/infrastructure/exception/GlobalExceptionHandler.java`
- `src/main/java/com/integracion/api/infrastructure/dto/ErrorResponse.java`
- `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java`
- `src/test/java/com/integracion/api/application/service/ApiServiceTest.java`
- `README.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/integracion/api`
- `src/main/java/com/integracion/api/application`
- `src/main/java/com/integracion/api/domain`
- `src/main/java/com/integracion/api/infrastructure`
- `src/main/resources`
- `src/main/resources/api`
- `src/test/java/com/integracion/api`

## Verificacion

```bash
npx --yes @redocly/cli lint src/main/resources/api/openapi.yaml
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **microservicio reactivo con capas hexagonal**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Integración, Especialidad Desarrollador, Tecnología API, Advanced
- Brecha que el reto ataca: Creación y mantenimientos de API, Servicios o microservicios. ¿Qué es la documentación de una API y por qué es crucial? Explica cómo se implementa patrón de bajo acoplamiento. Cuál es el ciclo de vida de las API
- Mision: Candidato nivel Advanced con experiencia en desarrollo de integraciones

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
