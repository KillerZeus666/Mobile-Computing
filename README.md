# 📱 Taller Android - Consumo de API con Jetpack Compose  

Este proyecto es una aplicación móvil desarrollada en **Kotlin** utilizando **Jetpack Compose**.  
La app consume datos de la API pública [DummyJSON Users](https://dummyjson.com/users) y muestra una lista de usuarios.  

## ✨ Características  

- ✅ **Lista de usuarios** obtenida desde la API.  
- ✅ **Detalle de usuario** con:  
  - Foto de perfil  
  - Nombre  
  - Empresa  
  - Teléfono (con opción de llamada)  
  - Email  
  - Edad, género, altura y peso  
  - Universidad  
- ✅ Navegación entre lista y detalle usando **Navigation Compose**.  
- ✅ Diseño con **Material 3** y **Cards** estilizadas.  

## 🛠️ Tecnologías utilizadas  

- **Kotlin**  
- **Jetpack Compose**  
- **Material 3**  
- **Ktor Client** → para consumir la API  
- **Coil** → para carga de imágenes  
- **MVVM (ViewModel + Repository)**  

## 📂 Estructura del proyecto  

com.example.talleruno/
├── data/
│ ├── model/ # Modelos de datos (User, UsersResponse)
│ └── remote/ # Cliente HTTP y repositorio (ApiClient, UsersRepository)
├── ui/
│ ├── navigation/ # Configuración de navegación (AppNav.kt)
│ ├── screens/ # Pantallas (UsersListScreen.kt, UserDetailScreen.kt)
│ └── theme/ # Tema y estilos
├── HomeScreen.kt # Pantalla inicial
└── UsersViewModel.kt # Lógica de negocio (MVVM)
