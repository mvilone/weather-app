package com.example.WeatherApp.model;


import com.example.WeatherApp.model.CurrentWeatherInfo;
import com.example.WeatherApp.model.Location;

public class CurrentWeather {

    private Location location;
    private CurrentWeatherInfo currentWeatherInfo;

    public void setCurrentWeatherInfo(CurrentWeatherInfo currentWeatherInfo) {
        this.currentWeatherInfo = currentWeatherInfo;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }


    public CurrentWeatherInfo getCurrentWeatherInfo() {
        return currentWeatherInfo;
    }
}
