package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;
/**
 * This class a single Day's data as an object called day.
 * Day is a WeatherData that's why it extends it.
 */
public class Day extends WeatherData{
    /**
     * This represents the id of the Day object
     * relative to it's position in the past and future 5 day HashMaps.
     */
    private Integer day_number;
    private double maxtemp_c = -500;
    /**
     * This is a HashMap that stores the data for twenty 4 hours weather data for the instance of the day.
     */
    private CustomHashMap<Hour> twenty_4_hrs;
    /**
     * This is the constructor for Day, sets day_number to 0, and instantiates the 24hrs HashMap.
     */
    public Day(){
        day_number = 0;
        twenty_4_hrs = new CustomHashMap<Hour>();
    }
    /**
     * This method sets what day number the current instance of day is which is determined at past and future 5 days hashMaps.
     * @param number is the id that the day will be set to with respect to past days and future days hashmaps.
     */
    public void set_Day_Number(int number){
        this.day_number = number;
    }
    /**
     * This method gives the day id number with the respect to past and future days hashMaps.
     * @return day_number the id of the instance of the day.
     */
    public int get_Day_Number(){
        return day_number;
    }
    /**
     * This adds an Hour object to the twenty_4_hrs HashMap. 
     * @param hour is the current hour data as an object Hour.
     */
    public void addToHours(Hour hour){
        twenty_4_hrs.append_element(hour);
    }
    /**
     * This gives back the HashMap that contains twenty_4_hrs data.
     * @return twenty_4_hrs HashMap.
     */
    public CustomHashMap<Hour> getHoursMap(){
        return twenty_4_hrs;
    }
    /**
     * This gets the HashCode of the Day's ID for the HashMap to use.
     * @return is hashCode of day_number.
     */
    public int getHashCode(){
        return day_number.hashCode();
    }
    public double getMaxtemp_c(){
        return maxtemp_c; 
    }
    /**
     * This checks for equality of this and other, whether if the Day id alone is given
     * for other parameter or an Day object is given for the other.
     * @param other is what a this.Day object is being compared to.
     * @return is true if the other's id matched this id.
     */
    public boolean equals(Object other){
        boolean equals_result = false;
        if(other instanceof Integer){
            equals_result = this.get_Day_Number() == (Integer)other;
        }
        else if (other instanceof Day){
            equals_result = this.get_Day_Number() == ((Day)other).get_Day_Number();
        }
        return equals_result;
    }
    public String toString(){
        return getForecast().getDate();
    }
    
    
}
