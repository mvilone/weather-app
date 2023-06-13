package com.example.WeatherApp.api_models;

public class Forecast {
    private ForecastDay forecastday[];

    public ForecastDay[] getForecastday() {
        return forecastday;
    }

    public void setForecastDay(ForecastDay forecastday[]) {
        this.forecastday = forecastday;
    }
}
