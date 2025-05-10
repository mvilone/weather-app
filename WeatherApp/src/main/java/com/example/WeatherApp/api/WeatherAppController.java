package com.example.WeatherApp.api;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import com.example.WeatherApp.model.*;
import com.example.WeatherApp.database.CustomHashMap;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;

@RestController
public class WeatherAppController {
    @Value("${weather.api.key}")
    private String apiKey;
    private static String  APIKEY;
    @PostConstruct
    private void init(){
        APIKEY = apiKey;
    }
    private static final int NUMBER_OF_SEC_HR = 3600;
    private static City cityObject = null;

    public static <T> T withRetries(Callable<T> task, int maxRetries, long delayMillis) throws IOException {
        int attempt = 0;
        while (true) {
            try {
                return task.call();
            } catch (Exception e) {
                attempt++;
                if (attempt > maxRetries) {
                    throw new IOException("Failed after " + maxRetries + " retries", e);
                }
                try {
                    Thread.sleep(delayMillis);
                }catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new IOException("Retry interrupted", ie);
                }
            }
        }
    }


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
        if (containsNonCharacter(cityName)) {
            throw new IOException("Input must be a-z or A-Z");
        }
        
        String url = "http://api.weatherapi.com/v1/current.json?key=" + APIKEY + "&q=" + cityName;
        
        Callable<CurrentWeather> task = () -> {
            RestTemplate rt = new RestTemplate();
            ResponseEntity<String> response = rt.getForEntity(url, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.getBody(), CurrentWeather.class);
        };
        
        return withRetries(task, 3, 1000); // 3 retries, 2s delay between retries
    }


    public static CurrentWeather getCurrentWeatherZipcodeSearch(int zipcode) throws IOException {
        String url = "http://api.weatherapi.com/v1/current.json?key="+APIKEY+"&q="+String.valueOf(zipcode);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(url, String.class);

        final ObjectMapper objectMapper = new ObjectMapper();
        final CurrentWeather currentWeather = objectMapper.readValue(response.getBody(), CurrentWeather.class);

        return currentWeather;
    }

    public static ForecastedWeather getForecastWeatherCitySearch(String cityName, String file, int unixdate) throws IOException {
        if (containsNonCharacter(cityName)) {
            throw new IOException("Input must be a-z or A-Z");
        }
        
        String encodedCity = URLEncoder.encode(cityName, StandardCharsets.UTF_8);
        String url = "http://api.weatherapi.com/v1/" + file + "?key=" + APIKEY + "&q=" + encodedCity + "&unixdt=" + unixdate;
        System.out.println("Web Link: " + url);
        
        return withRetries(() -> {
            RestTemplate rt = new RestTemplate();
            ResponseEntity<String> response = rt.getForEntity(url, String.class);
            
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            return objectMapper.readValue(response.getBody(), ForecastedWeather.class);
        }, 7, 4000); // Retry up to 3 times with 1 second delay
    }


    
    public static City getPreviousDaysForCity(String cityName, int xDay) throws IOException{
        if(containsNonCharacter(cityName)){
            throw new IOException("Input must be a-z or A-Z");
        }
        CurrentWeather current = getCurrentWeatherCitySearch(cityName);
        int unix_date_time = current.getLocation().getLocaltime_epoch();
        int number_of_secondInXDay = (NUMBER_OF_SEC_HR * 24) * xDay;
        unix_date_time -= (number_of_secondInXDay);
        ForecastedWeather instanceForecasted = null;
        for(int x = 0; x < xDay; ++x){
            instanceForecasted = getForecastWeatherCitySearch(cityName, "history.json", unix_date_time);
            Day current_day = instanceForecasted.getForecast().getForecastday().get(0).getDay();
            current_day.setForecast(instanceForecasted.getForecast().getForecastday().get(0));
            current_day.setDay_number(x + 1);
            cityObject.addToPastXDays(current_day);
            unix_date_time += (NUMBER_OF_SEC_HR * 24);
        }
        for(int x = 0; x < xDay; ++x){
            for(int y = 0; y < 24; ++y){
                Hour h = cityObject.getPastDays().obtain_element(x + 1).getForecast().getHour().get(y);
                h.setHour_number(y);
                cityObject.getPastDays().obtain_element(x + 1).addToHours(h);
            }
        }
        return cityObject;
    }

    public static City getNextDaysForCity(String cityName, int xDay) throws IOException{
        if(containsNonCharacter(cityName)){
            throw new IOException("Input must be a-z or A-Z");
        }
        CurrentWeather current = getCurrentWeatherCitySearch(cityName);
        int unix_date_time = current.getLocation().getLocaltime_epoch();
        unix_date_time += NUMBER_OF_SEC_HR * 24;
        ForecastedWeather instanceForecasted = null;
        for(int x = 0; x < xDay; ++x){
            instanceForecasted = getForecastWeatherCitySearch(cityName, "forecast.json", unix_date_time);
            Day current_day = instanceForecasted.getForecast().getForecastday().get(0).getDay();
            current_day.setForecast(instanceForecasted.getForecast().getForecastday().get(0));
            current_day.setDay_number(x + 1);
            cityObject.addToFutureXDays(current_day);
            unix_date_time += (NUMBER_OF_SEC_HR * 24);
        }
        for(int x = 0; x < xDay; ++x){
            for(int y = 0; y < 24; ++y){
                Hour h = cityObject.getFutureDays().obtain_element(x + 1).getForecast().getHour().get(y);
                h.setHour_number(y);
                cityObject.getFutureDays().obtain_element(x + 1).addToHours(h);
            }
        }
        return cityObject;
    } 

    public static CurrentWeather getHourlyForCurrent(CurrentWeather currentweather)throws IOException{
        String cityName = currentweather.getLocation().getName();
        int currentDateInUnix = currentweather.getLocation().getLocaltime_epoch();
        ForecastedWeather forecastedweather = getForecastWeatherCitySearch(cityName, "forecast.json", currentDateInUnix);
        Day currentDay = forecastedweather.getForecast().getForecastday().get(0).getDay();
        currentDay.setForecast(forecastedweather.getForecast().getForecastday().get(0));
        for(int x = 0; x < 24; ++x){
            Hour h = currentDay.getForecast().getHour().get(x);
            h.setHour_number(x);
            currentDay.addToHours(h);
        }
        currentweather.setCurrentDay(currentDay);
        return currentweather;

    }
    public static boolean containsNonCharacter(String input){
        input = input.replaceAll(" ", "");
        for(int x = 0; x < input.length(); ++x){
            char c = input.charAt(x);
            if(!(((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')))){
                return true;
            }
        }
        return false;

    }
    public static void setCityObject(String cityName){
        cityObject = new City(cityName);
    }

    public static CurrentWeather initializeCityObject(char flag, String cityName, int zipcode) throws IOException{
        CurrentWeather currentweather = new CurrentWeather();
        switch(flag) {
            case 'i':
                currentweather = getCurrentWeatherIPGrab();
                break;
            case 'z':
                currentweather = getCurrentWeatherZipcodeSearch(zipcode);
                break;
            case 'c':
                currentweather = getCurrentWeatherCitySearch(cityName);
                break;
            default:
                throw new IOException("flag has to be i, z, c");
        }
        setCityObject(currentweather.getLocation().getName());
        currentweather = getHourlyForCurrent(currentweather);
        return currentweather;

    }
    public static City populateCity(char flag, String cityName, int zipcode) throws IOException{
        cityObject = null;
        String flagString = String.valueOf(flag).toLowerCase();
        flag = flagString.charAt(0);
        CurrentWeather currentweather = initializeCityObject(flag, cityName, zipcode);
        cityObject.setCurrentweather(currentweather);
        getPreviousDaysForCity(currentweather.getLocation().getName(), 5);
        getNextDaysForCity(currentweather.getLocation().getName(), 5);

        return cityObject;

    }
    public static void main(String [] args) throws IOException{
        City test = populateCity('z', null, 77494);
        //System.out.println(test.getCurrentweather().getCurrent().getFeelslike_f());
        //System.out.println(test.getCurrentweather().getCurrentDay());
        //System.out.println(test.getCurrentweather().getCurrentDay().getHoursMap());
        //System.out.println(test.getCity_name());
        //System.out.println(test.getPastDays().obtain_element(1).getForecast().getDay());
        //System.out.println(test.getPastDays().obtain_element(1).getForecast().getDay().getHoursMap().obtain_element(23));
        //System.out.println(test.getPastDays());
        //System.out.println(test.getPastDays().obtain_element(1).getForecast().getDay().getHoursMap());
        //System.out.println(test.getCity_name());
        //System.out.println(test.getFutureDays().obtain_element(1).getForecast().getDay());
        //System.out.println(test.getFutureDays().obtain_element(1).getForecast().getDay().getHoursMap().obtain_element(23));
        //System.out.println(test.getFutureDays());
        //System.out.println(test.getFutureDays().obtain_element(1).getForecast().getDay().getHoursMap());

    }





}
