package com.example.WeatherApp.model;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;

import com.example.WeatherApp.database.CustomHashMap;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;



@Entity
/**
 * This class a single city's data as an object called City.
 * City is a WeatherData that's why it extends it.
 */
public class City extends WeatherData implements CityInterface{
    private int cityid;
    /**
     * This represents the citiy's id for the HashCode in which it uses the cities name.
     */
    private String city_name;
    /*
    /**
     * This represents the city's current weather that day's hourly weather.
     */
    private CurrentWeather currentweather;
    private List<Day> pastFiveDays = new ArrayList<>();
    private List<Day> futureFiveDays= new ArrayList<>();
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCityid() {
        return cityid;
    }
    /**
     * This method gets the city name in string format.
     * @return city_name
     */
    public String getCity_name() {
        return city_name;
    }
    /**
     * This returns the cities current weather with that day's hourly data.
     * @return currentweather, the current weather object containing current weather and that day's hourly data.
     */
    @OneToOne(cascade=CascadeType.ALL, targetEntity = CurrentWeather.class)
    @JoinColumn(name="currentweather")
    public CurrentWeather getCurrentweather() {
        return currentweather;
    }
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "pastFiveDays", referencedColumnName = "cityid")
    public List<Day> getPastFiveDays() {
        return pastFiveDays;
    }
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "futureFiveDays", referencedColumnName = "cityid")
    public List<Day> getFutureFiveDays() {
        return futureFiveDays;
    }
    public void setCityid(int cityid) {
        this.cityid = cityid;
    }
    /**
     * This method sets the class attribute city_name to param city_name.
     * @param city_name input param city name.
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
    /**
     * This method sets the class's currentweather to the parameter currentweather.
     * @param currentweather is the an object that has information about what the current weather is and the current day's hourly weather.
     */
    public void setCurrentweather(CurrentWeather currentweather) {
        this.currentweather = currentweather;
    }
    public void setPast_five_days(CustomHashMap<Day> past_five_days) {
        this.past_five_days = past_five_days;
    }
    public void setFuture_five_days(CustomHashMap<Day> future_five_days) {
        this.future_five_days = future_five_days;
    }
    

     public void setPastFiveDays(List<Day> pastFiveDays) {
        this.pastFiveDays = pastFiveDays;
    }
    public void setFutureFiveDays(List<Day> futureFiveDays) {
        this.futureFiveDays = futureFiveDays;
    }
    /**
     * This adds a day object to past_five_days HashMap.
     * @param day of type Day is what is placed in the past_five_days HashMap.
     */
    @Transient
    public void addToPastXDays(Day day){
        past_five_days.append_element(day);
    }
    /**
     * This adds a day object to future_five_days HashMap.
     * @param day of type Day is what is placed in the future_five_days HashMap.
     */
    @Transient
    public void addToFutureXDays(Day day){
        future_five_days.append_element(day);
    }
    /**
     * This gives the HashMap that store the past days data.
     * @return past_five_days which is a HashMap containing past days.
     */
    @Transient
    public CustomHashMap<Day> getPastDays(){
        return past_five_days;
    }
    /**
     * This gives the HashMap that store the futuredays data.
     * @return future_five_days which is a HashMap containing future days.
     */
    @Transient
    public CustomHashMap<Day> getFutureDays(){
        return future_five_days;
    }
    @Transient
    public String toString(){
        return city_name;
    }
    /**
     * This gets the HashCode of the City's ID for the HashMap to use.
     * @return is hashCode of city_name (all letter put to lower case).
     */
    @Transient
    public int giveHashCode(){
        return getCity_name().toLowerCase().hashCode();
    }
    /**
     * This checks for equality of this and other, whether if the City alone is given
     * for other parameter or an City object is given for the other.
     * @param other is what a this.City object is being compared to.
     * @return is true if the other's id matched this id.
     */
    @Transient
    public boolean equals(Object other){
        boolean equals_result = false;
        if(other instanceof String){
            equals_result = this.getCity_name().toLowerCase().equals(((String)other).toLowerCase());
        }
        else if(other instanceof City){
            equals_result = this.getCity_name().toLowerCase().equals(((City)other).getCity_name().toLowerCase());
        }
        return equals_result;
    }
    public static void main(String[] args){
        City c = new City("chantilly");
        CustomHashMap<City> array = new CustomHashMap<>();
        array.append_element(c);
        array.append_element(new City("Chantilly"));
        //System.out.println(array.obtain_element("chAntillY").get_city_name() + " output");
        //System.out.println(array);
        //c.past_five_days.dispArray();
        //c.future_five_days.dispArray();

    }
    
}
