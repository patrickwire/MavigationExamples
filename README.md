# Mavigation Examples

Simple Android navigation example for university lecture demonstrating Jetpack Compose Navigation patterns.

## Overview

This project demonstrates modern Android navigation concepts:

- **State-based Navigation**: Different flows based on global app state
- **Graph Separation**: Modular navigation graphs (LoggedInGraph)
- **NavArgs**: Passing data between screens
- **DataStore**: Persistent storage for user input
- **Hilt DI**: Dependency injection for ViewModels

## App Flow

### Logged Out State
- Login screen with a login button
- Click login → Navigate to logged-in state

### Logged In State
- **Home Screen**: List of items 1-5, Settings button, Logout button
- **Detail Screen**: Click any item → Shows the number (NavArgs example)
- **Settings Screen**: Text input field with DataStore persistence
- **Logout**: Returns to login screen

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose + Material3
- **Navigation**: Navigation Compose
- **DI**: Hilt
- **Storage**: DataStore Preferences
- **Min SDK**: 30 (Android 11)
- **Target SDK**: 36

## Project Structure

```
app/src/main/java/.../mavigationexamples/
├── MainActivity.kt
├── MavigationApplication.kt
├── data/
│   └── SettingsDataStore.kt
├── navigation/
│   ├── Routes.kt
│   ├── AppNavigation.kt
│   └── LoggedInGraph.kt
├── ui/
│   ├── LoginScreen.kt
│   ├── HomeScreen.kt
│   ├── SettingsScreen.kt
│   └── DetailScreen.kt
└── viewmodels/
    └── AppViewModel.kt
```

## Build

```bash
./gradlew build
```

## Run

```bash
./gradlew installDebug
```

Or open in Android Studio and run.

## Key Concepts Demonstrated

1. **State-based Navigation**: Start destination determined by login state
2. **Graph Separation**: Logged-in screens organized in separate graph
3. **Shared ViewModel**: Global state accessible across screens via Hilt
4. **NavArgs**: Passing primitive data (numbers) between screens
5. **Back Stack Management**: Using `popUpTo` to prevent unwanted navigation
6. **DataStore Persistence**: Settings input persists across app restarts

## License

MIT

---

Built for educational purposes as a university lecture example.
