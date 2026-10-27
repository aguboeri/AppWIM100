# Guía paso a paso del equipo

Esta guía explica cómo construimos la app **entre los dos**, cada una con sus propios commits en GitHub y sus tarjetas en Trello.
Está pensada para quien nunca ha trabajado en equipo con Git: sigue los pasos tal cual y pregunta si algo no calza.

## 1. Cómo funciona
- La app se construye en **21 pasos** ordenados. Cada paso es una funcionalidad pequeña con su carpeta, sus archivos y su `LEEME.md`.
- Cada paso lo hace **una persona**: crea una rama, copia los archivos, los prueba, hace su commit y abre un Pull Request.
- Cada paso corresponde a una tarjeta de Trello. Al empezar la mueves a *En curso*; al hacer merge, a *Finalizado*.
- Los commits salen de **tu propia cuenta de GitHub**. Así queda registrado el trabajo de cada uno.

Reparto (somos dos: Agustín es A y Danae es B):

| Persona | Pasos |
|---|---|
| A · Agustín | 01, 04, 05, 06, 09, 13, 15, 16, 18, 19, 20 |
| B · Danae | 02, 03, 07, 08, 10, 11, 12, 14, 17, 21 |

## 2. Preparar tu computador (Danae)
1. Instalar **Android Studio** (developer.android.com/studio). Trae el JDK que necesita el proyecto.
2. Instalar **Git para Windows** (git-scm.com/download/win), con las opciones por defecto.
3. Abrir PowerShell y configurar tu nombre y el **correo de tu cuenta de GitHub** (si no coincide, los commits no cuentan como tuyos):
```
git config --global user.name "Tu Nombre Apellido"
git config --global user.email "correo-de-tu-github@ejemplo.com"
git config --global --list
```
4. Aceptar la invitación al repositorio (llega al correo de GitHub) y al tablero de Trello.
5. Clonar el repo y entrar a la carpeta:
```
cd $HOME\AndroidStudioProjects
git clone https://github.com/aguboeri/AppWIM100.git
cd AppWIM100
```
6. Abrir esa carpeta en Android Studio (`File > Open`), esperar que termine **Gradle sync** y ejecutar en un emulador (Device Manager). Debe verse el texto "WIM 100".

## 3. Cómo se hace un paso (siempre igual)
1. Descomprime `paquetes.zip` en una carpeta **fuera** del repo (por ejemplo en el Escritorio).
2. Abre el `LEEME.md` de tu paso (carpeta `paso-NN-...`). Allí está todo: rama, archivos, ediciones manuales, commit.
3. Prepara: `git checkout main`, `git pull`, y crea tu rama con el nombre indicado.
4. Copia los archivos con el comando `Copy-Item` del LEEME.
5. Haz las **ediciones manuales** si el paso las pide (agregar unas líneas a un archivo que ya existe).
6. Abre el proyecto en Android Studio: compila (menú ☰ > `Build` > `Assemble Project`; en esta versión de Android Studio no existe "Make Project"). Al final debe decir **BUILD SUCCESSFUL**. Si el paso trae pruebas (`...Test.kt`), córrelas con clic derecho > Run.
7. Lee la sección **Para entenderlo** del LEEME. Si no entiendes algo, pregunta antes de seguir.
8. `git status`, `git add .`, `git commit -m "<mensaje del LEEME>"`, `git push -u origin <rama>`.
9. En GitHub: **Pull Request** hacia `main`, tu compañero/a lo revisa y hace **Merge**.
10. Mueve tu tarjeta de Trello a *Finalizado*.

## 4. Reglas
- **Dependencias:** cada `LEEME.md` dice qué pasos deben estar ya en `main` antes de empezar. Los pasos 01, 02 y 03 no dependen de nadie y se pueden hacer a la vez (Agustín el 01, Danae el 02 y el 03). Antes de empezar un paso: `git pull` y revisar que sus dependencias estén en `main`.
- **Un paso = una rama = un Pull Request = una tarjeta.**
- **Commits repartidos en el tiempo.** Hagan los pasos a lo largo de los días, no todos al final: es lo que mide la rúbrica de GitHub y Trello (20 %).
- **Entender antes de subir.** La defensa es individual, de 15 minutos y **sin IA**, con un cambio en vivo. Cada uno debe poder explicar y modificar los archivos de sus pasos. Usen los "Para entenderlo" y "Preguntas de defensa" de cada LEEME.
- **Datos ficticios siempre.** Nada de nombres, correos, teléfonos ni CV reales.
- **Después de la fecha de entrega no se toca el repositorio.**

### Orden sugerido (para que ninguna espere a la otra)
| Ronda | Agustín (A) | Danae (B) |
|---|---|---|
| 1 | 01 modelo y Room | 02 tema · 03 roles y rutas |
| 2 | 04 cálculo · 05 validación evaluación · 06 repositorios | 07 validación candidata · 08 componentes comunes |
| 3 | 09 lista · 13 biometría · 16 historial | 10 CV PDF · 12 intents · 14 notificaciones |
| 4 | 15 evaluación · 18 resultados · 19 perfil · 20 datos semilla | 11 formulario · 17 detalle |
| 5 | (revisar PRs y empezar su mejora propia) | 21 navegación (necesita todos los demás) |

Cada ronda se puede hacer en un día distinto: así los commits quedan repartidos en el tiempo.

