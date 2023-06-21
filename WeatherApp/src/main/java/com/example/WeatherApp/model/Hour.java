package com.example.WeatherApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/**
 * This class stores a single hour's data as an object called Hour.
 * Hour is a WeatherData that's why it extends it.
 */
@Entity
public class Hour extends WeatherData{
    private int id;
    /**This represents the id of the Hour object
     * relative to it's position in the twenty 4 hour HashMap.
     */
    private Integer hour_number;
    /**
     * Contains the date and time in string format.
     */
    private String time;
    /**
     * This acts as the constructor for Hour in which hour_number is initialized to 0.
     * time is intialized to null.
     */
    
    public Hour(){
        this.hour_number = 0;
        this.time = null;
    }
    /**
     * This gets the time which gives the date and time of a certain hour object.
     * @return string that contains date and time of an Hour object.
     */

    /**
     * This gets the ID number of the Hour object.
     * @return id of the Hour object.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public Integer getHour_number() {
        return hour_number;
    }

    public String getTime(){
        return time;
    }
    public void setId(int id) {
        this.id = id;
    }
    /**
     * This sets a new ID number to a certain hour, think of it as an index number within a HashMap.
     * @param number is the id number that that hour will be set to.
     */
    public void setHour_number(Integer hour_number) {
        this.hour_number = hour_number;
    }
    public void setTime(String time) {
        this.time = time;
    }
    /**
     * This gets the hashCode of the Hour's ID for the HashMap to use.
     * @return is the hashCode of hour_number.
     */
    @Transient
    public int giveHashCode(){
        return hour_number.hashCode();
    }
    /**
     * This checks for equality of this and other, whether if the Hours id alone is given
     * for other parameter or an Hour object is given for the other.
     * @param other is what a this.Hour object is being compared to.
     * @return is true if the other's id matched this id.
     */
    @Transient
    public boolean equals(Object other){
        boolean equals_result = false;
        if(other instanceof Integer){
            equals_result = this.getHour_number() == (Integer)other;
        }
        else if (other instanceof Hour){
            equals_result = this.getHour_number() == ((Hour)other).getHour_number();
        }
        return equals_result;
    }
    @Transient
    public String toString(){
        return getTime();
    }


    
}
