package com.example.WeatherApp.model;
public class Hour extends CommonWeatherData{
    private Integer hour_number;
    private String time;
    public Hour(){
        
        
    }
    public void set_Hour_Number(int number){
        this.hour_number = number;
    }
    public int get_Hour_Number(){
        return hour_number;
    }
    public String getTime(){
        return time;
    }
    public int getHashCode(){
        return hour_number.hashCode();
    }
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
