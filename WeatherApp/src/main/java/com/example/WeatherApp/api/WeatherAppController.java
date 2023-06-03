package com.example.WeatherApp.api;

import java.util.Date;
import java.util.ArrayList;
import com.example.WeatherApp.model.*;
import com.example.WeatherApp.database.CustomHashMap;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class WeatherAppController {

    private static final String  APIKEY = "<REMOVED>";
    private static final int NUMBER_OF_SEC_HR = 3600;

    @RequestMapping("/home")
    public static CurrentWeather getCurrentWeatherIPGrab() throws IOException {
        String url = "http://api.weatherapi.com/v1/current.json?key="+APIKEY+"&q=auto:ip";

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(url, String.class);

        final ObjectMapper objectMapper = new ObjectMapper();
        final CurrentWeather currentWeather = objectMapper.readValue(response.getBody(), CurrentWeather.class);

        return currentWeather;
    }

    public static CurrentWeather getCurrentWeatherCitySearch(String cityName) throws IOException {
        String url = "http://api.weatherapi.com/v1/current.json?key="+APIKEY+"&q="+cityName;

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(url, String.class);

        final ObjectMapper objectMapper = new ObjectMapper();
        final CurrentWeather currentWeather = objectMapper.readValue(response.getBody(), CurrentWeather.class);

        return currentWeather;
    }

    public static CurrentWeather getCurrentWeatherZipcodeSearch(int zipcode) throws IOException {
        String url = "http://api.weatherapi.com/v1/current.json?key="+APIKEY+"&q="+String.valueOf(zipcode);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(url, String.class);

        final ObjectMapper objectMapper = new ObjectMapper();
        final CurrentWeather currentWeather = objectMapper.readValue(response.getBody(), CurrentWeather.class);

        return currentWeather;
    }
    public static City getPreviousDaysForCity(String cityName, int xDay) throws IOException{
        CurrentWeather current = getCurrentWeatherCitySearch(cityName);
        int unix_date_time = current.getLocation().getLocaltime_epoch();
        int number_of_secondInXDay = (NUMBER_OF_SEC_HR * 24) * xDay;
        unix_date_time -= (number_of_secondInXDay);
        final ObjectMapper objectMapper = new ObjectMapper();
        String url = "http://api.weatherapi.com/v1/history.json?key="+APIKEY+"&q="+cityName+"&dt="+"2023-05-01";
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(url, String.class);
        //System.out.println(response + "yolo");
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //City instanceCity = new City(cityName);
        System.out.println(response);
        City instanceCity = objectMapper.readValue(response.getBody(), City.class);
        instanceCity.set_city_name(cityName);
        System.out.println(instanceCity.getForecast().getForecastday().get(0).getDay() +" hello");
        Day current_day = instanceCity.getForecast().getForecastday().get(0).getDay();
        System.out.println(current_day.getUv()+" hello");
        return instanceCity;
    } 
    public static Day getCityHourlyWeatherForDay(String cityName, String date) throws IOException{
        final ObjectMapper objectMapper = new ObjectMapper();
        String url = "http://api.weatherapi.com/v1/history.json?key="+APIKEY+"&q="+cityName+"&dt="+date;
        RestTemplate rt = new RestTemplate();
        //System.out.println(city.getLocation().getLocaltime());
        ResponseEntity<String> response = rt.getForEntity(url, String.class);
        //System.out.println(response);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Day instanceDay  = objectMapper.readValue(response.getBody(), Day.class);
        
        ArrayList<Hour> twenty_4_hr = instanceDay.getForecast().getForecastday().get(0).getHour();
        int hour_number = 1;
        for(Hour x: twenty_4_hr){
            x.set_Hour_Number(hour_number);
            instanceDay.twenty_4_hrs.append_element(x);
            hour_number += 1;
        }
        System.out.println(instanceDay.twenty_4_hrs.obtain_element(1).getTime());
        return instanceDay;
        
    }
    public static void main(String [] args) throws IOException{
        getPreviousDaysForCity("chantilly", 5);
        getCityHourlyWeatherForDay("chantilly", "2023-06-01");

    }





}
