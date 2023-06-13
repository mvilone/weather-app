package com.example.WeatherApp.api_models;


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
