Rick and Morty App 🚀

Una aplicación en **Kotlin + Jetpack Compose** que consume la API pública de **Rick and Morty** para mostrar información sobre **personajes, episodios y ubicaciones**. La app permite alternar entre **modo claro y oscuro** y ver los personajes residentes en cada ubicación.


📽️ **Demo Video**
[📺 Ver el video de la aplicación aquí](https://youtu.be/DJ5PRZni744)

---

📱 **Características Principales**
- 📜 **Lista de Personajes** con imagen, nombre, estado, especie y género.
- 🏠 **Lista de Ubicaciones** con tipo, dimensión y cantidad de residentes.
- 🎬 **Lista de Episodios** con nombre, fecha de estreno y personajes participantes.
- 🌎 **Residentes por Ubicación**, mostrando solo los personajes que viven en una ubicación seleccionada.
- 🌙 **Modo Oscuro / Claro**, con un botón en el Dashboard.
- 🔄 **Paginación Automática**, cargando todos los personajes disponibles.

---

🛠️ **Tecnologías Utilizadas**
- **Kotlin** - Lenguaje principal.
- **Jetpack Compose** - UI declarativa de Android.
- **Retrofit** - Consumo de la API REST.
- **Gson** - Conversión de JSON a objetos de Kotlin.
- **Coil** - Carga de imágenes.
- **Navigation Compose** - Navegación entre pantallas.
- **StateFlow** - Manejo de estados.

---

📦 **Instalación**
1️⃣ **Clona el repositorio:**
https://github.com/Alexistodj124/PruebaTecnicaKotlinRM

---

🚀 **Cómo Funciona la App**

- **Pantalla de Dashboard:**
Contiene botones para Personajes, Ubicaciones y Episodios.
Botón para alternar entre modo claro y oscuro.
- **Lista de Personajes:**
Muestra todos los personajes de Rick and Morty con su información.
Carga todos los personajes automáticamente desde la API.
- **Lista de Ubicaciones:**
Muestra las ubicaciones disponibles en la serie.
Si una ubicación tiene residentes, al hacer clic, se muestra la lista de personajes que viven ahí.
- **Lista de Episodios:**
Muestra episodios con fecha de emisión y personajes involucrados.
- **Personajes por Ubicación:**
Filtra los personajes que residen en una ubicación seleccionada.
