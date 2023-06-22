package com.example.WeatherApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.WeatherApp.api.WeatherAppController;
import com.example.WeatherApp.model.*;
import java.io.IOException;
@SpringBootTest
/**
 * This class tests that the api extraction and behavior.
 */
public class UnitTest{
    @Test
    /**
     * This method tests that the attribute Temperature in celcius 
     * was obtained successfully from the api into an object.
     * @throws IOException
     */
    void Test1() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertNotNull(weather.getCurrent().getTemp_c());
        }
    }
    @Test
    /**
     * This method tests that the attribute Temperature in fahrenheit 
     * was obtained successfully from the api into an object.
     * @throws IOException
     */
    void Test2() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertNotNull(weather.getCurrent().getTemp_f());
        }
    }
    @Test
    /**
     * This method tests that the precipitation in inches attribute
     * was successfully obtained from the api into an object.
     * Only does it for cities that use inches.
     * @throws IOException
     */
    void Test3() throws IOException{
        String input[] = {"Fairfax", "New York"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertTrue(weather.getCurrent().getPrecip_in() >= 0);
        }
    }
    @Test
    /**
     * This method tests that the precipitation in mm attribute
     * was successfully obtained from the api into an object.
     * Only does it for cities that use mm.
     * @throws IOException
     */
    void Test4() throws IOException{
        String input[] = {"Paris", "Beijing", "Sydney"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertTrue(weather.getCurrent().getPrecip_mm() >= 0);
        }
    }
    @Test
    /**
     * This method tests that the attribute local current time 
     * was obtained successfully from the api into an object.
     * @throws IOException
     */
    void Test5() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertNotNull(weather.getLocation().getLocaltime());
        }
    }
    @Test
    /**
     * This method tests city name for CurrentWeather was succesfully obtained from
     * the api and maps it into an object.
     * Also makes sure its in the api's format, "Fairfax" "New York".
     * @throws IOException
     */
    void Test6() throws IOException{
        String input[] = {"faIrfax", "New York", "Paris", "Beijing", "Sydney"};
        String expectation[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        int i = 0;
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertEquals(expectation[i], weather.getLocation().getName());
            i++;
        }
    }
    
    @Test
    /**
     * This method tests city name for City was succesfully obtained from
     * the api and maps it into an object.
     * Also makes sure its in the api's format, "Fairfax" "New York".
     * @throws IOException
     */
    void Test7() throws IOException{
        String input[] = {"FaIrfax", "New York", "Paris", "Beijing", "Sydney"};
        String expectation[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        int i = 0;
        for(String c: input){
            WeatherAppController.initializeCityObject('c', c, -1);
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertEquals(expectation[i], city.getCity_name());
            i++;
        }
    }
    @Test
    /**
     * This method tests that the previous five day's weather data were successfully
     * obtained from the api successfully by seeing that one day exists in the object City.
     * @throws IOException
     */
    void Test8() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String c: input){
            WeatherAppController.initializeCityObject('c', c, -1);
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertNotNull(city.getPastDays().obtain_element(1));
        }
    }
    @Test
    /** 
     * This method tests that from the previous five days
     * a certain day's 24 hrs weather data was obtained from the api
     * successfully.
     */
    void Test9() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String c: input){
            WeatherAppController.initializeCityObject('c', c, -1);
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertNotNull(city.getPastDays().obtain_element(1).getHoursMap());
        }
    }
    @Test
    /**
     * This method tests with one of days extracted in the City object
     * that the attribute max temperature in celcius was successfully obtained from the api.
     * @throws IOException
     */
    void Test10() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String c: input){
            WeatherAppController.initializeCityObject('c', c, -1);
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertTrue(city.getPastDays().obtain_element(1).getMaxtemp_c() >= -273);
        }
    }
    @Test
    /**
     * This method tests with one of days extracted and a certain
     * hour extracted from it in the City object
     * that the attribute local time was successfully obtained from the api.
     * @throws IOException
     */
    void Test11() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String c: input){
            WeatherAppController.initializeCityObject('c', c, -1);
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertNotNull(city.getPastDays().obtain_element(1).getHoursMap().obtain_element(15).getTime());
        }
    }
    //edge cases for the api testing
    @Test
    /**
     * This tests that what gets placed in the api for city_name
     * contains character a-z or A-Z and space character.
     * Basically doesn't allow any other character.
     * @throws IOException
     */
    void Test12() throws IOException{
        String city_name = "#";
        boolean exceptionThrown = false;
        try{
            WeatherAppController.getCurrentWeatherCitySearch(city_name);
        }
        catch(IOException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
    @Test
    /**
     * This method checks that the input for city is an actual 
     * city and that it actually exisits in the world or api.
     * @throws IOException
     */
    void Test13() throws IOException{
        String city_name = "jsiddusidjsn";
        boolean exceptionThrown = false;
        try{
            WeatherAppController.getCurrentWeatherCitySearch(city_name);
        }
        catch(Exception e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

    }

    

    
    
    


    
}
