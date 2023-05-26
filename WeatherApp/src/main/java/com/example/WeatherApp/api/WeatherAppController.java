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

    @GetMapping
    @RequestMapping("/home")
    public static CurrentWeather getCurrentWeatherData() throws IOException {
        String apiKey = "<REMOVED>";
        String url = "http://api.weatherapi.com/v1/current.json?q=auto:ip";

        HttpHeaders headers = new HttpHeaders();
        headers.add("key", apiKey);
        HttpEntity<Object> header = new HttpEntity<>(headers);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET, header, String.class);

        final ObjectMapper objectMapper = new ObjectMapper();
        final CurrentWeather currentWeather = objectMapper.readValue(response.getBody(), CurrentWeather.class);

        return currentWeather;
    }
}
