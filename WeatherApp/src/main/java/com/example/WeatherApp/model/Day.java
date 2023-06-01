package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;

public class Day{
    private City day_city;
    public CustomHashMap<Hour> twenty_4_hrs = new CustomHashMap<Hour>();
    private Forecast forecast;
    private Location location;
    public Day(){
        
    }
    public void set_days_city(City city){
        this.day_city = city;
    }
    public String toString(){

        return day_city.toString();
    }
    public Forecast getForecast(){
        return forecast;
    }
    public Location getLocation(){
        return location;
    }
    
    
}
