package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;

public class City implements CityInterface{
    CurrentWeather currentweather = new CurrentWeather();
    CustomHashMap<Day> past_five_days = new CustomHashMap<>();
    CustomHashMap<Day> future_five_days = new CustomHashMap<>();

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
