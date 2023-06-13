package com.example.WeatherApp.api;

import com.example.WeatherApp.api_models.CurrentWeather;
import com.example.WeatherApp.api_models.ForecastedWeather;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class WeatherAppController {

    private static final String  APIKEY = "<REMOVED>";

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

    public static ForecastedWeather getForecastWeatherIPGrab() throws IOException {
        String url = "http://api.weatherapi.com/v1/forecast.json?key="+APIKEY+"&days=5&q=auto:ip";

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(url, String.class);
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        final ForecastedWeather forecast = objectMapper.readValue(response.getBody(), ForecastedWeather.class);

        return forecast;
    }

    public static ForecastedWeather getForecastWeatherCitySearch(String cityName) throws IOException {
        String url = "http://api.weatherapi.com/v1/forecast.json?key="+APIKEY+"&days=5&q="+cityName;

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(url, String.class);
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        final ForecastedWeather forecast = objectMapper.readValue(response.getBody(), ForecastedWeather.class);

        return forecast;
    }

    public static ForecastedWeather getForecastWeatherZipcodeSearch(int zipcode) throws IOException {
        String url = "http://api.weatherapi.com/v1/forecast.json?key="+APIKEY+"&days=5&q="+String.valueOf(zipcode);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(url, String.class);
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        final ForecastedWeather forecast = objectMapper.readValue(response.getBody(), ForecastedWeather.class);

        return forecast;
    }







}
