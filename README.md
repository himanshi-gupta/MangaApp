# Manga Explorer

## Overview
This Android application was developed as part of an assignment following Clean Architecture + MVVM principles. The app features user authentication, manga data fetching & caching.

## Features
- **User Authentication**: Sign in with email and password
- **Manga Explorer**: Browse manga data from MangaVerse API with pagination and offline caching
- **Modern Android Development**: Uses Jetpack Compose, Single Activity Architecture, and Navigation Component

## Screenshots

### Sign In Screen
<img src="https://github.com/user-attachments/assets/46e78e35-13b9-45de-a5cc-9c763f513306" width="300" alt="Login Screen">

### Manga Explorer Screen
<img src="https://github.com/user-attachments/assets/ca519261-2537-4893-aa83-7baade6a33d6" width="300" alt="Home Screen">

### Manga Description Screen
<img src="https://github.com/user-attachments/assets/bad9fe3b-617c-497d-bcd5-b7772cd45a8b" width="300" alt="Manga Description Screen">

## Video Demo
[MangaApp.mp4](https://drive.google.com/file/d/1HPKH_XVVgqkWIowZ_3o6hz0YhCtH-sXM/view?usp=sharing)

## APK Download
[MangaApp.apk](https://drive.google.com/file/d/1PioiFDgdu4aCefdB7_dpAUvkLUuOromZ/view?usp=sharing)
## Technical Implementation

### Technologies Used
- **UI**: Jetpack Compose
- **Navigation**: Jetpack Navigation Component
- **Local Storage**: Room Database
- **Network**: Retrofit
- **Asynchronous Operations**: Kotlin Coroutines, Flow
- **Image Loading**: Coil

### Components

#### 1. User Authentication
- Room database for secure credential storage
- Auto-registration for new users
- Session persistence between app launches

#### 2. Manga Explorer
- Integration with MangaVerse API
- Pagination for efficient data loading
- Room database for offline caching
- Automatic sync when online

## Setup Instructions
1. Clone the repository
2. Open the project in Android Studio
3. Add your RapidAPI key for MangaVerse API in the appropriate configuration file
4. Build and run the application

## Requirements
- Android Studio Hedgehog or later
- Minimum SDK: API 24 
- Target SDK: API 34 

## Future Improvements
- Add unit and UI tests
- Implement user profile customization
- Add manga bookmarking feature
- Add face recognition with more features

## Credits
- [MangaVerse API](https://rapidapi.com/sagararofie/api/mangaverse-api)
- [MediaPipe Face Detection](https://ai.google.dev/edge/mediapipe/solutions/vision/face_detector/android)
