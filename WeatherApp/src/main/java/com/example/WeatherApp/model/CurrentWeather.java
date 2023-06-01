package com.example.WeatherApp.model;


import com.example.WeatherApp.model.CurrentWeatherInfo;
import com.example.WeatherApp.model.Location;

public class CurrentWeather {

    private Location locatio;
    private CurrentWeatherInfo current;

    public void setCurrent(CurrentWeatherInfo current) {
        this.current = current;
    }

    public void setLocation(Location location) {
        this.locatio = location;
    }

    public Location getLocation() {
        return locatio;
    }


    public CurrentWeatherInfo getCurrent() {
        return current;
    }
}