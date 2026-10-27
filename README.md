# WIM 100 · Evaluación de candidatas (DYM Cyber)

App Android en **Kotlin + Jetpack Compose (Material 3)** con arquitectura **MVVM** y persistencia local con **Room**.
Proyecto de la asignatura **DSY1105 Desarrollo de Aplicaciones Móviles** (Duoc UC), Evaluación Parcial 2.

> MVP académico. Todos los datos son **ficticios**. No se usan datos reales de candidatas ni evaluadoras.

## Integrantes
| Nombre | Usuario GitHub | Paquete de trabajo |
|---|---|---|
| Agustín Boeri | [@aguboeri](https://github.com/aguboeri) | A: modelo, Room, repositorios, evaluación, biometría y pantallas de datos |
| _Nombre Apellido (Danae)_ | _@usuario_ | B: tema, navegación, formularios, recursos nativos de archivos, contacto y notificaciones |

**Tablero Trello:** [WIM 100 · App móvil (DSY1105)](https://trello.com/b/B9tkven5/wim-100-app-m%C3%B3vil-dsy1105)
**Reparto detallado:** [docs/REPARTO_TRABAJO.md](docs/REPARTO_TRABAJO.md)

## Problema y solución
DYM Cyber necesita evaluar candidatas de forma ordenada: registrar la postulación, que dos evaluadoras puntúen con la misma matriz, impedir evaluaciones duplicadas, consolidar un resultado y dejar trazabilidad de cada acción. La app cubre ese flujo para los perfiles **Evaluadora** y **Dirección**.

## Estado del proyecto
Estructura base lista (Gradle, paquetes MVVM y documentación). Las funcionalidades se agregan por ramas según el Trello.

- [ ] Sesión por rol (Evaluadora / Dirección)
- [ ] Registro de candidatas con formulario validado
- [ ] Matriz de evaluación (5 criterios) y observaciones
- [ ] Bloqueo de evaluaciones duplicadas
- [ ] Resultados consolidados y resolución por Dirección
- [ ] Historial (trazabilidad)
- [ ] Animaciones
- [ ] Recurso nativo 1: CV en PDF (Storage Access Framework + PdfRenderer)
- [ ] Recurso nativo 2: intents de contacto
- [ ] Recurso nativo 3: biometría
- [ ] Recurso nativo 4: notificaciones

## Arquitectura
```
app/src/main/java/com/example/appsemestral/
├── model/        Entidades y clases de datos
├── data/         Room (DAO, base de datos) y repositorios
├── di/           Contenedor de dependencias
├── validation/   Validadores de formularios
├── nativo/       Recursos nativos (biometría, notificaciones, archivos, intents)
├── navigation/   Rutas y NavHost
├── ui/           Pantallas, componentes, tema y ViewModels (Compose)
└── util/         Utilidades
```
Flujo de datos: `Screen → ViewModel (StateFlow) → Repository → DAO → Room → Flow → Screen`.

## Cómo ejecutar
1. Android Studio actualizado (usa su JDK 21 incluido).
2. `File > Open` y elegir esta carpeta; esperar la sincronización de Gradle.
3. Crear un emulador (Device Manager) o conectar un teléfono Android.
4. Presionar **Run ▶**.

## Cómo trabajamos
Ramas por tarea, commits con descripción técnica y Pull Requests revisados por la otra integrante. Ver [docs/FLUJO_GIT.md](docs/FLUJO_GIT.md).

## Referencia y créditos
La configuración de Gradle y el diseño de referencia (reglas de negocio, capas y recursos nativos) parten del proyecto guía entregado por el docente Patricio:
<https://github.com/PatricioDuoc/Proyecto_Kotlin_WIM100>.
El código de las funcionalidades lo escribimos nosotros, adaptando y mejorando esa base (ver mejoras en el reparto de trabajo).
