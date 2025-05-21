# 🧙 Harry Potter Mischief Managed

A simple Harry Potter lore app that uses the Harry Potter API to display a list of characters.

_Note: This project was built in just 4 hours, so some compromises were made and a few features are missing._

## 🎥 Demo Video
Check out a quick walkthrough of the app in action:
| Quick Walkthrough |
|-------------------|
| <video src="https://github.com/user-attachments/assets/9f14c517-0c29-43b3-8380-fbbc10d0ff91" />  |

## 🏁 Getting up and running

####  Run app

1. Download the latest version of Android Studio.
2. Open the `HarryPotterMischiefManaged` folder in Android Studio.
3. Run the project on an emulator or device.


## 🏰 Features

- Built entirely with Compose Multiplatform
- Allows changing theme dinamically based on user house
- Loads date in Android and iOS using Ktor
- Navigation implemented with Compose with parameters being passed
- MVI architecture for presentation layer
- Architecture segregated in layers
- Dependency injection with Koin

## 🌱 Code Quality and Testing

- Formatting and linting enforced with Spotless and ktlint, using custom Compose rules


#### 🧼 Auto-format with Spotless

Automatically fix code style issues and apply formatting:

    ./gradlew :composeApp:spotlessApply


## 🛠️ Tech Stack & Libraries
- 🌐 [Ktor](https://github.com/ktorio/ktor): Asynchronous networking and API calls (with multiplatform support)
- 🖼️ [Coil](https://github.com/coil-kt/coil): Modern image loading with support for Compose and Ktor
- 🧬 [Koin](https://insert-koin.io/): Lightweight dependency injection framework for Kotlin
- 🧩 [Jetpack Compose](https://developer.android.com/jetpack/compose): Declarative UI toolkit for modern Android and multiplatform apps
- 🧭 [Navigation-Compose](https://developer.android.com/jetpack/compose/navigation): Navigation for Compose-based UIs
- 💾 [Room](https://developer.android.com/training/data-storage/room): Local database with SQLite support and compile-time safety
- 🧱 [Multiplatform Kotlin](https://kotlinlang.org/docs/multiplatform.html): Shared logic across Android, iOS, and Desktop
- 🧼 [Spotless](https://github.com/diffplug/spotless): Code formatting and linting


