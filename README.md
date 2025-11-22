# My Meal App 🍽️

> An Android application built with Jetpack Compose that displays meal categories using TheMealDB API. This project demonstrates modern Android development practices including REST API integration, MVVM architecture, and Material Design 3.

## Screenshots

<p align="center">
  <img src="media/screenshot1.png" width="30%" />
  <img src="media/screenshot2.png" width="30%" />
  <img src="media/screenshot3.png" width="30%" />
</p>

---

## Features ✨

- 🌐 Browse meal categories from TheMealDB API
- 📱 Modern UI built with Jetpack Compose
- 🎨 Material Design 3 theming
- 🖼️ Efficient image loading with Coil
- 🧭 Navigation between screens
- 📊 MVVM architecture pattern
- 🔄 Asynchronous data fetching with Retrofit
- 💫 Smooth animations and transitions

---

## Technology Stack 🛠️

### Core Technologies
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Minimum SDK**: 29 (Android 10)
- **Target SDK**: 35

### Libraries & Dependencies
- **Retrofit** - REST API client for network requests
- **Gson** - JSON parsing and serialization
- **Coil** - Image loading and caching
- **Jetpack Compose** - Modern declarative UI
- **Material 3** - Material Design components
- **Navigation Component** - In-app navigation
- **ViewModel** - Lifecycle-aware data management

---

## API Information 🌐

This app uses [TheMealDB API](https://www.themealdb.com/api.php) to fetch meal categories.

- **Base URL**: `https://www.themealdb.com/api/json/v1/1/`
- **Endpoint Used**: `categories.php` - Retrieves all meal categories
- **API Version**: v1 (Free tier)

---

## Prerequisites 📋

Before you begin, ensure you have:

- **Android Studio**: Hedgehog (2023.1.1) or later
- **JDK**: Version 11 or higher
- **Gradle**: 8.0+ (included in project)
- **Internet Connection**: Required for API calls

---

## Installation & Setup 🚀

1. **Clone the repository**:
   ```bash
   git clone https://github.com/43H1-BOI/My_Meal_App.git
   cd My_Meal_App
   ```

2. **Open in Android Studio**:
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned repository folder
   - Click "OK"

3. **Sync Gradle**:
   - Android Studio will automatically prompt you to sync
   - If not, click "File" → "Sync Project with Gradle Files"

4. **Run the app**:
   - Connect an Android device or start an emulator
   - Click the "Run" button (▶️) or press `Shift + F10`
   - Select your device/emulator

---

## Project Structure 📂

```
app/src/main/java/com/the43h1/mymealapp/
├── MainActivity.kt          # Main entry point
├── MainViewModel.kt         # ViewModel for data management
├── ApiService.kt           # Retrofit API interface
├── Category.kt             # Data models
├── Screen/                 # UI screens
│   ├── HomeView.kt
│   ├── CategoriesView.kt
│   └── Screens.kt
├── Components/             # Reusable UI components
│   ├── CardView.kt
│   ├── LogoView.kt
│   ├── AnimatedIconButton.kt
│   └── ErrorScreen.kt
└── ui/theme/              # Theme and styling
```

---

## How to Use 📱

1. **Launch the app** on your Android device
2. **View Categories**: The home screen displays meal categories from TheMealDB
3. **Navigate**: Use the menu button to access the navigation drawer
4. **Browse**: Tap on category cards to explore different meal types
5. **Refresh**: Categories are automatically loaded when the app starts

---

## Contributing 🤝

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## License 📄

This project is available for educational purposes. Feel free to use and modify for learning Android development.

---

## Author 👨‍💻

**43H1-BOI**
- GitHub: [@43H1-BOI](https://github.com/43H1-BOI)
- Project Link: [https://github.com/43H1-BOI/My_Meal_App](https://github.com/43H1-BOI/My_Meal_App)

---

## Acknowledgments 🙏

- [TheMealDB](https://www.themealdb.com/) for providing the free meal API
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for the modern UI toolkit
- [Material Design](https://m3.material.io/) for design guidelines

---

**Note**: This is a learning project designed to explore JSON parsing, REST APIs, and modern Android development with Jetpack Compose.
