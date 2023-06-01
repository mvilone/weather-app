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
    public static Day getCityHourlyWeather(String cityName) throws IOException{
        String url1 = "http://api.weatherapi.com/v1/timezone.json?key="+APIKEY+"&q="+cityName;
        RestTemplate rt = new RestTemplate();
        final ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> response = rt.getForEntity(url1, String.class);
        //System.out.println(response);
        final CurrentWeather city = objectMapper.readValue(response.getBody(), CurrentWeather.class);
        //System.out.println(city.getLocation().getLocaltime());
        String url2 = "http://api.weatherapi.com/v1/history.json?key="+APIKEY+"&q="+cityName+"&dt="+city.getLocation().getLocaltime();
        System.out.println(city.getLocation().getLocaltime());
        response = rt.getForEntity(url2, String.class);
        //System.out.println(response);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Day test  = objectMapper.readValue(response.getBody(), Day.class);
        
        ArrayList<Hour> twenty_4_hr = test.getForecast().getForecastday().get(0).getHour();
        for(Hour x: twenty_4_hr){
            test.twenty_4_hrs.append_element(x);
        }
        return test;
        
    }
    public static String removetimefromLocaltime(String localtime){
        return null;
    }
    public static void main(String [] args) throws IOException{
        getCityHourlyWeather("chantilly");

    }





}
