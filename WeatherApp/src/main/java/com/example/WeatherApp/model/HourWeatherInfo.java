package com.example.WeatherApp.model;

public class HourWeatherInfo extends WeatherData{
    private String date;
    private double temp_c;
    private double temp_f;
    private double wind_mph;
    private double wind_kph;
     public double getTemp_c(){
        return temp_c;
    }
    public double getTemp_f(){
        return temp_f;
    }
    public double getWind_mph(){
        return wind_mph;
    }
    public double getWind_kph(){
        return wind_kph;
    }
    public void setTemp_c(double temp_c){
        this.temp_c = temp_c;
    }
    public void setTemp_f(double temp_f){
        this.temp_f = temp_f;
    }
    public void setWind_mph(double wind_mph){
        this.wind_mph = wind_mph;
    }
    public void setWind_kph(double wind_kph){
        this.wind_kph = wind_kph;
    }
    public String getDate(){
        return date;
    }
}
