package com.example.WeatherApp.model;


import com.example.WeatherApp.model.CurrentWeatherInfo;
import com.example.WeatherApp.model.Location;

public class CurrentWeather {

    private Location location;
    private CurrentWeatherInfo current;

    public void setCurrent(CurrentWeatherInfo current) {
        this.current = current;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }


    public CurrentWeatherInfo getCurrent() {
        return current;
    }
}