package com.example.WeatherApp.database;

import com.example.WeatherApp.api.WeatherAppController;
import com.example.WeatherApp.model.CurrentWeather;

import java.io.IOException;

public class City implements CityInterface{
    CustomHashMap<City> data_collection = new CustomHashMap<>();

    public City() {
    }

    public String getTempInCelcius() {
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
