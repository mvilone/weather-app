package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;
import com.example.WeatherApp.api.WeatherAppController;

public class City implements CityInterface{
    private final int number_of_days = 5;
    private String city_name;
    CurrentWeather currentweather = new CurrentWeather();
    CustomHashMap<Day> past_five_days = new CustomHashMap<>();
    CustomHashMap<Day> future_five_days = new CustomHashMap<>();

    public City(String city_name){
        this.city_name = city_name;
        populate_hashes();
        try{
            currentweather = WeatherAppController.getCurrentWeatherCitySearch(city_name);
            System.out.println(currentweather.getCurrent().getTemp_c());
        }
        catch (Exception e){
            System.err.println("Error city not found");
        }
    }

    public void populate_hashes(){
        Day d1 = null;
        Day d2 = null;
        for(int x = 0; x < number_of_days; ++x){
            d1 = new Day();
            d2 = new Day();
            d1.set_days_city(this);
            d2.set_days_city(this);
            past_five_days.append_element(d1);
            future_five_days.append_element(d2);
        }
    }
    public String get_city_name(){
        return city_name;
    }
    public boolean equals(){
        return false;
    }
    public String toString(){
        return city_name;
    }
    public static void main(String[] args){
        City c = new City("chantilly");
        c.past_five_days.dispArray();
        c.future_five_days.dispArray();

    }
    
}
