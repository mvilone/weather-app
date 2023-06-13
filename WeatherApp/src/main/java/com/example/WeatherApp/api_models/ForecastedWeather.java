package com.example.WeatherApp.api_models;

public class ForecastedWeather {
    private Location location;
    private CurrentWeatherInfo current;
    private Forecast forecast;

    public void setCurrent(CurrentWeatherInfo current) {
        this.current = current;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CurrentWeatherInfo getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public Location getLocation() {
        return location;
    }
}
