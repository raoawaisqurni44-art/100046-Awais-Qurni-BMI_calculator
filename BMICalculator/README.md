# BMI Calculator - Android Application

A simple, accurate, and user-friendly BMI (Body Mass Index) Calculator application built for Android. This app allows users to calculate their BMI using either Metric or Imperial units and provides health category feedback based on the results.

## 🚀 Features

*   **Dual Unit Support:** Toggle easily between **Metric** (kg/cm) and **Imperial** (lb/ft) units.
*   **Accurate Calculation:** Uses standard BMI formulas for both measurement systems.
*   **Real-time Category Feedback:** Automatically determines if you are Underweight, Normal Weight, Overweight, or Obese with color-coded indicators.
*   **Splash Screen:** A professional entrance featuring the college logo.
*   **Modern UI:** Built using `CardView` and `Material Components` for a clean, responsive design.
*   **Reset Functionality:** Quickly clear all inputs and results to start a new calculation.

## 📸 Screenshots

| Splash Screen | Main Calculator | Results |
| :---: | :---: | :---: |
| ![Splash](app/src/main/res/layout/activity_splash.xml) | ![Main](app/src/main/res/layout/activity_main.xml) | ![Result](app/src/main/res/layout/activity_main.xml) |

*(Note: Screenshots are representations of the XML layouts)*

## 🛠️ Tech Stack

*   **Language:** Java
*   **IDE:** Android Studio
*   **UI Components:** XML, CardView, Material Design
*   **Min SDK:** 21 (Android 5.0 Lollipop)
*   **Target SDK:** 34 (Android 14)

## 📂 Project Structure

```text
BMICalculator/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/bmicalculator/
│   │   │   │   ├── MainActivity.java      # Core logic and unit handling
│   │   │   │   └── SplashActivity.java    # Splash screen logic
│   │   │   ├── res/
│   │   │   │   ├── layout/                # UI Layout files
│   │   │   │   ├── drawable/              # App icon and logos
│   │   │   │   └── values/                # Strings, Colors, Themes
│   │   │   └── AndroidManifest.xml        # App configuration
│   └── build.gradle                       # App-level dependencies
└── build.gradle                           # Project-level configuration
```

## 🧮 How to Use

1.  **Launch the App:** You will see the Splash screen for 3 seconds.
2.  **Select Units:** Choose between "Metric" or "Imperial" using the radio buttons.
3.  **Enter Data:**
    *   For **Metric**: Enter weight in kg and height in cm (e.g., 170).
    *   For **Imperial**: Enter weight in lb and height in ft (e.g., 5.7).
4.  **Calculate:** Tap the "Calculate" button to see your BMI and category.
5.  **Reset:** Tap "Reset" to clear everything.

## 📝 License

This project is for educational purposes.
