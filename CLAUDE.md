# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Simple Android navigation demo with two states: logged out and logged in.

**Package**: `de.patrickwire.myapplication.mavigationexamples`
**Min SDK**: 30 (Android 11)
**Target SDK**: 36
**Java Version**: 11

## Build Commands

### Build the project
```bash
./gradlew build
```

### Run unit tests
```bash
./gradlew test
```

### Assemble debug APK
```bash
./gradlew assembleDebug
```

### Clean build
```bash
./gradlew clean
```

## Architecture

### Technology Stack
- **UI**: Jetpack Compose with Material3
- **Language**: Kotlin
- **Navigation**: Jetpack Navigation Compose
- **DI**: Hilt (for ViewModel injection)
- **State**: Simple Compose state (mutableStateOf)

### Project Structure
```
app/src/main/java/.../mavigationexamples/
├── MavigationApplication.kt        # Hilt application class
├── MainActivity.kt                  # Single activity entry point
├── navigation/
│   ├── Routes.kt                    # Route definitions
│   ├── AppNavigation.kt            # NavHost setup
│   └── LoggedInGraph.kt            # Logged-in state graph (Home + Detail)
├── ui/
│   ├── LoginScreen.kt              # Logged out state
│   ├── HomeScreen.kt               # Logged in - shows list 1-5
│   ├── DetailScreen.kt             # Shows selected number
│   └── theme/                       # Material3 theme
└── viewmodels/
    └── AppViewModel.kt             # Global login state
```

### App Flow

**Two States:**
1. **Logged Out** → Login screen with login button
2. **Logged In** → Home screen with:
   - List of items 1-5
   - Clicking item navigates to detail screen (shows the number)
   - Logout button

**State Management:**
- Simple `mutableStateOf` in AppViewModel
- Login/logout toggles the state
- Navigation start destination determined by login state
- **Note**: State resets when app closes (no persistence)

**Navigation:**
- Login screen → Home screen (popUpTo clears back stack)
- Home screen → Detail screen (passes number via NavArgs)
- Detail screen → Back button returns to Home
- Logout → Login screen (popUpTo clears back stack)

### Key Concepts Demonstrated

1. **State-based Navigation**: Different start destinations based on global state
2. **Graph Separation**: Logged-in screens organized in separate graph (LoggedInGraph.kt)
3. **Shared ViewModel**: Global state accessible across screens via Hilt
4. **NavArgs**: Passing primitive data (numbers) between screens
5. **Back Stack Management**: Using popUpTo to prevent unwanted navigation
6. **Hilt DI**: ViewModel injection

## Development Notes

**Build Fix:**
The project includes a JavaPoet version fix in root `build.gradle.kts` for Hilt compatibility with KSP.

**State Resets on App Close:**
Login state is not persisted - it resets when the app is closed. This keeps the example simple.

**Build Issues:**
If you encounter Gradle errors:
```bash
./gradlew --stop
./gradlew clean
./gradlew build
```
