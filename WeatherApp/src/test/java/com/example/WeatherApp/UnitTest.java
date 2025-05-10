package com.example.WeatherApp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpServerErrorException;

import com.example.WeatherApp.api.WeatherAppController;
import com.example.WeatherApp.model.*;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
@SpringBootTest
/**
 * This class tests that the api extraction and behavior.
 */
public class UnitTest{
    static Dotenv dotenv;

    @BeforeAll
    public static void setup() {
    // Step up one directory to get to the .env file
    String envPath = Paths.get(System.getProperty("user.dir"))
                          .getParent() // Go from /WeatherApp to /CS321-Group-5
                          .toString();

    dotenv = Dotenv.configure()
                   .filename(".env")
                   .directory(envPath)
                   .load();

    // Set the properties Spring Boot expects for MySQL
    System.setProperty("spring.datasource.username", "root");  // or get from dotenv if not hardcoded
    System.setProperty("spring.datasource.password", dotenv.get("MYSQL_PASSWORD"));

    // Optional custom properties
    System.setProperty("weather.api.key", dotenv.get("WEATHER_API_KEY"));
    }
     
    @Test
    void testSingleForecastCall() {
        System.err.println(">>>> THIS SHOULD PRINT <<<<");
        try {
            WeatherAppController.initializeCityObject('c', "Paris", -1);
            City city = WeatherAppController.getPreviousDaysForCity("Paris", 1);
            assertEquals("Paris", city.getCity_name());
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("Single API call failed: " + e.getMessage());
        }
    }


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
    /**
     * Testing populate city when inputting city string, and testing that city 
     * object has one of the weather data correctly inputted.
     * @throws IOException
     */
    @Test
    void Test14() throws IOException{
        String input[] = {"Fairfax", "New YOrk", " Paris", "Beijing", " Sydney"};
        String expected[] = {"Fairfax", "New York", "Paris", "Beijing", "Sydney"};
        int i = 0;
        for(String cityName: input){
            City city = WeatherAppController.populateCity('c', cityName, -1);
            assertEquals(expected[i], city.getCity_name());
            i += 1;
        }
        


    }
    /**
     * Testing populate city when inputting integer zipcode, and testing that city 
     * object has one of the weather data correctly inputted.
     * @throws IOException
     */
    @Test 
    void Test15() throws IOException{
        int input[] = {22033, 10004, 43085, 98108, 48215};
        String expected[] = {"Fairfax", "New York", "Columbus", "Seattle", "Detroit"};
        int i = 0;
        for(int zipcode: input){
            City city = WeatherAppController.populateCity('z', null, zipcode);
            assertEquals(expected[i], city.getCity_name());
            i += 1;
        }   

    }
    /**
     * Testing populate city when using ip address, and testing that city 
     * object has one of the weather data correctly inputted.
     * @throws IOException
     */
    @Test
    void Test16() throws IOException{
        City city1 = new City();
        City city2 = WeatherAppController.populateCity('i', null, -1);
        assertNull(city1.getCity_name());
        assertNotNull(city2.getCity_name());


    }

    //End point integration Test
    @Test
    void Test17(){
        when()
        .get("http://localhost:8080/city/getCity")
        .then()
        .statusCode(200)
        .body("city_name", equalTo("Alexandria"));
    }
    @Test
    void Test18(){
        when()
        .get("http://localhost:8080/city/getCity")
        .then()
        .statusCode(200)
        .body("city_name", equalTo("Washington"));
    }
    @Test
    void Test19(){
        when()
        .get("http://localhost:8080/city/getCity")
        .then()
        .statusCode(200)
        .body("city_name", equalTo("Austin"));
    }

    public static void main(String [] args){
        UnitTest u = new UnitTest();
        try{
            u.Test1();
        }
        catch(Exception e){

        }
    }



    

    
    
    


    
}
