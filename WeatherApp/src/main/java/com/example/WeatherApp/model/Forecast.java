package com.example.WeatherApp.model;
import java.util.ArrayList;
import com.example.WeatherApp.database.CustomHashMap;

import jakarta.persistence.Embedded;

public class Forecast extends WeatherData{
    private ArrayList<Forecast> forecastday = new ArrayList<>();
    private ArrayList<Hour> hour = new ArrayList<>();
    private Day day = new Day();
    public Forecast(){
    }
    
    @Embedded
    private Astro astro;
    public Astro getAstro() {
        return astro;
    }
    public void setAstro(Astro astro) {
        this.astro = astro;
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
