# ✨ StyleX - Personal Fashion Companion

**StyleX** is an Android app that provides personalized outfit recommendations based on your body shape, skin tone, and the occasion.

## 🎯 Features

- 🎨 **Personalized Recommendations** - Based on skin tone, body shape, gender, and age
- 👗 **18 Event Types** - Party, Office, Date, Beach, and more
- 💡 **Smart Fashion Advice** - Why each outfit works for your body type
- 🎨 **Color Matching** - Colors that complement your skin tone
- 👤 **User Profiles** - Save your preferences
- 🚀 **Offline First** - Works without internet

## 📱 Screenshots

<img width="1440" height="3120" alt="Login Page" src="https://github.com/user-attachments/assets/f3a6fdd8-a194-49cc-a910-32cb10e2660a" />
<img width="1440" height="3120" alt="Signin Page 1" src="https://github.com/user-attachments/assets/7b483024-ca1d-459c-a87c-edff26b2f501" />
<img width="1440" height="3120" alt="Signin Page 2" src="https://github.com/user-attachments/assets/0411399f-582e-4e4c-9e01-08ef407554f9" />
<img width="1440" height="3120" alt="Event Page 1" src="https://github.com/user-attachments/assets/b9c71097-dc93-4bd5-8a24-e56758ec8056" />
<img width="1440" height="3120" alt="Event page 2" src="https://github.com/user-attachments/assets/62d18321-3ed4-43ba-9363-943b53d89b66" />
<img width="1440" height="3120" alt="Example 1" src="https://github.com/user-attachments/assets/5feed00a-4538-4d96-b560-4e74ee006dfd" />
<img width="1440" height="3120" alt="Example 2" src="https://github.com/user-attachments/assets/de985572-2963-47ec-a35d-cf5ea3f61dcc" />
<img width="1440" height="3120" alt="Example 3" src="https://github.com/user-attachments/assets/cfd67d5e-a807-4289-8ca7-9ab564268a90" />
<img width="1440" height="3120" alt="Example 4" src="https://github.com/user-attachments/assets/2edd141d-5453-44b1-8c04-e2f35bb5abc5" />
<img width="1440" height="3120" alt="Profile Page" src="https://github.com/user-attachments/assets/0b456510-37e7-47a4-9c5a-82fe1ac96a53" />
<img width="1440" height="3120" alt="Logout Page" src="https://github.com/user-attachments/assets/a25548f3-b42b-4b7f-a7fc-7b1e1c690d13" />

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Navigation**: Navigation Component
- **Local Storage**: SharedPreferences
- **Design**: Material Design 3
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)

## 🏗️ Architecture
```
UI Layer (Compose) → ViewModel → Repository → Local Storage
```

## 📦 Project Structure
```
app/
├── src/main/
│   ├── java/com/stylex/app/
│   │   ├── MainActivity.kt
│   │   ├── data/
│   │   │   ├── UserRepository.kt
│   │   │   └── OutfitData.kt
│   │   ├── ui/
│   │   │   ├── auth/
│   │   │   ├── events/
│   │   │   ├── outfits/
│   │   │   ├── profile/
│   │   │   ├── splash/
│   │   │   └── theme/
│   │   └── navigation/
│   └── res/
└── build.gradle
```

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or later
- JDK 17
- Android SDK 34
- Gradle 8.2+

### Installation

1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/StyleX-App.git
```

2. Open project in Android Studio

3. Sync Gradle files

4. Run on emulator or device

## 🎨 Body Shapes Supported

**Female:**
- Hourglass
- Pear
- Apple
- Rectangle
- Inverted Triangle

**Male:**
- Triangle
- Inverted Triangle
- Rectangle
- Trapezoid

## 🎨 Skin Tones Supported

- Fair
- Medium
- Dark

## 📝 How It Works

1. **Sign Up** - Enter details (gender, age, skin tone, body shape)
2. **Choose Event** - Select occasion (party, office, date, etc.)
3. **Get Recommendations** - Receive personalized outfit suggestions
4. **View Details** - See why each piece works for you

## 🔐 Data Privacy

- All data stored **locally** on device
- No data sent to servers
- No tracking or analytics
- Complete privacy

## 📄 License

This project is licensed under the MIT License.

## 👨‍💻 Author

**Your Name**
- GitHub: VarshikaAI (https://github.com/VarshikaAI)

## 🙏 Acknowledgments

- Material Design 3 by Google
- Jetpack Compose documentation
- Android Developer community

## 📧 Contact

For questions or feedback, reach out at: varshikanarayan@gmail.com

---

Made with ❤️ and Kotlin
