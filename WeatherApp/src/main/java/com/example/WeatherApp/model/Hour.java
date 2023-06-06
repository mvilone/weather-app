package com.example.WeatherApp.model;
/**
 * This class stores a single hour's data as an object called Hour.
 * Hour is a WeatherData that's why it extends it.
 */
public class Hour extends WeatherData{
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
     * This sets a new ID number to a certain hour, think of it as an index number within a HashMap.
     * @param number is the id number that that hour will be set to.
     */
    public void set_Hour_Number(int number){
        this.hour_number = number;
    }
    /**
     * This gets the ID number of the Hour object.
     * @return id of the Hour object.
     */
    public int get_Hour_Number(){
        return hour_number;
    }
    /**
     * This gets the time which gives the date and time of a certain hour object.
     * @return string that contains date and time of an Hour object.
     */
    public String getTime(){
        return time;
    }
    /**
     * This gets the hashCode of the Hour's ID for the HashMap to use.
     * @return is the hashCode of hour_number.
     */
    public int getHashCode(){
        return hour_number.hashCode();
    }
    /**
     * This checks for equality of this and other, whether if the Hours id alone is given
     * for other parameter or an Hour object is given for the other.
     * @param other is what a this.Hour object is being compared to.
     * @return is true if the other's id matched this id.
     */
    public boolean equals(Object other){
        boolean equals_result = false;
        if(other instanceof Integer){
            equals_result = this.get_Hour_Number() == (Integer)other;
        }
        else if (other instanceof Hour){
            equals_result = this.get_Hour_Number() == ((Hour)other).get_Hour_Number();
        }
        return equals_result;
    }
    public String toString(){
        return getTime();
    }

    
}
