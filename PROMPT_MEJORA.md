# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/resources/api/openapi.yaml` — El topic pide el contrato de API: openapi.yaml es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/integracion/api/domain/port/TransactionRepository.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/application/service/ApiService.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/application/service/ApiService.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/application/service/ApiService.java` — `reactor.core.scheduler`: El import reactor.core.scheduler.Schedulers pertenece a reactor.core.scheduler, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/adapter/TransactionAdapter.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/adapter/TransactionAdapter.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/adapter/TransactionAdapter.java` — `reactor.util.retry`: El import reactor.util.retry.Retry pertenece a reactor.util.retry, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/config/WebClientConfig.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/config/WebClientConfig.java` — `reactor.netty.http`: El import reactor.netty.http.client.HttpClient pertenece a reactor.netty.http, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/config/WebClientConfig.java` — `reactor.netty.resources`: El import reactor.netty.resources.ConnectionProvider pertenece a reactor.netty.resources, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/exception/GlobalExceptionHandler.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.id`: Se invoca `id` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.accountId`: Se invoca `accountId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.transactionType`: Se invoca `transactionType` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.amount`: Se invoca `amount` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.currency`: Se invoca `currency` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.status`: Se invoca `status` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.timestamp`: Se invoca `timestamp` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.description`: Se invoca `description` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.correlationId`: Se invoca `correlationId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.createdAt`: Se invoca `createdAt` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java` — `Transaction.updatedAt`: Se invoca `updatedAt` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.accountId`: Se invoca `accountId` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.transactionType`: Se invoca `transactionType` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.amount`: Se invoca `amount` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.currency`: Se invoca `currency` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/application/service/ApiService.java` — `TransactionRequest.description`: Se invoca `description` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/application/service/ApiService.java` — `Transaction.id`: Se invoca `id` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `TransactionRequest.getType`: Se invoca `getType` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `TransactionRequest.getAmount`: Se invoca `getAmount` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `TransactionRequest.getAccountId`: Se invoca `getAccountId` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java` — `TransactionRequest.getDescription`: Se invoca `getDescription` sobre `TransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionAdapter.saveTransaction`: Se invoca `saveTransaction` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionResponse.transactionId`: Se invoca `transactionId` sobre `TransactionResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionAdapter.getTransactionById`: Se invoca `getTransactionById` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionAdapter.updateTransactionStatus`: Se invoca `updateTransactionStatus` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java` — `TransactionAdapter.deleteTransaction`: Se invoca `deleteTransaction` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `Transaction.transactionId`: Se invoca `transactionId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `Transaction.timestamp`: Se invoca `timestamp` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `TransactionAdapter.saveTransaction`: Se invoca `saveTransaction` sobre `TransactionAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `ApiService.processTransaction`: Se invoca `processTransaction` sobre `ApiService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `ApiService.getTransactionsByAccount`: Se invoca `getTransactionsByAccount` sobre `ApiService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/integracion/api/application/service/ApiServiceTest.java` — `ApiService.getTransactionsByStatus`: Se invoca `getTransactionsByStatus` sobre `ApiService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
npx --yes @redocly/cli lint src/main/resources/api/openapi.yaml
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Integración, Especialidad Desarrollador, Tecnología API, Advanced

### Brecha de conocimiento
Creación y mantenimientos de API, Servicios o microservicios. ¿Qué es la documentación de una API y por qué es crucial? Explica cómo se implementa patrón de bajo acoplamiento. Cuál es el ciclo de vida de las API

### Misión / candidato
Candidato nivel Advanced con experiencia en desarrollo de integraciones

### Reto
- Tema: Implementación SOA - API - MicroServicios
- Seniority: advanced-l2
- Tipo: mixed
- Título: Diseño y Mantenimiento de API en un Sistema de Integración
- Tiempo estimado: 20 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Exploración del Sistema de Integración — objetivo: Identificar las necesidades y restricciones del sistema de integración para el diseño de la API. — entregable (NO resolver): Documento que detalla las necesidades y restricciones del sistema de integración para el diseño de la API.
- Fase 2: Diseño de la API — objetivo: Diseñar una API que permita la comunicación efectiva entre microservicios, siguiendo patrones de bajo acoplamiento. — entregable (NO resolver): Documento que detalla el diseño de la API, incluyendo los endpoints, métodos, parámetros y respuestas esperadas.
- Fase 3: Documentación de la API — objetivo: Documentar adecuadamente la API para asegurar su entendimiento y uso correcto por parte de los desarrolladores. — entregable (NO resolver): Documentación completa de la API que incluye una descripción de cada endpoint, los métodos permitidos, los parámetros requeridos y las respuestas esperadas.
- Fase 4: Implementación del Ciclo de Vida de la API — objetivo: Implementar y mantener el ciclo de vida de la API, incluyendo su creación, evolución y retiro. — entregable (NO resolver): Documento que detalla el ciclo de vida de la API, incluyendo su creación, evolución y retiro.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.integracion</groupId>
    <artifactId>api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>api</name>
    <description>API para integración de microservicios financieros</description>

    <properties>
        <java.version>21</java.version>
        <resilience4j.version>2.2.0</resilience4j.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot2</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-reactor</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.3</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/integracion/api/ApiApplication.java ===
package com.integracion.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import java.time.Duration;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Bean
    public CircuitBreakerConfig circuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(5)
                .build();
    }

    @Bean
    public TimeLimiterConfig timeLimiterConfig() {
        return TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(2))
                .build();
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: api-integracion
  webflux:
    base-path: /api

server:
  port: 8080
  error:
    include-message: always
    include-binding-errors: always

logging:
  level:
    root: INFO
    com.integracion.api: DEBUG

api:
  external:
    transactions:
      base-url: http://external-service:8081
      endpoints:
        get-transaction: /transactions/{id}
        create-transaction: /transactions
    users:
      base-url: http://user-service:8082
      endpoints:
        get-user: /users/{id}

