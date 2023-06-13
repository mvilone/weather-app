package com.example.WeatherApp.database;

import com.example.WeatherApp.api.WeatherAppController;
import com.example.WeatherApp.api_models.CurrentWeatherInfo;
import com.example.WeatherApp.api_models.Forecast;
import com.example.WeatherApp.api_models.ForecastDay;
import com.example.WeatherApp.api_models.ForecastedWeather;

import java.io.IOException;

public class City implements CityInterface{
    CustomHashMap<City> data_collection = new CustomHashMap<>();


    public City() throws IOException {
    }

    public String getTempInCelcius() {
        return "";
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
    public static void main(String[] args) throws IOException {
        final Forecast weather = WeatherAppController.getForecastWeatherIPGrab().getForecast();

        ForecastDay day1 = weather.getForecastday()[0];
        ForecastDay day2 = weather.getForecastday()[1];
        ForecastDay day3 = weather.getForecastday()[2];
        ForecastDay day4 = weather.getForecastday()[3];
        ForecastDay day5 = weather.getForecastday()[4];

        System.out.println("Day 1:" + day1.getDate());
        System.out.println("Temp (F) high:" + day1.getDay().getMaxtemp_f());
        System.out.println("Temp (F) low:" + day1.getDay().getMintemp_f());
        System.out.println("Condition: " + day1.getDay().getCondition().getText());


        System.out.println("\n\nDay 2:" + day2.getDate());
        System.out.println("Temp (F) high:" + day2.getDay().getMaxtemp_f());
        System.out.println("Temp (F) low:" + day2.getDay().getMintemp_f());
        System.out.println("Condition: " + day2.getDay().getCondition().getText());

        System.out.println("\n\nDay 3:" + day3.getDate());
        System.out.println("Temp (F) high:" + day3.getDay().getMaxtemp_f());
        System.out.println("Temp (F) low:" + day3.getDay().getMintemp_f());
        System.out.println("Condition: " + day3.getDay().getCondition().getText());

        System.out.println("\n\nDay 4:" + day4.getDate());
        System.out.println("Temp (F) high:" + day4.getDay().getMaxtemp_f());
        System.out.println("Temp (F) low:" + day4.getDay().getMintemp_f());
        System.out.println("Condition: " + day4.getDay().getCondition().getText());

        System.out.println("\n\nDay 5:" + day5.getDate());
        System.out.println("Temp (F) high:" + day5.getDay().getMaxtemp_f());
        System.out.println("Temp (F) low:" + day5.getDay().getMintemp_f());
        System.out.println("Condition: " + day5.getDay().getCondition().getText());
    }
}
