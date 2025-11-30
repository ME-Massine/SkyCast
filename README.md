# 🌤️ **SkyCast — Android Weather App (Java + XML)**

SkyCast is a clean, modern Android weather application built with **Java**, **XML layouts**, and the **OpenWeather API**.  
The app provides real-time weather information, GPS-based auto-location, a modern Material UI, and a polished splash screen.

---

## 🚀 **Features**

### 🔍 Search Weather by City  
Type any city name and instantly fetch accurate weather data.

### 📍 Get Weather by Current Location  
Uses **FusedLocationProviderClient** to detect your GPS location and automatically show your local weather.

### 🎨 Modern UI (Material Design)  
- ConstraintLayout  
- MaterialCardView  
- Dark theme look  
- Clean typography  
- Weather icons loaded via Glide  

### 💡 Splash Screen  
Professional startup animation with fade-in transition.

### 🌐 API Integration  
- Built with **Retrofit2**  
- JSON parsing via **Gson Converter**  
- Fully asynchronous calls  
- Error handling & loading indicators  

---

## 🛠️ **Tech Stack**

| Category | Tools |
|---------|-------|
| Language | Java |
| UI | XML, ConstraintLayout, Material Components |
| Networking | Retrofit2, Gson Converter |
| Images | Glide |
| Location | FusedLocationProviderClient |
| Architecture | Simple MVC / clean package structure |
| API Provider | OpenWeatherMap |

---

## 📂 **Project Structure**

```
com.example.skycast
 ┣ data
 │  ┣ model
 │  │  ┣ WeatherResponse.java
 │  │  ┣ MainInfo.java
 │  │  ┣ WeatherInfo.java
 │  │  ┣ SysInfo.java
 │  │  ┗ WindInfo.java
 │  ┗ remote
 │     ┣ ApiClient.java
 │     ┗ WeatherService.java
 ┣ SplashActivity.java
 ┗ MainActivity.java
```

---

## 🔧 **Setup & Installation**

### 1. Clone the repository
```bash
git clone https://github.com/ME-Massine/skycast.git
cd skycast
```

### 2. Open in Android Studio  
Open the folder and let Gradle sync.

### 3. Add your OpenWeather API key  
Inside `MainActivity.java`, replace:

```java
private final String API_KEY = "YOUR_API_KEY_HERE";
```

with your actual key from  
https://openweathermap.org/api

### 4. Run the app  
Use an emulator or real device.  
Make sure the device has **Internet access**.

---

## 🗺️ **Endpoints Used**

### Current weather by city  
```
GET /data/2.5/weather?q={city}&appid={API_KEY}&units=metric
```

### Current weather by GPS coordinates  
```
GET /data/2.5/weather?lat={lat}&lon={lon}&appid={API_KEY}&units=metric
```

---

## 🧱 **How it Works**

- User enters a city → Retrofit sends a GET request → JSON parsed into `WeatherResponse` → data displayed in UI.
- For location weather, app requests **FINE_LOCATION** permission, uses `FusedLocationProviderClient` to get last known location, then calls the coordinate API.
- Icons are fetched dynamically from OpenWeather’s icon CDN using **Glide**.
- Splash screen uses a timed navigation with fade animation.

---

## ✨ **Future Improvements**

- 5-day weather forecast (RecyclerView)
- Favorite cities saved with Room database
- Light / Dark mode toggle
- Lottie animated splash
- Offline caching
- Full MVVM architecture (ViewModel + LiveData)
- Settings screen (units: Celsius / Fahrenheit)

---

## 🧑‍💻 **Author**

**ME-Massine**  
Android Developer • Java • Mobile Apps  
GitHub: https://github.com/ME-Massine  

---

## 📜 **License**

This project is licensed under the MIT License.

