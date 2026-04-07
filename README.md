# RecipeRadar 🍳

**RecipeRadar** is a modern Android application built with **Jetpack Compose** and **MVVM Architecture**. It demonstrates industry-standard development practices, including reactive state management, RESTful API integration, and modular project structuring.

---

## 🏗 Architecture (MVVM)
The project is strictly organized to follow **Separation of Concerns**, making the codebase scalable and professional:

* **`data`**: Handles networking logic via **Retrofit** and defines the `ApiService`.
* **`model`**: Contains data schemas (POKOs) for `Category` and `Meal` objects.
* **`viewmodel`**: Manages UI state using **StateFlow** and handles asynchronous business logic with **Coroutines**.
* **`presentation`**: A fully declarative UI layer built with **Jetpack Compose**, utilizing a single-activity, multi-screen navigation pattern.

---

## 🚀 Key Features
* **Dynamic Discovery:** Fetches global food categories in real-time from TheMealDB API.
* **Smart Search:** Implemented a conditional UI that swaps between "Category View" and "Live Search Results" based on user input.
* **Dual-Detail Navigation:** Distinct navigation routes for Category descriptions and full Meal instructions.
* **Optimized Performance:** Uses **Coil** for asynchronous image caching and **Scaffold** for standard Material 3 layouts.

---

## 🛠 Tech Stack
* **Language:** Kotlin
* **Asynchronous:** Coroutines & StateFlow
* **Networking:** Retrofit 2 & Gson
* **UI:** Jetpack Compose (Material 3)
* **Image Loading:** Coil
* **Navigation:** Jetpack Compose Navigation

---

## 📸 Preview
| Home Screen | Search Results | Recipe Detail |
| :---: | :---: | :---: |
| ![Home](https://via.placeholder.com/200x400?text=Categories) | ![Search](https://via.placeholder.com/200x400?text=Search+Results) | ![Detail](https://via.placeholder.com/200x400?text=Instructions) |

---

## 📥 How to Run
1. Clone this repository: 
   ```bash
   git clone [https://github.com/Anisha956/RecipeRadar.git]
2.Open in Android Studio.

3.Ensure your device/emulator has internet access.

4.Build and Run.
