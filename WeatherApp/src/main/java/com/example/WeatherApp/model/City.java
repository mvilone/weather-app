<<<<<<< HEAD:WeatherApp/src/main/java/com/example/WeatherApp/model/City.java
package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;
public class City implements CityInterface{
    CustomHashMap<City> data_collection = new CustomHashMap<>();
    CustomHashMap<Day> past_five_day = new CustomHashMap<>();
    CustomHashMap<Day> future_five_day = new CustomHashMap<>();
    public String getTempInCelcius(){
=======
package com.example.WeatherApp.database;

import com.example.WeatherApp.api.WeatherAppController;
import com.example.WeatherApp.model.CurrentWeather;

import java.io.IOException;

public class City implements CityInterface{
    CustomHashMap<City> data_collection = new CustomHashMap<>();

    public City() {
    }

    public String getTempInCelcius() {
>>>>>>> 7051ae407df0f055d4603eea483f0dc71efc2c08:WeatherApp/src/main/java/com/example/WeatherApp/database/City.java
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
