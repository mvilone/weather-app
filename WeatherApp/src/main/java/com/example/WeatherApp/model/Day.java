package com.example.WeatherApp.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.WeatherApp.database.CustomHashMap;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
/**
 * This class a single Day's data as an object called day.
 * Day is a WeatherData that's why it extends it.
 */
@Entity
public class Day extends WeatherData{
    /**
     * This represents the id of the Day object
     * relative to it's position in the past and future 5 day HashMaps.
     */
    private int dayid;
    private String date;
    private Integer day_number;
    private double maxtemp_c;
    private List<Hour> twenty4Hours = new ArrayList<Hour>();
    /**
     * This is a HashMap that stores the data for twenty 4 hours weather data for the instance of the day.
     */
    private CustomHashMap<Hour> twenty_4_hrs;

    /**
     * This is the constructor for Day, sets day_number to 0, and instantiates the 24hrs HashMap.
     */
    public Day(){
        day_number = 0;
        maxtemp_c = -500;
        twenty_4_hrs = new CustomHashMap<Hour>();
        twenty4Hours = new ArrayList<>();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDayid() {
        return dayid;
    }
    
    public String getDate() {
        return date;
    }
    /**
     * This method gives the day id number with the respect to past and future days hashMaps.
     * @return day_number the id of the instance of the day.
     */
    public Integer getDay_number() {
        return day_number;
    }
    public double getMaxtemp_c() {
        return maxtemp_c;
    }
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "twenty4Hours", referencedColumnName = "dayid")
    public List<Hour> getTwenty4Hours() {
        return twenty4Hours;
    }
    public void setDayid(int dayid) {
        this.dayid = dayid;
    }
    public void setDate(String date){
        this.date = date;
    }
    /**
     * This method sets what day number the current instance of day is which is determined at past and future 5 days hashMaps.
     * @param number is the id that the day will be set to with respect to past days and future days hashmaps.
     */
    public void setDay_number(Integer day_number) {
        this.day_number = day_number;
    }

    public void setMaxtemp_c(double maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }
    public void setTwenty4Hours(List<Hour> twenty4Hours) {
        this.twenty4Hours = twenty4Hours;
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
    @Transient
    public CustomHashMap<Hour> getHoursMap(){
        return twenty_4_hrs;
    }
    public void setHoursMap(CustomHashMap<Hour> twenty_4_hrs){
        this.twenty_4_hrs = twenty_4_hrs;
    }
    /**
     * This gets the HashCode of the Day's ID for the HashMap to use.
     * @return is hashCode of day_number.
     */
    @Transient
    public int giveHashCode(){
        return day_number.hashCode();
    }
    /*public double getMaxtemp_c(){
        return maxtemp_c; 
    }*/
    /**
     * This checks for equality of this and other, whether if the Day id alone is given
     * for other parameter or an Day object is given for the other.
     * @param other is what a this.Day object is being compared to.
     * @return is true if the other's id matched this id.
     */
    @Transient
    public boolean equals(Object other){
        boolean equals_result = false;
        if(other instanceof Integer){
            equals_result = this.getDay_number() == (Integer)other;
        }
        else if (other instanceof Day){
            equals_result = this.getDay_number() == ((Day)other).getDay_number();
        }
        return equals_result;
    }
    @Transient
    public String toString(){
        return getForecast().getDate();
    }
    
    
}
