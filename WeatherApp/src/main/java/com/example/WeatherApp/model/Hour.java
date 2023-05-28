package com.example.WeatherApp.model;

public class Hour extends Day{
    private double temperature;
    private double windSpeed;
    private Condition weather_condition;
    private String responseApi;
    public Hour(String responseApi){
        this.responseApi = responseApi;
        parse_responseApi();
    }
    public void parse_responseApi(){

    }
    public double getTempC(){
        return temperature;
    }
    public double getTempF(){
        return (temperature * (9/5)) + 32;
    }
    public double getWindSpeedkmh(){
        return windSpeed;
    }
    public double getWindSpeedmph(){
        return (windSpeed * (5/8));
    }
    public Condition getWeatherCondition(){
        return weather_condition;
    }
    public String getResponseApi(){
        return responseApi;
    }
}