## 5. Los 21 pasos
| Paso | Responsable | Rama | Mensaje de commit |
|---|---|---|---|
| 01 | Agustín (A) | `feature/modelo-room` | feat: agrega entidades Room, DAOs y base de datos |
| 02 | Danae (B) | `feature/tema` | style: agrega tema Material 3 |
| 03 | Danae (B) | `feature/roles-rutas` | feat: agrega roles, sesión y rutas de navegación |
| 04 | Agustín (A) | `feature/calculo-puntaje` | feat: agrega cálculo de puntaje ponderado con pruebas |
| 05 | Agustín (A) | `feature/validacion-evaluacion` | feat: agrega validación de evaluación con pruebas |
| 06 | Agustín (A) | `feature/repositorios` | feat: agrega repositorios y contenedor de dependencias |
| 07 | Danae (B) | `feature/validacion-candidata` | feat: agrega validación de datos de candidata con pruebas |
| 08 | Danae (B) | `feature/componentes-comunes` | feat: agrega formatos y componentes comunes de interfaz |
| 09 | Agustín (A) | `feature/lista-candidatas` | feat: agrega lista de candidatas con búsqueda y filtro por estado |
| 10 | Danae (B) | `feature/cv-pdf` | feat: agrega adjuntar CV en PDF con selector de documentos y visor |
| 11 | Danae (B) | `feature/formulario-candidata` | feat: agrega formulario de candidata con validaciones |
| 12 | Danae (B) | `feature/intents-contacto` | feat: agrega intents de contacto |
| 13 | Agustín (A) | `feature/login-biometria` | feat: agrega ingreso por rol con biometría |
| 14 | Danae (B) | `feature/notificaciones` | feat: agrega notificaciones locales al registrar evaluaciones |
| 15 | Agustín (A) | `feature/evaluacion` | feat: agrega pantalla de evaluación con matriz de 5 criterios |
| 16 | Agustín (A) | `feature/historial` | feat: agrega historial de acciones |
| 17 | Danae (B) | `feature/detalle-candidata` | feat: agrega pantalla de detalle de candidata |
| 18 | Agustín (A) | `feature/resultados` | feat: agrega resultados consolidados y resolución por Dirección |
| 19 | Agustín (A) | `feature/perfil` | feat: agrega pantalla de perfil |
| 20 | Agustín (A) | `feature/datos-semilla` | feat: agrega datos semilla ficticios |
| 21 | Danae (B) | `feature/navegacion` | feat: agrega navegación y estructura principal de la app |

Importante: la app **se ve completa recién en el paso 21** (navegación). Antes de eso, cada pantalla compila pero no se muestra; en el emulador seguirás viendo "WIM 100".

## 6. Lo que NO viene en los pasos (es trabajo propio de ustedes)
Los pasos reproducen la base del profe. Para que la app sea **de ustedes** y para sumar puntos, hagan estas mejoras, cada una en su paquete, con su rama, sus commits y su tarjeta de Trello:
- **Agustín (A) · Evaluadora con id fijo.** Hoy el duplicado se detecta por el nombre escrito: escribiendo otro nombre se puede evaluar dos veces. Crear una tabla de evaluadoras con id y usar ese id en el índice único. Agregar un test del repositorio.
- **Danae (B) · Animaciones propias.** Ya existen transiciones y la "sacudida" de errores. Agregar al menos una más (por ejemplo `AnimatedVisibility` al mostrar errores o un cambio de color según el estado) y explicar qué estado la dispara.
- **Danae (B) · Diseño adaptable (Guía 9).** Que las pantallas se vean bien en horizontal y en pantallas grandes. Probar girando el emulador.
- **Todos · Hacerla suya.** Cambien el nombre de la app, los colores, los textos y los criterios de la matriz si quieren. Actualicen el README (integrantes, usuarios de GitHub, funcionalidades marcadas).
- **Todos · Practicar la defensa** con `docs/referencia-profe/PRACTICA_DEFENSA.md`: agregar un campo con validación, una función en DAO + Repository y un composable nuevo.

## 7. Problemas comunes
| Mensaje o síntoma | Qué hacer |
|---|---|
| `fatal: not a git repository` | Estás en la carpeta equivocada. Haz `cd` hasta la carpeta `AppWIM100` (la que tiene `.git`). |
| `Unresolved reference` al compilar | Falta un paso anterior o una edición manual. Revisa que los pasos de los que depende estén en `main` y que hiciste las ediciones del LEEME. |
| `git pull` dice que hay conflictos | No sigas. Avisen al equipo: casi siempre es un archivo compartido (`AppViewModelProvider.kt`, `AppContainer.kt`, `WimApplication.kt` o el manifiesto). Se resuelve dejando ambos cambios. |
| `git push` pide usuario o contraseña | Inicia sesión con tu cuenta de GitHub (ventana del navegador). |
| `dubious ownership` | Ejecuta el comando que el propio mensaje te indica (`git config --global --add safe.directory ...`). |
| Gradle sync falla | Revisa tu conexión y que Android Studio use su JDK incluido. Si persiste, copia el error completo y pregunta. |
| La app se cierra al abrir | Mira **Logcat** (pestaña inferior de Android Studio) y busca la línea roja con `FATAL EXCEPTION`. |

## 8. Antes de entregar
- [ ] Los 21 pasos y las mejoras están en `main` y las tarjetas en *Finalizado*.
- [ ] README completo (integrantes con usuario de GitHub, funcionalidades, cómo ejecutar, créditos al proyecto guía).
- [ ] Repositorio **público** y enlace subido a AVA grupal; AVA individual activado con nombre, apellido, N° de equipo y nombre de la app.
- [ ] Trello con tarjetas reales y fechas.
- [ ] Cada uno ensayó su defensa de 15 minutos con un cambio en vivo.