resilience4j:
  circuitbreaker:
    instances:
      transactionService:
        registerHealthIndicator: true
        slidingWindowSize: 5
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
        recordExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.io.IOException
          - java.util.concurrent.TimeoutException
      userService:
        registerHealthIndicator: true
        slidingWindowSize: 5
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
        recordExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.io.IOException
          - java.util.concurrent.TimeoutException

  timelimiter:
    instances:
      transactionService:
        timeoutDuration: 2s
      userService:
        timeoutDuration: 2s

// === ARCHIVO: src/main/java/com/integracion/api/domain/model/Transaction.java ===
package com.integracion.api.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Transaction(
    UUID transactionId,
    String accountId,
    BigDecimal amount,
    String currency,
    String transactionType,
    LocalDateTime timestamp,
    String status,
    String reference,
    String counterpartyAccountId,
    String description) {

    public Transaction {
        if (transactionId == null) {
            throw new IllegalArgumentException("Transaction ID cannot be null");
        }
        if (accountId == null || accountId.isBlank()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency cannot be null or empty");
        }
        if (transactionType == null || transactionType.isBlank()) {
            throw new IllegalArgumentException("Transaction type cannot be null or empty");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
    }

    public Transaction withStatus(String newStatus) {
        return new Transaction(
            this.transactionId,
            this.accountId,
            this.amount,
            this.currency,
            this.transactionType,
            this.timestamp,
            newStatus,
            this.reference,
            this.counterpartyAccountId,
            this.description
        );
    }
}

// === ARCHIVO: src/main/java/com/integracion/api/domain/port/TransactionRepository.java ===
package com.integracion.api.domain.port;

import com.integracion.api.domain.model.Transaction;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import java.util.UUID;

public interface TransactionRepository {
    Mono<Transaction> save(Transaction transaction);
    Mono<Transaction> findById(UUID transactionId);
    Flux<Transaction> findByAccountId(String accountId);
    Flux<Transaction> findByStatus(String status);
    Mono<Void> deleteById(UUID transactionId);
    Mono<Transaction> updateStatus(UUID transactionId, String newStatus);
}

// === ARCHIVO: src/main/java/com/integracion/api/infrastructure/dto/TransactionRequest.java ===
package com.integracion.api.infrastructure.dto;


import com.integracion.api.domain.model.Transaction;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionRequest(
    @NotBlank(message = "Account ID cannot be blank")
    String accountId,

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    BigDecimal amount,

    @NotBlank(message = "Currency cannot be blank")
    @Size(min = 3, max = 3, message = "Currency must be 3 characters")
    String currency,

    @NotBlank(message = "Transaction type cannot be blank")
    String transactionType,

    @NotBlank(message = "Reference cannot be blank")
    String reference,

    @NotBlank(message = "Counterparty account ID cannot be blank")
    String counterpartyAccountId,

    @NotBlank(message = "Description cannot be blank")
    String description) {

    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }
}

// === ARCHIVO: src/main/java/com/integracion/api/infrastructure/dto/TransactionResponse.java ===
package com.integracion.api.infrastructure.dto;


import com.integracion.api.domain.model.Transaction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionResponse(
    @NotNull(message = "Transaction ID cannot be null")
    UUID id,
    
    @NotBlank(message = "Account ID cannot be blank")
    String accountId,
    
    @NotBlank(message = "Transaction type cannot be blank")
    String transactionType,
    
    @NotNull(message = "Amount cannot be null")
    BigDecimal amount,
    
    @NotBlank(message = "Currency cannot be blank")
    String currency,
    
    @NotBlank(message = "Status cannot be blank")
    String status,
    
    LocalDateTime timestamp,
    
    String description,
    
    String correlationId,
    
    LocalDateTime createdAt,
    
    LocalDateTime updatedAt
) {
    public static TransactionResponse fromDomain(com.integracion.api.domain.model.Transaction transaction) {
        return new TransactionResponse(
            UUID.fromString(transaction.id()),
            transaction.accountId(),
            transaction.transactionType(),
            transaction.amount(),
            transaction.currency(),
            transaction.status(),
            transaction.timestamp(),
            transaction.description(),
            transaction.correlationId(),
            transaction.createdAt(),
            transaction.updatedAt()
        );
    }
}

// === ARCHIVO: src/main/resources/api/openapi.yaml ===
openapi: 3.1.0
info:
  title: Financial Integration API
  description: API para integración de microservicios financieros
  version: 1.0.0
  contact:
    name: API Support
    email: support@integracion.com

servers:
  - url: http://localhost:8080
    description: Servidor de desarrollo
  - url: https://api.integracion.com/v1
    description: Servidor de producción

tags:
  - name: Transactions
    description: Operaciones relacionadas con transacciones financieras

paths:
  /api/v1/transactions:
    post:
      tags:
        - Transactions
      summary: Crear una nueva transacción
      operationId: createTransaction
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/TransactionRequest'
      responses:
        '201':
          description: Transacción creada exitosamente
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/TransactionResponse'
        '400':
          description: Solicitud inválida
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/ErrorResponse'
        '500':
          description: Error interno del servidor
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/ErrorResponse'

    get:
      tags:
        - Transactions
      summary: Listar todas las transacciones
      operationId: getAllTransactions
      parameters:
        - name: accountId
          in: query
          required: false
          schema:
            type: string
        - name: status
          in: query
          required: false
          schema:
            type: string
      responses:
        '200':
          description: Lista de transacciones
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/TransactionResponse'
        '500':
          description: Error interno del servidor
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/ErrorResponse'

  /api/v1/transactions/{transactionId}:
    get:
      tags:
        - Transactions
      summary: Obtener una transacción por ID
      operationId: getTransactionById
      parameters:
        - name: transactionId
          in: path
          required: true
          schema:
            type: string
            format: uuid
      responses:
        '200':
          description: Transacción encontrada
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/TransactionResponse'
        '404':
          description: Transacción no encontrada
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/ErrorResponse'

    delete:
      tags:
        - Transactions
      summary: Eliminar una transacción
      operationId: deleteTransaction
      parameters:
        - name: transactionId
          in: path
          required: true
          schema:
            type: string
            format: uuid
      responses:
        '204':
          description: Transacción eliminada exitosamente
        '404':
          description: Transacción no encontrada
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/ErrorResponse'

  /api/v1/transactions/{transactionId}/status:
    patch:
      tags:
        - Transactions
      summary: Actualizar el estado de una transacción
      operationId: updateTransactionStatus
      parameters:
        - name: transactionId
          in: path
          required: true
          schema:
            type: string
            format: uuid
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/StatusUpdateRequest'
      responses:
        '200':
          description: Estado actualizado exitosamente
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/TransactionResponse'
        '404':
          description: Transacción no encontrada
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/ErrorResponse'

