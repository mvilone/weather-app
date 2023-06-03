package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;
import com.example.WeatherApp.api.WeatherAppController;
//import com.example.WeatherApp.database.*;

public class City extends CommonWeatherData implements CityInterface{
    private final int number_of_days = 5;
    private String city_name;
    CurrentWeather currentweather = new CurrentWeather();
    CustomHashMap<Day> past_five_days = new CustomHashMap<>();
    CustomHashMap<Day> future_five_days = new CustomHashMap<>();
    public City(){
        this(null);
    }
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
    public void set_city_name(String city_name){
        this.city_name = city_name;
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
    public int getHashCode(){
        System.out.println("yolo");
        return get_city_name().toLowerCase().hashCode();
    }
    public boolean equals(Object other){
        System.out.println("tru");
        boolean equals_result = false;
        if(other instanceof String){
            System.out.println("yoko");
            equals_result = this.get_city_name().toLowerCase().equals(((String)other).toLowerCase());
        }
        else if(other instanceof City){
            equals_result = this.get_city_name().toLowerCase().equals(((City)other).get_city_name().toLowerCase());
        }
        return equals_result;
    }
    public static void main(String[] args){
        City c = new City("chantilly");
        CustomHashMap<City> array = new CustomHashMap<>();
        array.append_element(c);
        array.append_element(new City("Chantilly"));
        System.out.println(array.obtain_element("chAntillY").get_city_name() + " output");
        array.dispArray();
        //c.past_five_days.dispArray();
        //c.future_five_days.dispArray();

    }
    
}
