package com.example.WeatherApp.model;


import com.example.WeatherApp.model.CurrentWeatherInfo;
import com.example.WeatherApp.model.Location;

public class CurrentWeather {

    private Location location;
    private CurrentWeatherInfo current;
    private Day currentDay = null;

    public void setCurrent(CurrentWeatherInfo current) {
        this.current = current;
    }
    public void setCurrentDay(Day currentDay){
        this.currentDay = currentDay;
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
    
    public Day getCurrentDay(){
        return currentDay;
    }


    
    
}