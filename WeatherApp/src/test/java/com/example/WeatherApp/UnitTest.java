package com.example.WeatherApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.WeatherApp.api.WeatherAppController;
import com.example.WeatherApp.model.*;
import java.io.IOException;
@SpringBootTest
public class UnitTest{
    @Test
    void Test1() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertNotNull(weather.getCurrent().getTemp_c());
        }
    }
    @Test
    void Test2() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertNotNull(weather.getCurrent().getTemp_f());
        }
    }
    @Test
    void Test3() throws IOException{
        String input[] = {"Fairfax", "New York"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertTrue(weather.getCurrent().getPrecip_in() >= 0);
        }
    }
    @Test
    void Test4() throws IOException{
        String input[] = {"Paris", "Beijing", "Sydney"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertTrue(weather.getCurrent().getPrecip_mm() >= 0);
        }
    }
    @Test
    void Test5() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String city: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherCitySearch(city);
            assertNotNull(weather.getLocation().getLocaltime());
        }
    }
    @Test
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
    void Test7() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String c: input){
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertEquals(c, city.get_city_name());
        }
    }
    @Test
    void Test8() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String c: input){
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertNotNull(city.getPastDays().obtain_element(1));
        }
    }
    @Test
    void Test9() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String c: input){
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertNotNull(city.getPastDays().obtain_element(1).getHoursMap());
        }
    }
    @Test
    void Test10() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String c: input){
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertTrue(city.getPastDays().obtain_element(1).getMaxtemp_c() >= -273);
        }
    }
    void Test17() throws IOException{
        String input[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        for(String c: input){
            City city = WeatherAppController.getPreviousDaysForCity(c, 5);
            assertNotNull(city.getPastDays().obtain_element(1).getHoursMap().obtain_element(15).getTime());
        }
    }
    
    /*@Test
    void Test7() throws IOException{
        int input[] = {22033, 10008, 70123, 065001, 2000};
        for(int zipcode: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherZipcodeSearch(zipcode);
            assertNotNull(weather.getCurrent().getTemp_c());
        }
    }
    @Test
    void Test8() throws IOException{
        int input[] = {22033, 10008, 70123, 065001, 2000};
        for(int zipcode: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherZipcodeSearch(zipcode);
            assertNotNull(weather.getCurrent().getTemp_f());
        }
    }
    @Test
    void Test9() throws IOException{
        int input[] = {22033, 10008, 70123, 065001, 2000};
        for(int zipcode: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherZipcodeSearch(zipcode);
            assertNotNull(weather.getCurrent().getPrecip_in());
        }
    }
    @Test
    void Test10() throws IOException{
        int input[] = {22033, 10008, 70123, 065001, 2000};
        for(int zipcode: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherZipcodeSearch(zipcode);
            assertNotNull(weather.getCurrent().getPrecip_mm());
        }
    }
    @Test
    void Test11() throws IOException{
        int input[] = {22033, 10008, 70123, 065001, 2000};
        for(int zipcode: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherZipcodeSearch(zipcode);
            assertNotNull(weather.getLocation().getLocaltime());
        }
    }
    @Test
    void Test12() throws IOException{
       int input[] = {22033, 10008, 70123, 065001, 2000};
        for(int zipcode: input){
            CurrentWeather weather = WeatherAppController.getCurrentWeatherZipcodeSearch(zipcode);
            assertEquals(zipcode, weather.getLocation().getName());
        }
    }*/



    
}
