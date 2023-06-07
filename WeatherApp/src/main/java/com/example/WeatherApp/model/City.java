package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;
/**
 * This class a single city's data as an object called City.
 * City is a WeatherData that's why it extends it.
 */
public class City extends WeatherData implements CityInterface{
    /**
     * This represents the citiy's id for the HashCode in which it uses the cities name.
     */
    private String city_name;
    /**
     * This represents the city's current weather that day's hourly weather.
     */
    private CurrentWeather currentweather;
    /**
     * This represents the past five days weather data in a HashMap.
     */
    private CustomHashMap<Day> past_five_days;
    /**
     * This represent the future five days weather data in a HashMap.
     */
    private CustomHashMap<Day> future_five_days;
    /**
     * This is the default constructor, it sets city_name to null.
     * It set currentweather to null, instantiates past_five_days and future_five_days.
     */
    public City(){
        this(null);
    }
    /**
     * This constructor does the same, except sets this.city_name to city_name.
     * @param city_name is the id of the city, for instance an example would be New York.
     */
    public City(String city_name){
        currentweather = null;
        past_five_days = new CustomHashMap<>();
        future_five_days = new CustomHashMap<>();
        this.city_name = city_name;
    }
    /**
     * This method sets the class's currentweather to the parameter currentweather.
     * @param currentweather is the an object that has information about what the current weather is and the current day's hourly weather.
     */
    public void setCurrentWeather(CurrentWeather currentweather){
        this.currentweather = currentweather;

    }
    /**
     * This gives the City objects name which is the id of an instance of a city.
     * @return city_name, the name of the city.
     */
    public String get_city_name(){
        return city_name;
    }
    /**
     * This adds a day object to past_five_days HashMap.
     * @param day of type Day is what is placed in the past_five_days HashMap.
     */
    public void addToPastXDays(Day day){
        past_five_days.append_element(day);
    }
    /**
     * This adds a day object to future_five_days HashMap.
     * @param day of type Day is what is placed in the future_five_days HashMap.
     */
    public void addToFutureXDays(Day day){
        future_five_days.append_element(day);
    }
    /**
     * This gives the HashMap that store the past days data.
     * @return past_five_days which is a HashMap containing past days.
     */
    public CustomHashMap<Day> getPastDays(){
        return past_five_days;
    }
    /**
     * This gives the HashMap that store the futuredays data.
     * @return future_five_days which is a HashMap containing future days.
     */
    public CustomHashMap<Day> getFutureDays(){
        return future_five_days;
    }
    /**
     * This returns the cities current weather with that day's hourly data.
     * @return currentweather, the current weather object containing current weather and that day's hourly data.
     */
    public CurrentWeather getCurrentWeather(){
        return currentweather;
    }
    public String toString(){
        return city_name;
    }
    /**
     * This gets the HashCode of the City's ID for the HashMap to use.
     * @return is hashCode of city_name (all letter put to lower case).
     */
    public int getHashCode(){
        return get_city_name().toLowerCase().hashCode();
    }
    /**
     * This checks for equality of this and other, whether if the City alone is given
     * for other parameter or an City object is given for the other.
     * @param other is what a this.City object is being compared to.
     * @return is true if the other's id matched this id.
     */
    public boolean equals(Object other){
        boolean equals_result = false;
        if(other instanceof String){
            equals_result = this.get_city_name().toLowerCase().equals(((String)other).toLowerCase());
        }
        else if(other instanceof City){
            equals_result = this.get_city_name().toLowerCase().equals(((City)other).get_city_name().toLowerCase());
        }
        return equals_result;
    }
    public static void main(String[] args){
        City c = new City("chantilly");
        CustomHashMap<City> array = new CustomHashMap<>();
        array.append_element(c);
        array.append_element(new City("Chantilly"));
        System.out.println(array.obtain_element("chAntillY").get_city_name() + " output");
        System.out.println(array);
        //c.past_five_days.dispArray();
        //c.future_five_days.dispArray();

    }
    
}
