package com.example.skycast.data.remote;   // adapt package if needed

import com.example.skycast.data.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    // GET https://api.openweathermap.org/data/2.5/weather?q=London&appid=KEY&units=metric
    @GET("weather")
    Call<WeatherResponse> getCurrentWeather(
            @Query("q") String cityName,
            @Query("appid") String apiKey,
            @Query("units") String units
    );
    @GET("weather")
    Call<WeatherResponse> getCurrentWeatherByCoordinates(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("appid") String apiKey,
            @Query("units") String units
    );

}