components:
  schemas:
    TransactionRequest:
      type: object
      required:
        - accountId
        - transactionType
        - amount
        - currency
      properties:
        accountId:
          type: string
          description: ID de la cuenta asociada
          example: "ACC-12345"
        transactionType:
          type: string
          description: Tipo de transacción
          enum:
            - DEPOSIT
            - WITHDRAWAL
            - TRANSFER
            - PAYMENT
          example: "DEPOSIT"
        amount:
          type: number
          description: Monto de la transacción
          example: 1000.00
        currency:
          type: string
          description: Moneda de la transacción
          example: "USD"
        description:
          type: string
          description: Descripción opcional
          example: "Depósito inicial"

    TransactionResponse:
      type: object
      properties:
        id:
          type: string
          format: uuid
          description: ID único de la transacción
        accountId:
          type: string
          description: ID de la cuenta
        transactionType:
          type: string
          description: Tipo de transacción
        amount:
          type: number
          description: Monto
        currency:
          type: string
          description: Moneda
        status:
          type: string
          description: Estado de la transacción
          enum:
            - PENDING
            - PROCESSING
            - COMPLETED
            - FAILED
            - CANCELLED
        timestamp:
          type: string
          format: date-time
          description: Fecha y hora de la transacción
        description:
          type: string
          description: Descripción
        correlationId:
          type: string
          description: ID de correlación para trazabilidad
        createdAt:
          type: string
          format: date-time
          description: Fecha de creación
        updatedAt:
          type: string
          format: date-time
          description: Fecha de actualización

    StatusUpdateRequest:
      type: object
      required:
        - newStatus
      properties:
        newStatus:
          type: string
          description: Nuevo estado de la transacción
          enum:
            - PENDING
            - PROCESSING
            - COMPLETED
            - FAILED
            - CANCELLED
          example: "COMPLETED"

    ErrorResponse:
      type: object
      properties:
        error:
          type: string
          description: Código de error
        message:
          type: string
          description: Descripción del error
        timestamp:
          type: string
          format: date-time
          description: Fecha y hora del error
        path:
          type: string
          description: Ruta que generó el error

  securitySchemes:
    bearerAuth:
      type: http
      scheme: bearer
      bearerFormat: JWT

security:
  - bearerAuth: []

