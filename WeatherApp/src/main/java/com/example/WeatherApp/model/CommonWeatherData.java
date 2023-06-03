package com.example.WeatherApp.model;

public class CommonWeatherData {
    private double temp_c;
    private double temp_f;
    private double wind_mph;
    private double wind_kph;
    private Location location;
    private Forecast forecast;
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
    public Location getLocation(){
        return location;
    }
    public Forecast getForecast(){
        return forecast;
    }
    public int getHashCode(){
        return 0;
    }

    
}
