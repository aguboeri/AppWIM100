# Reparto del trabajo (3 paquetes)

Cada paquete tiene un tamaño parecido (≈ 6-7 tarjetas) y toca todas las capas MVVM, de modo que cada integrante pueda explicar de punta a punta lo que hizo en la defensa individual.
Quién toma cuál paquete se decide en equipo; el orden dentro del paquete es sugerido.
La referencia es el proyecto guía del docente, que está en `docs/referencia-profe/` solo como apoyo (guía de práctica de defensa).

## Paquete A · Modelo, Room y reglas de negocio
1. Entidades, DAOs, base de datos y datos semilla (**hacerlo primero**: B y C dependen de esto).
2. HU05 · Bloqueo de evaluaciones duplicadas (transacción + índice único).
3. HU07 · Historial de acciones.
4. HU06 · Resultados consolidados y resolución por Dirección.
5. Lista de candidatas con búsqueda y filtro.
6. Mejora propia: evaluadora con id fijo + test de repositorio.

## Paquete B · Formularios, archivos y contacto
1. HU01 · Formulario de registro de candidata con validaciones.
2. Tests de validadores de candidata.
3. Recurso nativo: CV en PDF (SAF + PdfRenderer).
4. Recurso nativo: intents de contacto.
5. Pantalla de detalle y estados del proceso.
6. Animaciones y estados de interfaz (Guía 12).

## Paquete C · Navegación, sesión, evaluación y notificaciones
1. Navegación (NavHost) y estructura visual.
2. Tema Material 3 y componentes comunes (**hacerlo temprano**).
3. Sesión por rol + recurso nativo: biometría.
4. HU04 · Pantalla de evaluación con matriz de 5 criterios.
5. Cálculo de puntaje total + tests.
6. Recurso nativo: notificaciones.
7. Adaptabilidad del diseño (Guía 9).

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
