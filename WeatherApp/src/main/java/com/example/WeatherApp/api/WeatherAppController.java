package com.example.WeatherApp.api;

import com.example.WeatherApp.model.CurrentWeather;
import com.fasterxml.jackson.databind.ObjectMapper;
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





}
