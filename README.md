# Cappuchino Awesome

App mobile que permite gestionar y consultar los horarios de clases de todas las carreras de la Facultad de Ciencias y Tecnología (UMSS).

**Versión:** 1.0
**Proyecto desarrollado para la postulación SCESI UMSS 2026 — Área de Programación Mobile**

---

## Pantallas

### 1. Home
Se observa el título de la aplicación con un botón para mostrar las carreras, obtenidas desde un JSON remoto. Cada carrera se presenta en un `Card` con función de click para navegar a su horario. En la parte superior izquierda se encuentra el botón de acceso a Ajustes.

### 2. Schedule
Tablero de horarios con las horas en una columna izquierda y los días en una fila superior.

**Header:**
- Nombre de la carrera seleccionada previamente
- Botón de navegación hacia atrás
- Botón de navegacipon a About me
- Menú de selección por niveles

**Sistema de filtrado por niveles:**
| Nivel | Contenido |
|-------|-----------|
| 1° | Semestres propios de la carrera |
| 2° | Materias del semestre seleccionado |
| 3° | Grupos disponibles de la materia seleccionada |

**Tabla dinámica:**
Renderiza `Card`s con el nombre de la materia y el código de grupo, ubicados en su hora y día correspondiente. Al hacer click sobre una card se abre un modal con información detallada: nombre de la materia, si es AUXILIATURA o no, aula y código del grupo.

### 3. About Me
Información sobre el desarrollador: presentación profesional corta, palabras de agradecimiento y enlaces a redes sociales.

### 4. Settings
Dos opciones disponibles para el usuario:
- Cambiar tema (claro / oscuro)
- Cambiar tipografía

---

## Arquitectura

El proyecto sigue el patrón **MVVM** (Model-View-ViewModel):

- **UI (Compose):** pantallas construidas con Jetpack Compose, sin lógica de negocio.
- **ViewModel:** expone estado mediante `StateFlow`, maneja la comunicación con la capa de red vía `viewModelScope`.
- **Network:** `Retrofit` + `ApiService` consumen un JSON estático con la información de carreras y horarios.
- **Navegación:** `Navigation3` con backstack manejado mediante `NavKey` (rutas serializables con `kotlinx.serialization`).

---

## Stack técnico

**Entorno de desarrollo**
- Android Studio Panda 4 | 2025.3.4
- Kotlin 2.2.10
- SDK: <!-- TODO: confirmar compileSdk/targetSdk reales del build.gradle.kts -->

**Librerías principales**
| Librería | Versión |
|----------|---------|
| Navigation3 | 1.1.2 |
| Retrofit | 3.0.0 |
| Lifecycle ViewModel Compose | 2.10.0 |

---

## Cómo correr el proyecto

```bash
git clone <URL_DEL_REPO>
```

1. Abrir el proyecto en Android Studio (Panda 4 o superior).
2. Sincronizar Gradle.
3. Ejecutar en un emulador o dispositivo físico con API mínima <!-- TODO: minSdk -->.

---

## Fuente de datos

JSON estatico proporcionado por Cappuchino

---

## Pendientes

- [ ] Persistencia local con Room
- [ ] Inyección de dependencias para tests de ui con Maestro

---

## Autor

Desarrollado por Bochito(Jhosua Alejandro Bustillos Caldereron)— estudiante de Ingeniería Informática, UMSS.
Gracias a SCESI por el apoyo y el mentor Saúl por la guía durante el desarrollo.
