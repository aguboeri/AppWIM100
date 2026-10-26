# Cómo trabajamos en Git

## Ramas
- `main`: siempre funciona. Nadie sube directo a main.
- `feature/<tema>`: una rama por tarea (ej: `feature/login`, `feature/formulario-candidata`, `feature/room-evaluaciones`).

## Ciclo de trabajo (cada integrante, cada tarea)
```bash
git checkout main
git pull                              # traer lo último
git checkout -b feature/login         # crear mi rama
# ... programar ...
git add .
git commit -m "feat: agrega validación de nombre en LoginViewModel"
git push -u origin feature/login      # subir la rama
```
Luego en GitHub: **Pull Request** hacia `main`, otra integrante lo revisa y hace **Merge**.

## Mensajes de commit (la rúbrica exige descripciones técnicas)
Formato: `tipo: qué cambió y dónde`
| Tipo | Cuándo | Ejemplo |
|---|---|---|
| feat | funcionalidad nueva | `feat: agrega ranking consolidado en ResultadosViewModel` |
| fix | corregir un error | `fix: corrige crash al cancelar el selector de PDF` |
| refactor | ordenar sin cambiar el comportamiento | `refactor: mueve validaciones a CandidataValidator` |
| style | solo visual | `style: aplica tema Material 3 a la pantalla de login` |
| test | pruebas | `test: agrega pruebas de EvaluacionValidator` |
| docs | documentación | `docs: completa README con integrantes` |

**Mal:** `cambios`, `listo`, `arreglé cosas`, `final2`. **Bien:** dice qué y dónde.

## Reglas del equipo
1. Cada integrante hace commits desde **su propia cuenta** (se revisa participación).
2. Commits pequeños y frecuentes, repartidos durante las semanas, no todos el último día.
3. Cada tarea del Trello = una rama = un PR.
4. Antes de abrir un PR: la app compila y corre.
5. **Después de la fecha de entrega NO se toca el repositorio** (cualquier cambio = nota 1.0 hasta la evaluación).
6. Nunca subir claves, tokens ni datos reales.
