package com.example.WeatherApp.model;
import java.util.ArrayList;
import com.example.WeatherApp.database.CustomHashMap;

public class Forecast {
    ArrayList<Forecast> forecastday = new ArrayList<>();
    private ArrayList<Hour> hour = new ArrayList<>();
    private Day day = new Day();
    public Forecast(){
    }
    public ArrayList<Forecast> getForecastday(){
        return forecastday;
    }
    public ArrayList<Hour> getHour(){
        return hour;
    }
    public Day getDay(){
        return day;
    }
}
