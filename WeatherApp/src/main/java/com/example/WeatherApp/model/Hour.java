package com.example.WeatherApp.model;
public class Hour extends CommonWeatherData{
    private Location location = new Location();
    
    public Hour(){
        
        
    }
    public void setCommonWeatherData(Location s){
        this.location = s;
    }
    public Location getLocation(){
        return location;
    }

    
}
