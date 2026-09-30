# Diseño y Mantenimiento de API en un Sistema de Integración

Como desarrollador de integraciones en una empresa de servicios financieros, debes crear y mantener una API que permita la comunicación entre diferentes microservicios. La API debe ser documentada adecuadamente y seguir patrones de bajo acoplamiento. Además, debes entender y aplicar el ciclo de vida de las API en tu trabajo.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Implementación SOA - API - MicroServicios |
| **Nivel** | advanced-l2 |
| **Tipo** | mixed |
| **Tiempo estimado** | 20 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Exploración del Sistema de Integración

**Objetivo:** Identificar las necesidades y restricciones del sistema de integración para el diseño de la API.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Analiza el sistema de integración existente para identificar los microservicios involucrados, sus responsabilidades y las interacciones necesarias.
- Identifica las restricciones y ambigüedades que pueden afectar el diseño de la API.

**Entregable:** Documento que detalla las necesidades y restricciones del sistema de integración para el diseño de la API.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las diferentes formas en que los microservicios pueden interactuar y cómo esto puede afectar el diseño de la API.
- Piensa en las posibles restricciones que pueden surgir de las interacciones entre microservicios y cómo pueden ser manejadas.

</details>

### Fase 2: Diseño de la API

**Objetivo:** Diseñar una API que permita la comunicación efectiva entre microservicios, siguiendo patrones de bajo acoplamiento.

**Tiempo estimado:** 8 horas

**Instrucciones:**

- Diseña una API que permita la comunicación entre los microservicios identificados en la fase anterior.
- Aplica patrones de bajo acoplamiento en el diseño de la API para asegurar su flexibilidad y mantenibilidad.

**Entregable:** Documento que detalla el diseño de la API, incluyendo los endpoints, métodos, parámetros y respuestas esperadas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo los patrones de bajo acoplamiento pueden ser aplicados en el diseño de la API para mejorar su flexibilidad y mantenibilidad.
- Piensa en las diferentes formas en que los microservicios pueden interactuar a través de la API y cómo esto puede afectar su diseño.

</details>

### Fase 3: Documentación de la API

**Objetivo:** Documentar adecuadamente la API para asegurar su entendimiento y uso correcto por parte de los desarrolladores.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Crea una documentación completa de la API que incluya una descripción de cada endpoint, los métodos permitidos, los parámetros requeridos y las respuestas esperadas.
- Asegura que la documentación sea clara, concisa y fácil de entender para los desarrolladores que utilizarán la API.

**Entregable:** Documentación completa de la API que incluye una descripción de cada endpoint, los métodos permitidos, los parámetros requeridos y las respuestas esperadas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo la documentación de la API puede ser mejorada para asegurar su entendimiento y uso correcto por parte de los desarrolladores.
- Piensa en las diferentes formas en que la documentación puede ser presentada para hacerla más clara y concisa.

</details>

### Fase 4: Implementación del Ciclo de Vida de la API

**Objetivo:** Implementar y mantener el ciclo de vida de la API, incluyendo su creación, evolución y retiro.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Implementa el ciclo de vida de la API, incluyendo su creación, evolución y retiro.
- Asegura que el ciclo de vida de la API sea documentado adecuadamente para guiar a los desarrolladores en su mantenimiento y evolución.

**Entregable:** Documento que detalla el ciclo de vida de la API, incluyendo su creación, evolución y retiro.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo el ciclo de vida de la API puede ser implementado para asegurar su mantenimiento y evolución a lo largo del tiempo.
- Piensa en las diferentes etapas del ciclo de vida de la API y cómo pueden ser documentadas para guiar a los desarrolladores en su mantenimiento y evolución.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una API y por qué es crucial en un sistema de integración?
- **paraQueSirve**: ¿Para qué sirve la documentación de una API y cómo puede mejorar su entendimiento y uso?
- **comoSeUsa**: ¿Cómo se implementa un patrón de bajo acoplamiento en el diseño de una API?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden surgir al diseñar y mantener una API y cómo pueden ser evitados?
- **queDecisionesImplica**: ¿Qué decisiones debes tomar al diseñar y mantener una API en un sistema de integración?

## Criterios de Evaluacion

- Identificación correcta de las necesidades y restricciones del sistema de integración.
- Diseño de una API que permita la comunicación efectiva entre microservicios, siguiendo patrones de bajo acoplamiento.
- Documentación adecuada de la API que incluya una descripción clara de cada endpoint, los métodos permitidos, los parámetros requeridos y las respuestas esperadas.
- Implementación y mantenimiento del ciclo de vida de la API, incluyendo su creación, evolución y retiro.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
npx --yes @redocly/cli lint src/main/resources/api/openapi.yaml
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