// === ARCHIVO: src/main/java/com/integracion/api/application/service/ApiService.java ===
package com.integracion.api.application.service;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.domain.port.TransactionRepository;
import com.integracion.api.infrastructure.dto.TransactionRequest;
import com.integracion.api.infrastructure.dto.TransactionResponse;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class ApiService {

    private static final Logger log = LoggerFactory.getLogger(ApiService.class);
    private static final String DEFAULT_CURRENCY = "USD";
    private static final String DEFAULT_STATUS = "PENDING";

    private final TransactionRepository transactionRepository;
    private final CircuitBreaker externalServiceCircuitBreaker;
    private final Retry externalServiceRetry;

    public ApiService(
            TransactionRepository transactionRepository,
            CircuitBreaker externalServiceCircuitBreaker,
            Retry externalServiceRetry) {
        this.transactionRepository = transactionRepository;
        this.externalServiceCircuitBreaker = externalServiceCircuitBreaker;
        this.externalServiceRetry = externalServiceRetry;
    }

    public Mono<TransactionResponse> createTransaction(TransactionRequest request) {
        log.info("Creating transaction for account: {}, type: {}", 
                request.accountId(), request.transactionType());

        String correlationId = generateCorrelationId();
        LocalDateTime now = LocalDateTime.now();

        Transaction transaction = new Transaction(
                UUID.randomUUID().toString(),
                request.accountId(),
                request.transactionType(),
                request.amount() != null ? request.amount() : BigDecimal.ZERO,
                request.currency() != null ? request.currency() : DEFAULT_CURRENCY,
                DEFAULT_STATUS,
                now,
                request.description(),
                correlationId,
                now,
                now
        );

        return transactionRepository.save(transaction)
                .map(TransactionResponse::fromDomain)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(result -> log.info("Transaction created successfully: {}", result.id()))
                .doOnError(error -> log.error("Failed to create transaction: {}", error.getMessage()));
    }

    public Flux<TransactionResponse> getAllTransactions(String accountId, String status) {
        log.info("Retrieving transactions - accountId: {}, status: {}", accountId, status);

        Flux<Transaction> transactionsFlux;

        if (accountId != null && !accountId.isBlank()) {
            transactionsFlux = transactionRepository.findByAccountId(accountId);
        } else if (status != null && !status.isBlank()) {
            transactionsFlux = transactionRepository.findByStatus(status);
        } else {
            transactionsFlux = Flux.empty();
        }

        return transactionsFlux
                .map(TransactionResponse::fromDomain)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnComplete(() -> log.info("Transactions retrieved successfully"))
                .doOnError(error -> log.error("Failed to retrieve transactions: {}", error.getMessage()));
    }

    public Mono<TransactionResponse> getTransactionById(String transactionId) {
        log.info("Retrieving transaction by ID: {}", transactionId);

        UUID uuid = UUID.fromString(transactionId);

        return transactionRepository.findById(uuid)
                .map(TransactionResponse::fromDomain)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(result -> log.info("Transaction retrieved: {}", transactionId))
                .doOnError(error -> log.error("Failed to retrieve transaction: {}", error.getMessage()));
    }

    public Mono<Void> deleteTransaction(String transactionId) {
        log.info("Deleting transaction: {}", transactionId);

        UUID uuid = UUID.fromString(transactionId);

        return transactionRepository.deleteById(uuid)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(result -> log.info("Transaction deleted: {}", transactionId))
                .doOnError(error -> log.error("Failed to delete transaction: {}", error.getMessage()));
    }

    public Mono<TransactionResponse> updateTransactionStatus(String transactionId, String newStatus) {
        log.info("Updating transaction status: {} to {}", transactionId, newStatus);

        UUID uuid = UUID.fromString(transactionId);

        return transactionRepository.updateStatus(uuid, newStatus)
                .map(TransactionResponse::fromDomain)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(result -> log.info("Transaction status updated: {}", transactionId))
                .doOnError(error -> log.error("Failed to update transaction status: {}", error.getMessage()));
    }

    public <T> Mono<T> executeWithResilience(Supplier<Mono<T>> operation, String operationName) {
        Supplier<Mono<T>> decoratedSupplier = CircuitBreaker.decorateSupplier(
                externalServiceCircuitBreaker,
                () -> operation.get()
        );

        decoratedSupplier = Retry.decorateSupplier(
                externalServiceRetry,
                decoratedSupplier
        );

        return decoratedSupplier.get()
                .doOnError(error -> log.error("Operation {} failed after retries and circuit breaker: {}", 
                        operationName, error.getMessage()))
                .onErrorResume(error -> Mono.empty());
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

    public Mono<Transaction> processExternalTransaction(Transaction transaction) {
        return executeWithResilience(
                () -> {
                    log.info("Processing external transaction: {}", transaction.id());
                    return Mono.just(transaction.withStatus("PROCESSING"));
                },
                "processExternalTransaction"
        );
    }

    public Mono<Boolean> validateExternalService(String serviceEndpoint) {
        return executeWithResilience(
                () -> {
                    log.info("Validating external service: {}", serviceEndpoint);
                    return Mono.just(true);
                },
                "validateExternalService"
        );
    }

    public Mono<Transaction> enrichTransactionWithExternalData(Transaction transaction) {
        return executeWithResilience(
                () -> {
                    log.info("Enriching transaction with external data: {}", transaction.id());
                    return Mono.just(transaction);
                },
                "enrichTransactionWithExternalData"
        );
    }

    public Flux<Transaction> syncTransactionsFromExternalSource(String sourceSystem) {
        log.info("Syncing transactions from external source: {}", sourceSystem);

        return executeWithResilience(
                () -> {
                    log.info("Executing sync from: {}", sourceSystem);
                    return Flux.empty();
                },
                "syncTransactionsFromExternalSource"
        );
    }

// === ARCHIVO: src/main/java/com/integracion/api/infrastructure/adapter/TransactionAdapter.java ===
package com.integracion.api.infrastructure.adapter;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.domain.port.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.UUID;

@Repository
public class TransactionAdapter implements TransactionRepository {

    private static final Logger log = LoggerFactory.getLogger(TransactionAdapter.class);

    private final WebClient webClient;
    private final String baseUrl;
    private final int maxRetries;
    private final Duration retryDelay;

    public TransactionAdapter(
            WebClient webClient,
            @Value("${external.transaction-service.base-url:http://localhost:8081}") String baseUrl,
            @Value("${external.transaction-service.max-retries:3}") int maxRetries,
            @Value("${external.transaction-service.retry-delay-ms:1000}") long retryDelayMs) {
        this.webClient = webClient;
        this.baseUrl = baseUrl;
        this.maxRetries = maxRetries;
        this.retryDelay = Duration.ofMillis(retryDelayMs);
    }

    @Override
    public Mono<Transaction> save(Transaction transaction) {
        return webClient
                .post()
                .uri(baseUrl + "/api/v1/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(transaction)
                .retrieve()
                .bodyToMono(Transaction.class)
                .doOnSuccess(result -> log.info("Transaction saved successfully: {}", result))
                .doOnError(error -> log.error("Failed to save transaction: {}", error.getMessage()))
                .retryWhen(Retry.backoff(maxRetries, retryDelay)
                        .filter(throwable -> throwable instanceof WebClientResponseException.ServiceUnavailable
                                || throwable instanceof WebClientResponseException.GatewayTimeout)
                        .doBeforeRetry(signal -> log.warn("Retrying save transaction, attempt: {}", signal.totalRetries() + 1)));
    }

    @Override
    public Mono<Transaction> findById(UUID transactionId) {
        return webClient
                .get()
                .uri(baseUrl + "/api/v1/transactions/{id}", transactionId)
                .retrieve()
                .bodyToMono(Transaction.class)
                .doOnSuccess(result -> log.info("Transaction found: {}", result))
                .onErrorResume(WebClientResponseException.NotFound.class,
                        e -> {
                            log.warn("Transaction not found with id: {}", transactionId);
                            return Mono.empty();
                        })
                .onErrorResume(WebClientResponseException.class,
                        e -> {
                            log.error("Error retrieving transaction {}: {}", transactionId, e.getMessage());
                            return Mono.error(e);
                        });
    }

    @Override
    public Flux<Transaction> findByAccountId(String accountId) {
        return webClient
                .get()
                .uri(baseUrl + "/api/v1/transactions/account/{accountId}", accountId)
                .retrieve()
                .bodyToFlux(Transaction.class)
                .doOnComplete(() -> log.info("Retrieved all transactions for account: {}", accountId))
                .onErrorResume(WebClientResponseException.class,
                        e -> {
                            log.error("Error retrieving transactions for account {}: {}", accountId, e.getMessage());
                            return Flux.empty();
                        });
    }

    @Override
    public Flux<Transaction> findByStatus(String status) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(baseUrl + "/api/v1/transactions")
                        .queryParam("status", status)
                        .build())
                .retrieve()
                .bodyToFlux(Transaction.class)
                .doOnComplete(() -> log.info("Retrieved all transactions with status: {}", status))
                .onErrorResume(WebClientResponseException.class,
                        e -> {
                            log.error("Error retrieving transactions by status {}: {}", status, e.getMessage());
                            return Flux.empty();
                        });
    }

    @Override
    public Mono<Void> deleteById(UUID transactionId) {
        return webClient
                .delete()
                .uri(baseUrl + "/api/v1/transactions/{id}", transactionId)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnSuccess(result -> log.info("Transaction deleted successfully: {}", transactionId))
                .doOnError(error -> log.error("Failed to delete transaction {}: {}", transactionId, error.getMessage()));
    }

    @Override
    public Mono<Transaction> updateStatus(UUID transactionId, String newStatus) {
        return webClient
                .patch()
                .uri(baseUrl + "/api/v1/transactions/{id}/status", transactionId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"status\":\"" + newStatus + "\"}")
                .retrieve()
                .bodyToMono(Transaction.class)
                .doOnSuccess(result -> log.info("Transaction status updated: {} -> {}", transactionId, newStatus))
                .doOnError(error -> log.error("Failed to update transaction status {}: {}", transactionId, error.getMessage()))
                .retryWhen(Retry.backoff(maxRetries, retryDelay)
                        .filter(throwable -> throwable instanceof WebClientResponseException.ServiceUnavailable));
    }
}

// === ARCHIVO: src/main/java/com/integracion/api/infrastructure/config/WebClientConfig.java ===
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

// === ARCHIVO: src/main/java/com/integracion/api/infrastructure/controller/TransactionController.java ===
package com.integracion.api.infrastructure.controller;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.domain.port.TransactionRepository;
import com.integracion.api.infrastructure.dto.TransactionRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@Tag(name = "Transacciones", description = "API para gestión de transacciones financieras")
public class TransactionController {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Crear transacción", description = "Crea una nueva transacción en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transacción creada exitosamente",
                    content = @Content(schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "createTransactionFallback")
    @Retry(name = "transactionService")
    public Mono<ResponseEntity<Transaction>> createTransaction(
            @Valid @RequestBody TransactionRequest request) {
        log.info("Creating transaction with type: {} and amount: {}", request.getType(), request.getAmount());

        Transaction transaction = new Transaction(
                UUID.randomUUID(),
                request.getType(),
                request.getAmount(),
                request.getAccountId(),
                request.getDescription(),
                request.getTimestamp(),
                "PENDING"
        );

        return transactionRepository.save(transaction)
                .map(saved -> ResponseEntity.status(HttpStatus.CREATED).body(saved))
                .doOnSuccess(result -> log.info("Transaction created with id: {}", result.getId()))
                .doOnError(error -> log.error("Error creating transaction: {}", error.getMessage()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Obtener transacción por ID", description = "Recupera una transacción específica por su identificador único")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transacción encontrada",
                    content = @Content(schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "getTransactionFallback")
    @Retry(name = "transactionService")
    public Mono<ResponseEntity<Transaction>> getTransaction(
            @Parameter(description = "ID único de la transacción", required = true)
            @PathVariable UUID id) {
        log.info("Fetching transaction with id: {}", id);

        return transactionRepository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .doOnSuccess(result -> {
                    if (result.getStatusCode() == HttpStatus.OK) {
                        log.info("Transaction found: {}", id);
                    } else {
                        log.warn("Transaction not found: {}", id);
                    }
                });
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Listar transacciones por estado", description = "Recupera todas las transacciones que coinciden con el estado especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de transacciones",
                    content = @Content(schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "listTransactionsByStatusFallback")
    @Retry(name = "transactionService")
    public Flux<Transaction> listTransactionsByStatus(
            @Parameter(description = "Estado de la transacción (PENDING, COMPLETED, FAILED)")
            @RequestParam(required = false) String status) {
        log.info("Listing transactions with status: {}", status);

        Flux<Transaction> transactions = (status != null && !status.isBlank())
                ? transactionRepository.findByStatus(status)
                : transactionRepository.findByStatus("PENDING");

        return transactions
                .doOnComplete(() -> log.info("Transactions listed successfully"))
                .doOnError(error -> log.error("Error listing transactions: {}", error.getMessage()));
    }

    @GetMapping(value = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Listar transacciones por cuenta", description = "Recupera todas las transacciones asociadas a una cuenta específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de transacciones de la cuenta",
                    content = @Content(implementation = Transaction.class)),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "listTransactionsByAccountFallback")
    @Retry(name = "transactionService")
    public Flux<Transaction> listTransactionsByAccount(
            @Parameter(description = "ID de la cuenta", required = true)
            @PathVariable String accountId) {
        log.info("Listing transactions for account: {}", accountId);

        return transactionRepository.findByAccountId(accountId)
                .doOnComplete(() -> log.info("Transactions for account {} listed successfully", accountId))
                .doOnError(error -> log.error("Error listing transactions for account {}: {}", accountId, error.getMessage()));
    }

    @PatchMapping(value = "/{id}/status", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Actualizar estado de transacción", description = "Actualiza el estado de una transacción existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transacción actualizada exitosamente",
                    content = @Content(schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "updateTransactionStatusFallback")
    @Retry(name = "transactionService")
    public Mono<ResponseEntity<Transaction>> updateTransactionStatus(
            @Parameter(description = "ID único de la transacción", required = true)
            @PathVariable UUID id,
            @Parameter(description = "Nuevo estado de la transacción", required = true)
            @RequestParam String status) {
        log.info("Updating transaction {} status to: {}", id, status);

        return transactionRepository.updateStatus(id, status)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .doOnSuccess(result -> log.info("Transaction {} status updated to: {}", id, status))
                .doOnError(error -> log.error("Error updating transaction {} status: {}", id, error.getMessage()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar transacción", description = "Elimina una transacción del sistema por su identificador único")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Transacción eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "deleteTransactionFallback")
    @Retry(name = "transactionService")
    public Mono<ResponseEntity<Void>> deleteTransaction(
            @Parameter(description = "ID único de la transacción", required = true)
            @PathVariable UUID id) {
        log.info("Deleting transaction with id: {}", id);

        return transactionRepository.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .doOnSuccess(result -> log.info("Transaction {} deleted successfully", id))
                .doOnError(error -> log.error("Error deleting transaction {}: {}", id, error.getMessage()));
    }

    private Mono<ResponseEntity<Transaction>> createTransactionFallback(TransactionRequest request, Throwable t) {
        log.error("Circuit breaker triggered for createTransaction: {}", t.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    private Mono<ResponseEntity<Transaction>> getTransactionFallback(UUID id, Throwable t) {
        log.error("Circuit breaker triggered for getTransaction({}): {}", id, t.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    private Flux<Transaction> listTransactionsByStatusFallback(String status, Throwable t) {
        log.error("Circuit breaker triggered for listTransactionsByStatus({}): {}", status, t.getMessage());
        return Flux.empty();
    }

    private Flux<Transaction> listTransactionsByAccountFallback(String accountId, Throwable t) {
        log.error("Circuit breaker triggered for listTransactionsByAccount({}): {}", accountId, t.getMessage());
        return Flux.empty();
    }

    private Mono<ResponseEntity<Transaction>> updateTransactionStatusFallback(UUID id, String status, Throwable t) {
        log.error("Circuit breaker triggered for updateTransactionStatus({}, {}): {}", id, status, t.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    private Mono<ResponseEntity<Void>> deleteTransactionFallback(UUID id, Throwable t) {
        log.error("Circuit breaker triggered for deleteTransaction({}): {}", id, t.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }
}

// === ARCHIVO: src/main/java/com/integracion/api/infrastructure/exception/GlobalExceptionHandler.java ===
package com.integracion.api.infrastructure.exception;

import com.integracion.api.infrastructure.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleValidationException(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed",
                errors,
                LocalDateTime.now()
        );
        
        return Mono.just(ResponseEntity.badRequest().body(errorResponse));
    }

    @ExceptionHandler(WebClientResponseException.NotFound.class)
    public Mono<ResponseEntity<ErrorResponse>> handleNotFound(WebClientResponseException.NotFound ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Resource not found",
                ex.getResponseBodyAsString(),
                LocalDateTime.now()
        );
        
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse));
    }

    @ExceptionHandler(WebClientResponseException.ServiceUnavailable.class)
    public Mono<ResponseEntity<ErrorResponse>> handleServiceUnavailable(WebClientResponseException.ServiceUnavailable ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                "External service unavailable",
                "The external microservice is currently unavailable. Please try again later.",
                LocalDateTime.now()
        );
        
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse));
    }

    @ExceptionHandler(WebClientResponseException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleWebClientException(WebClientResponseException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatusCode().value(),
                "External service error",
                ex.getResponseBodyAsString(),
                LocalDateTime.now()
        );
        
        return Mono.just(ResponseEntity.status(ex.getStatusCode()).body(errorResponse));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid argument",
                ex.getMessage(),
                LocalDateTime.now()
        );
        
        return Mono.just(ResponseEntity.badRequest().body(errorResponse));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorResponse>> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error",
                "An unexpected error occurred: " + ex.getMessage(),
                LocalDateTime.now()
        );
        
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse));
    }
}

// === ARCHIVO: src/main/java/com/integracion/api/infrastructure/dto/ErrorResponse.java ===
package com.integracion.api.infrastructure.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String error,
        String message,
        LocalDateTime timestamp
) {}

// === ARCHIVO: src/test/java/com/integracion/api/infrastructure/adapter/TransactionAdapterTest.java ===
package com.integracion.api.infrastructure.adapter;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.infrastructure.dto.TransactionRequest;
import com.integracion.api.infrastructure.dto.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionAdapterTest {

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    private TransactionAdapter transactionAdapter;

    private TransactionRequest validRequest;
    private TransactionResponse validResponse;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transactionAdapter = new TransactionAdapter(webClient);
        
        validRequest = new TransactionRequest(
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("1000.00"),
                "USD"
        );
        
        validResponse = new TransactionResponse(
                UUID.randomUUID().toString(),
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("1000.00"),
                "USD",
                "COMPLETED",
                LocalDateTime.now()
        );
        
        transaction = new Transaction(
                UUID.randomUUID(),
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("1000.00"),
                "USD",
                "COMPLETED",
                LocalDateTime.now()
        );
    }

    @Test
    void saveTransaction_success_returnsTransaction() {
        when(webClient.post()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions")).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.contentType(MediaType.APPLICATION_JSON)).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.bodyValue(any(TransactionRequest.class))).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(TransactionResponse.class)).thenReturn(Mono.just(validResponse));

        StepVerifier.create(transactionAdapter.saveTransaction(validRequest))
                .expectNextMatches(response -> response.transactionId().equals(validResponse.transactionId()))
                .verifyComplete();
    }

    @Test
    void getTransactionById_success_returnsTransaction() {
        String transactionId = UUID.randomUUID().toString();
        
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions/" + transactionId)).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(TransactionResponse.class)).thenReturn(Mono.just(validResponse));

        StepVerifier.create(transactionAdapter.getTransactionById(transactionId))
                .expectNextMatches(response -> response.transactionId().equals(transactionId))
                .verifyComplete();
    }

    @Test
    void getTransactionById_notFound_throwsException() {
        String transactionId = UUID.randomUUID().toString();
        
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions/" + transactionId)).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(TransactionResponse.class))
                .thenReturn(Mono.error(new WebClientResponseException(
                        "Not Found",
                        HttpStatus.NOT_FOUND.value(),
                        "Transaction not found",
                        null,
                        null,
                        null
                )));

        StepVerifier.create(transactionAdapter.getTransactionById(transactionId))
                .expectError(WebClientResponseException.NotFound.class)
                .verify();
    }

    @Test
    void updateTransactionStatus_success_returnsUpdatedTransaction() {
        String transactionId = UUID.randomUUID().toString();
        String newStatus = "COMPLETED";
        TransactionResponse updatedResponse = new TransactionResponse(
                transactionId,
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("1000.00"),
                "USD",
                newStatus,
                LocalDateTime.now()
        );

        when(webClient.patch()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions/" + transactionId + "/status"))
                .thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.contentType(MediaType.APPLICATION_JSON)).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.bodyValue(any())).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(TransactionResponse.class)).thenReturn(Mono.just(updatedResponse));

        StepVerifier.create(transactionAdapter.updateTransactionStatus(transactionId, newStatus))
                .expectNextMatches(response -> response.status().equals(newStatus))
                .verifyComplete();
    }

    @Test
    void deleteTransaction_success_completesWithoutError() {
        String transactionId = UUID.randomUUID().toString();
        
        when(webClient.delete()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions/" + transactionId))
                .thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.toBodilessEntity()).thenReturn(Mono.just(
                new org.springframework.http.ResponseEntity<>(HttpStatus.NO_CONTENT)
        ));

        StepVerifier.create(transactionAdapter.deleteTransaction(transactionId))
                .verifyComplete();
    }
}

