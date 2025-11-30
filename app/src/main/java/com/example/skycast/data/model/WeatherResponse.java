package com.example.skycast.data.model;

import java.util.List;
public class WeatherResponse {

    private String name;              // city name
    private SysInfo sys;              // country info
    private MainInfo main;            // temperatures, humidity
    private java.util.List<WeatherInfo> weather; // list, usually size 1
    private WindInfo wind;            // wind speed

    // Getters - Retrofit/Gson will use these
    public String getName() {
        return name;
    }

    public SysInfo getSys() {
        return sys;
    }

    public MainInfo getMain() {
        return main;
    }

    public List<WeatherInfo> getWeather() {
        return weather;
    }

    public WindInfo getWind() {
        return wind;
    }
}