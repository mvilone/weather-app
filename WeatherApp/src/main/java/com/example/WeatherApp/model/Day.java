package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;

public class Day extends CommonWeatherData{
    private Integer day_number = 0;
    private City day_city;
    private String date;
    private double uv;
    public CustomHashMap<Hour> twenty_4_hrs = new CustomHashMap<Hour>();
    public Day(){
        
    }
    public void set_days_city(City city){
        this.day_city = city;
    }
    public String toString(){
        return "yolo";
    }
    public void set_Day_Number(int number){
        this.day_number = number;
    }
    public String getDate(){
        return date;
    }
    public int getHashCode(){
        return day_number.hashCode();
    }
    public double getUv(){
        return uv;
    }
    
    
}
