package com.example.skycast.data.model;

public class WeatherInfo {

    private String main;        // e.g. "Clouds"
    private String description; // e.g. "broken clouds"
    private String icon;        // icon code

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
