package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;
public class City implements CityInterface{
    CustomHashMap<City> data_collection = new CustomHashMap<>();
    CustomHashMap<Day> past_five_day = new CustomHashMap<>();
    CustomHashMap<Day> future_five_day = new CustomHashMap<>();
    public String getTempInCelcius(){
        return null;
    }
    public String getTempInFahrenheit(){
        return null;
    }
    public City getCity(){
        return null;
    }
    public boolean equals(){
        return false;
    }
    public static void main(String[] args){
        System.out.println("hello");
    }
    
}