// === ARCHIVO: src/test/java/com/integracion/api/application/service/ApiServiceTest.java ===
package com.integracion.api.application.service;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.domain.port.TransactionRepository;
import com.integracion.api.infrastructure.adapter.TransactionAdapter;
import com.integracion.api.infrastructure.dto.TransactionRequest;
import com.integracion.api.infrastructure.dto.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApiServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionAdapter transactionAdapter;

    private ApiService apiService;

    private Transaction sampleTransaction;
    private TransactionRequest sampleRequest;
    private TransactionResponse sampleResponse;

    @BeforeEach
    void setUp() {
        apiService = new ApiService(transactionRepository, transactionAdapter);
        
        sampleTransaction = new Transaction(
                UUID.randomUUID(),
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("500.00"),
                "EUR",
                "PENDING",
                LocalDateTime.now()
        );
        
        sampleRequest = new TransactionRequest(
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("500.00"),
                "EUR"
        );
        
        sampleResponse = new TransactionResponse(
                sampleTransaction.transactionId().toString(),
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("500.00"),
                "EUR",
                "PENDING",
                sampleTransaction.timestamp()
        );
    }

    @Test
    void processTransaction_success_returnsTransaction() {
        when(transactionAdapter.saveTransaction(any(TransactionRequest.class)))
                .thenReturn(Mono.just(sampleResponse));
        when(transactionRepository.save(any(Transaction.class)))
                .thenReturn(Mono.just(sampleTransaction));

        StepVerifier.create(apiService.processTransaction(sampleRequest))
                .expectNextMatches(tx -> tx.transactionId().equals(sampleTransaction.transactionId()))
                .verifyComplete();

        verify(transactionAdapter).saveTransaction(any(TransactionRequest.class));
        verify(transactionRepository).save(any(Transaction.class));
    }

    @Test
    void getTransactionById_success_returnsTransaction() {
        UUID transactionId = sampleTransaction.transactionId();
        
        when(transactionRepository.findById(transactionId))
                .thenReturn(Mono.just(sampleTransaction));

        StepVerifier.create(apiService.getTransactionById(transactionId.toString()))
                .expectNextMatches(tx -> tx.transactionId().equals(transactionId))
                .verifyComplete();
    }

    @Test
    void getTransactionsByAccount_success_returnsFluxOfTransactions() {
        String accountId = "ACC123";
        
        when(transactionRepository.findByAccountId(accountId))
                .thenReturn(Flux.just(sampleTransaction));

        StepVerifier.create(apiService.getTransactionsByAccount(accountId))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void getTransactionsByStatus_success_returnsFluxOfTransactions() {
        String status = "PENDING";
        
        when(transactionRepository.findByStatus(status))
                .thenReturn(Flux.just(sampleTransaction));

        StepVerifier.create(apiService.getTransactionsByStatus(status))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void updateTransactionStatus_success_returnsUpdatedTransaction() {
        UUID transactionId = sampleTransaction.transactionId();
        String newStatus = "COMPLETED";
        Transaction updatedTransaction = sampleTransaction.withStatus(newStatus);
        
        when(transactionRepository.updateStatus(transactionId, newStatus))
                .thenReturn(Mono.just(updatedTransaction));

        StepVerifier.create(apiService.updateTransactionStatus(transactionId.toString(), newStatus))
                .expectNextMatches(tx -> tx.status().equals(newStatus))
                .verifyComplete();
    }

    @Test
    void deleteTransaction_success_completes() {
        UUID transactionId = sampleTransaction.transactionId();
        
        when(transactionRepository.deleteById(transactionId))
                .thenReturn(Mono.empty());

        StepVerifier.create(apiService.deleteTransaction(transactionId.toString()))
                .verifyComplete();

        verify(transactionRepository).deleteById(transactionId);
    }

    @Test
    void processTransaction_adapterFails_propagatesError() {
        when(transactionAdapter.saveTransaction(any(TransactionRequest.class)))
                .thenReturn(Mono.error(new RuntimeException("External service error")));

        StepVerifier.create(apiService.processTransaction(sampleRequest))
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    void getTransactionById_notFound_returnsEmpty() {
        UUID transactionId = UUID.randomUUID();
        
        when(transactionRepository.findById(transactionId))
                .thenReturn(Mono.empty());

        StepVerifier.create(apiService.getTransactionById(transactionId.toString()))
                .verifyComplete();
    }
}

// === ARCHIVO: README.md ===
# API de Integración de Microservicios Financieros

Proyecto Spring Boot 3.5 con WebFlux reactivo para integración entre microservicios del dominio financiero.

## Requisitos Previos

- Java 21
- Maven 3.9+
- npm (para swagger-ui local, opcional)

## Configuración del Entorno

### Instalación de Java 21

```bash
# Verificar versión instalada
java -version

# Si no tienes Java 21, instala mediante SDKMAN
curl -s "https://get.sdkman.io" | bash
sdk install java 21.0.2-tem
```

### Instalación de Maven

```bash
# Verificar versión instalada
mvn -version

# Si no tienes Maven 3.9+, descarga desde https://maven.apache.org/download.cgi
```

## Compilación y Ejecución

### Compilar el Proyecto

```bash
mvn clean compile
```

### Ejecutar la Aplicación

```bash
mvn spring-boot:run
```

La aplicación arrancará en `http://localhost:8080`

### Ejecutar Tests

```bash
mvn test
```

### Construir JAR

```bash
mvn clean package -DskipTests
java -jar target/api-0.0.1-SNAPSHOT.jar
```

## Estructura del Proyecto

```
api/
├── src/main/java/com/integracion/api/
│   ├── ApiApplication.java              # Punto de entrada Spring Boot
│   ├── domain/
│   │   ├── model/
│   │   │   └── Transaction.java         # Modelo canónico del dominio
│   │   └── port/
│   │       └── TransactionRepository.java  # Contrato de persistencia
│   ├── application/
│   │   └── service/
│   │       └── ApiService.java          # Orquestación de casos de uso
│   └── infrastructure/
│       ├── adapter/
│       │   └── TransactionAdapter.java  # Implementación de repositorio
│       ├── config/
│       │   └── WebClientConfig.java     # Configuración de cliente HTTP
│       ├── controller/
│       │   └── TransactionController.java   # Endpoints REST
│       ├── dto/
│       │   ├── TransactionRequest.java  # DTO de request
│       │   └── TransactionResponse.java # DTO de response
│       └── exception/
│           └── GlobalExceptionHandler.java  # Manejo centralizado de errores
├── src/main/resources/
│   ├── application.yml                  # Configuración de la aplicación
│   └── api/
│       └── openapi.yaml                 # Contrato OpenAPI 3.1
└── src/test/java/
    └── com/integracion/api/
        ├── application/service/
        │   └── ApiServiceTest.java      # Tests unitarios de servicio
        └── infrastructure/adapter/
            └── TransactionAdapterTest.java  # Tests de adapter
```

## Arquitectura

### Patrón Hexagonal (Ports & Adapters)

```
┌─────────────────────────────────────────────────────────────────┐
│                        CAPA DE INTERFAZ                        │
│  ┌─────────────────────┐  ┌──────────────────────────────────┐ │
│  │ TransactionController│  │     GlobalExceptionHandler      │ │
│  │   (REST endpoints)   │  │    (manejo de errores)          │ │
│  └──────────┬──────────┘  └──────────────────────────────────┘ │
└─────────────┼───────────────────────────────────────────────────┘
              │
┌─────────────┼───────────────────────────────────────────────────┐
│             ▼           CAPA DE APLICACIÓN                      │
│  ┌─────────────────────────────────────────────────────────────┐│
│  │                      ApiService                             ││
│  │              (orquestación de casos de uso)                 ││
│  └──────────────────────────┬──────────────────────────────────┘│
└─────────────────────────────┼────────────────────────────────────┘
                              │
┌─────────────────────────────┼────────────────────────────────────┐
│                             ▼         CAPA DE DOMINIO           │
│  ┌────────────────────┐  ┌───────────────────────────────────┐  │
│  │    Transaction     │  │    TransactionRepository          │  │
│  │  (modelo canónico) │  │      (interfaz/port)              │  │
│  └────────────────────┘  └───────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘
                              │
┌─────────────────────────────┼────────────────────────────────────┐
│                             ▼    CAPA DE INFRAESTRUCTURA        │
│  ┌─────────────────────┐  ┌──────────────────────────────────┐  │
│  │  TransactionAdapter │  │      WebClientConfig             │  │
│  │ (implementación DB) │  │  (cliente HTTP con resiliencia)  │  │
│  └─────────────────────┘  └──────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘
```

### Flujo de Comunicación

1. **Petición HTTP** → `TransactionController` recibe request
2. **Validación** → DTO validado con Jakarta Validation
3. **Orquestación** → `ApiService` coordina lógica de negocio
4. **Persistencia** → `TransactionRepository` (port) → `TransactionAdapter` (adapter)
5. **Respuesta** → `TransactionResponse` retornado al cliente

## Endpoints Disponibles

La API expone los siguientes endpoints documentados en OpenAPI:

| Método | Path | Descripción |
|--------|------|-------------|
| POST | /api/transactions | Crear nueva transacción |
| GET | /api/transactions/{id} | Obtener transacción por ID |
| GET | /api/transactions | Listar transacciones con filtros |
| PUT | /api/transactions/{id}/status | Actualizar estado de transacción |
| DELETE | /api/transactions/{id} | Eliminar transacción |

### Documentación Interactiva

Una vez iniciada la aplicación:
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs
- **OpenAPI YAML**: http://localhost:8080/v3/api-docs.yaml

## Configuración

El archivo `application.yml` contiene la configuración principal:

```yaml
server:
  port: 8080

spring:
  application:
    name: api

resilience4j:
  circuitbreaker:
    instances:
      externalApi:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50

  retry:
    instances:
      externalApi:
        maxAttempts: 3
        waitDuration: 2s
        enableExponentialBackoff: true
        exponentialBackoffMultiplier: 2
```

## Tecnologías y Dependencias

- **Spring Boot 3.5.6** - Framework principal
- **Spring WebFlux** - Programación reactiva
- **Resilience4j 2.2.0** - Circuit Breaker y Retry
- **SpringDoc OpenAPI 2.6.0** - Documentación automática
- **Lombok 1.18.30** - Reducción de boilerplate
- **Jakarta Validation** - Validación de DTOs

## Referencias

- Documentación Spring Boot: https://spring.io/projects/spring-boot
- Guía de WebFlux: https://docs.spring.io/spring-framework/reference/web/webflux.html
- Documentación Resilience4j: https://resilience4j.readme.io/
- Especificación OpenAPI: https://spec.openapis.org/oas/v3.1.0
- SpringDoc OpenAPI: https://springdoc.org/

## Logs y Monitoreo

Los logs de la aplicación muestran información sobre:
- Inicio del contexto de Spring
- Registro de endpoints
- Fallos de Circuit Breaker
- Reintentos de llamadas externas

## Construcción de Imagen Docker

```bash
# Construir imagen
docker build -t integracion-api:latest .

# Ejecutar contenedor
docker run -p 8080:8080 integracion-api:latest
```

## Notas de Desarrollo

- El proyecto sigue arquitectura hexagonal con separación estricta de capas
- Los modelos del dominio no conocen la infraestructura
- Los adaptadores implementan contratos definidos en el dominio
- La configuración de resiliencia protege llamadas a sistemas externos
```
