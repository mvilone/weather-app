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
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

    public static ForecastedWeather getForecastWeatherCitySearch(String cityName, String file, long unixdate) throws IOException {
        if (containsNonCharacter(cityName)) {
            throw new IOException("Input must be a-z or A-Z");
        }
        
        String encodedCity = URLEncoder.encode(cityName, StandardCharsets.UTF_8);
        String url = "http://api.weatherapi.com/v1/" + file + "?key=" + APIKEY + "&q=" + encodedCity + "&unixdt=" + unixdate;
        
        return withRetries(() -> {
            RestTemplate rt = new RestTemplate();
            ResponseEntity<String> response = rt.getForEntity(url, String.class);
            
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            return objectMapper.readValue(response.getBody(), ForecastedWeather.class);
        }, 7, 4000); // Retry up to 3 times with 1 second delay
    }


    
    public static City getPreviousDaysForCity(String cityName, int xDay) throws IOException {
        if (containsNonCharacter(cityName)) {
            throw new IOException("Input must be a-z or A-Z");
        }
        
        CurrentWeather current = getCurrentWeatherCitySearch(cityName);
        
        // Extract time zone and local time
        String timeZone = current.getLocation().getTz_id();
        long localEpoch = current.getLocation().getLocaltime_epoch();
        
        // Convert to ZonedDateTime in city's local time
        ZonedDateTime currentCityTime = Instant.ofEpochSecond(localEpoch).atZone(ZoneId.of(timeZone));
        
        // Normalize to today's midnight in the city's time zone
        ZonedDateTime todayMidnight = currentCityTime.toLocalDate().atStartOfDay(currentCityTime.getZone());
        
        // Go back x days to get the correct starting point
        ZonedDateTime startMidnight = todayMidnight.minusDays(xDay);
        long unix_date_time = startMidnight.toEpochSecond();
        
        // Debug prints
        System.out.println("City time zone: " + timeZone);
        System.out.println("Current city time: " + currentCityTime);
        System.out.println("Start midnight: " + startMidnight);
        System.out.println("Start unix timestamp: " + unix_date_time);
        
        ForecastedWeather instanceForecasted = null;
        for (int x = 0; x < xDay; ++x) {
            ZonedDateTime forecastDate = ZonedDateTime.ofInstant(Instant.ofEpochSecond(unix_date_time), ZoneId.of(timeZone));
            
            // Shift timestamp forward 12 hours to stay within correct day
            long adjustedUnix = forecastDate.plusHours(12).toEpochSecond();

            System.out.println("Fetching history for timestamp: " + adjustedUnix + " (" +
            Instant.ofEpochSecond(adjustedUnix).atZone(ZoneId.of(timeZone)) + ")");
            instanceForecasted = getForecastWeatherCitySearch(cityName, "history.json", adjustedUnix);
            Day current_day = instanceForecasted.getForecast().getForecastday().get(0).getDay();
            current_day.setForecast(instanceForecasted.getForecast().getForecastday().get(0));
            current_day.setDay_number(x + 1);
            current_day.setDate(forecastDate.toLocalDate().toString());

            cityObject.addToPastXDays(current_day);

            unix_date_time += (NUMBER_OF_SEC_HR * 24);
        }
        
        for (int x = 0; x < xDay; ++x) {
            for (int y = 0; y < 24; ++y) {
                Hour h = cityObject.getPastDays().obtain_element(x + 1).getForecast().getHour().get(y);
                h.setHour_number(y);
                cityObject.getPastDays().obtain_element(x + 1).addToHours(h);
            }
        }
        return cityObject;
    }



    public static City getNextDaysForCity(String cityName, int xDay) throws IOException {
        if (containsNonCharacter(cityName)) {
            throw new IOException("Input must be a-z or A-Z");
        }
        
        CurrentWeather current = getCurrentWeatherCitySearch(cityName);
        // PRINT 1: Raw data from API
        System.out.println("Raw localtime string: " + current.getLocation().getLocaltime());
        System.out.println("Raw localtime_epoch: " + current.getLocation().getLocaltime_epoch());
        System.out.println("Time zone ID: " + current.getLocation().getTz_id());
        
        String timeZone = current.getLocation().getTz_id();
        long localEpoch = current.getLocation().getLocaltime_epoch();
        
        // Convert epoch to ZonedDateTime
        ZonedDateTime currentCityTime = Instant.ofEpochSecond(localEpoch).atZone(ZoneId.of(timeZone));
        
        // PRINT 2: Conversion results
        System.out.println("Converted Instant: " + Instant.ofEpochSecond(localEpoch));
        System.out.println("Converted ZonedDateTime: " + currentCityTime);
        
        // Start from tomorrow's midnight
        ZonedDateTime tomorrowMidnight = currentCityTime.toLocalDate().atStartOfDay(currentCityTime.getZone()).plusDays(1);
        long unix_date_time = tomorrowMidnight.toEpochSecond();
        // PRINT 3: Midnight references
        System.out.println("Tomorrow midnight (ZDT): " + tomorrowMidnight);
        System.out.println("Tomorrow midnight (Unix timestamp): " + unix_date_time);
        
        ForecastedWeather instanceForecasted = null;
        
        for (int x = 0; x < xDay; ++x) {
            ZonedDateTime forecastDate = ZonedDateTime.ofInstant(Instant.ofEpochSecond(unix_date_time), ZoneId.of(timeZone));
            long adjustedUnix = forecastDate.plusHours(12).toEpochSecond(); // Adjustment to avoid UTC misalignment

            System.out.println("Line 3 - before API call: " + adjustedUnix + " (" +
            Instant.ofEpochSecond(adjustedUnix).atZone(ZoneId.of(timeZone)) + ")");

            instanceForecasted = getForecastWeatherCitySearch(cityName, "forecast.json", adjustedUnix);
            Day current_day = instanceForecasted.getForecast().getForecastday().get(0).getDay();
            current_day.setForecast(instanceForecasted.getForecast().getForecastday().get(0));
            current_day.setDay_number(x + 1);
            current_day.setDate(forecastDate.toLocalDate().toString());
            
            cityObject.addToFutureXDays(current_day);
            unix_date_time += (NUMBER_OF_SEC_HR * 24);
        }
        
        for (int x = 0; x < xDay; ++x) {
            for (int y = 0; y < 24; ++y) {
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
        currentDay.setAstro(forecastedweather.getForecast().getForecastday().get(0).getAstro());
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
        cityObject.setCountry(currentweather.getLocation().getCountry());
        cityObject.setLocaltime(currentweather.getLocation().getLocaltime());
        cityObject.setTz_id(currentweather.getLocation().getTz_id()); 
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