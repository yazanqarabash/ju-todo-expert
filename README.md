# Todo Expert App

An Android todo-list application built with Jetpack Compose, allowing users to create, view, edit, and delete tasks.

## Project Information

- **Package Name**: `com.example.todoexpert`
- **Language**: Kotlin
- **Framework**: Jetpack Compose
- **Jetpack Compose BOM Version**: 2024.04.01
- **Compile SDK Version**: 34
- **Min SDK Version**: 24
- **Target SDK Version**: 34
- **Java Compatibility**: 11
- **Kotlin JVM Target**: 11
- **Application Version**: 1.0 (Version Code: 1)

## Dependencies
Here are the key dependencies and their versions:

- **Kotlin Version**: 2.0.0
- **Android Gradle Plugin (AGP) Version**: 8.7.2
- **Core Libraries**:
  - **androidx.core:core-ktx**: 1.10.1
  - **androidx.lifecycle:lifecycle-runtime-ktx**: 2.6.1
  - **androidx.activity:activity-compose**: 1.8.0
- **UI Libraries**:
  - **Compose BOM**: 2024.04.01
  - **androidx.compose.ui:ui**
  - **androidx.compose.ui:ui-graphics**
  - **androidx.compose.ui:ui-tooling-preview**
  - **androidx.compose.material3:material3**
  - **androidx.navigation:navigation-compose**: 2.8.3
- **Testing Libraries**:
  - **JUnit**: 4.13.2
  - **AndroidX JUnit**: 1.1.5
  - **Espresso Core**: 3.5.1
  - **Compose UI Testing (JUnit 4)**: included in Compose BOM

Refer to `gradle/libs.versions.toml` for the full list of dependencies and their versions.

## Setup Instructions
1. **Android Studio**: Requires **Android Studio Flamingo 2023.1.1** or newer.
2. **Dependencies**: Run `./gradlew build` to ensure all dependencies are properly installed.
3. **Kotlin/Compose Updates**: For major updates to Kotlin or Jetpack Compose, refer to official migration guides ([Compose migration](https://developer.android.com/jetpack/compose/upgrade-guide) and [Kotlin upgrade](https://kotlinlang.org/docs/whatsnew.html)).

## Important Version Information
- **Last updated on**: 2024.11.13
- **Kotlin Version**: 2.0.0
- **Gradle Version**: 8.7.2
- **AGP (Android Gradle Plugin) Version**: 8.7.2
- **Jetpack Compose Version (BOM)**: 2024.04.01
- **Material3 Version**: 1.0.1

## Known Issues
- Compose UI Tooling may have limited functionality on API levels below 24.
- Some animations may not work as intended on emulators with low graphics acceleration.

## Future Updates
- Consider upgrading to Material3 version 1.2+ for better dark mode support.
- Migrate to Jetpack Compose 2.x upon release to leverage new features and performance improvements.

## License
MIT License

## Fun Note: This README is AI generated :)
Happy Coding!
