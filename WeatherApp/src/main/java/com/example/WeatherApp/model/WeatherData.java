package com.example.WeatherApp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class WeatherData {
    private String date;
    private Location location;
    private Forecast forecast;
    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setForecast(Forecast forecast){
        this.forecast = forecast;
    }
    public Forecast getForecast(){
        return forecast;
    }
    
    public int giveHashCode(){
        return 0;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    
}
