# Reparto del trabajo (2 integrantes)

El equipo se definió como **dos integrantes** (Agustín y Danae). El código se construye en 21 pasos (ver [GUIA_PASO_A_PASO.md](GUIA_PASO_A_PASO.md)); cada paso es una rama, un commit, un Pull Request y una tarjeta de Trello.
Cada integrante puede explicar de punta a punta lo que hizo, porque cada paquete toca varias capas MVVM.
La referencia es el proyecto guía del docente, que está en `docs/referencia-profe/` solo como apoyo (guía de práctica de defensa).

## Paquete A · Agustín — modelo, Room, reglas de negocio, evaluación y biometría
1. Paso 01 · `feature/modelo-room` — agrega entidades Room, DAOs y base de datos
2. Paso 04 · `feature/calculo-puntaje` — agrega cálculo de puntaje ponderado con pruebas
3. Paso 05 · `feature/validacion-evaluacion` — agrega validación de evaluación con pruebas
4. Paso 06 · `feature/repositorios` — agrega repositorios y contenedor de dependencias
5. Paso 09 · `feature/lista-candidatas` — agrega lista de candidatas con búsqueda y filtro por estado
6. Paso 13 · `feature/login-biometria` — agrega ingreso por rol con biometría
7. Paso 15 · `feature/evaluacion` — agrega pantalla de evaluación con matriz de 5 criterios
8. Paso 16 · `feature/historial` — agrega historial de acciones
9. Paso 18 · `feature/resultados` — agrega resultados consolidados y resolución por Dirección
10. Paso 19 · `feature/perfil` — agrega pantalla de perfil
11. Paso 20 · `feature/datos-semilla` — agrega datos semilla ficticios

Mejora propia: evaluadora con id fijo + test de repositorio.

## Paquete B · Danae — tema, navegación, formularios, archivos, contacto y notificaciones
1. Paso 02 · `feature/tema` — agrega tema Material 3
2. Paso 03 · `feature/roles-rutas` — agrega roles, sesión y rutas de navegación
3. Paso 07 · `feature/validacion-candidata` — agrega validación de datos de candidata con pruebas
4. Paso 08 · `feature/componentes-comunes` — agrega formatos y componentes comunes de interfaz
5. Paso 10 · `feature/cv-pdf` — agrega adjuntar CV en PDF con selector de documentos y visor
6. Paso 11 · `feature/formulario-candidata` — agrega formulario de candidata con validaciones
7. Paso 12 · `feature/intents-contacto` — agrega intents de contacto
8. Paso 14 · `feature/notificaciones` — agrega notificaciones locales al registrar evaluaciones
9. Paso 17 · `feature/detalle-candidata` — agrega pantalla de detalle de candidata
10. Paso 21 · `feature/navegacion` — agrega navegación y estructura principal de la app

Mejoras propias: animación adicional (Guía 12) y diseño adaptable (Guía 9).

### Orden sugerido (para que ninguna espere a la otra)
| Ronda | Agustín (A) | Danae (B) |
|---|---|---|
| 1 | 01 modelo y Room | 02 tema · 03 roles y rutas |
| 2 | 04 cálculo · 05 validación evaluación · 06 repositorios | 07 validación candidata · 08 componentes comunes |
| 3 | 09 lista · 13 biometría · 16 historial | 10 CV PDF · 12 intents · 14 notificaciones |
| 4 | 15 evaluación · 18 resultados · 19 perfil · 20 datos semilla | 11 formulario · 17 detalle |
| 5 | (revisar PRs y empezar su mejora propia) | 21 navegación (necesita todos los demás) |

Cada ronda se puede hacer en un día distinto: así los commits quedan repartidos en el tiempo.

## Reglas de negocio que usa el proyecto
- Puntaje 1–5 por criterio; 5 criterios con pesos 25/20/20/20/15.
- Total 0–100: `Σ(puntaje × peso) / (pesoTotal × 5) × 100`. Categorías: Sobresaliente ≥ 85, Sólida ≥ 70, En desarrollo ≥ 50.
- Observación por criterio obligatoria (≥ 10 caracteres) si el puntaje es ≤ 2; observación general de 20 a 400 caracteres.
- Duplicado: misma candidata + misma evaluadora. Doble barrera: consulta previa dentro de una transacción e índice único en Room.
- Estados: Postulada → En evaluación → Evaluada (≥ 2 evaluaciones) → Seleccionada / No seleccionada (solo Dirección).
- Datos ficticios: correos `ejemplo.cl`, `example.com`, `test.cl`; teléfono `+56 9 XXXX XXXX`; CV en PDF de máximo 5 MB.

## Mejoras planificadas sobre el proyecto guía
| Punto débil del proyecto guía | Mejora que proponemos |
|---|---|
| Cualquiera elige su rol sin verificación | Biometría para el rol Dirección |
| La evaluadora se identifica por el nombre escrito | Evaluadora con id fijo |
| Migración destructiva de Room | Migraciones reales al cambiar el esquema |
| Pocas pruebas unitarias | Tests de validadores, cálculo y repositorio |
