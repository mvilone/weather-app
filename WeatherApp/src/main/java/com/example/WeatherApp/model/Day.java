package com.example.WeatherApp.model;
import com.example.WeatherApp.database.CustomHashMap;

public class Day extends CommonWeatherData{
    private Integer day_number = 0;
    private City day_city;
    private String date;
    private double uv;
    private CustomHashMap<Hour> twenty_4_hrs = new CustomHashMap<Hour>();
    public Day(){
        
    }
    public void set_days_city(City city){
        this.day_city = city;
    }
    public void set_Day_Number(int number){
        this.day_number = number;
    }
    public int get_Day_Number(){
        return day_number;
    }
    public String getDate(){
        return date;
    }
    public void addToHours(Hour hour){
        twenty_4_hrs.append_element(hour);
    }
    public CustomHashMap<Hour> getHoursMap(){
        return twenty_4_hrs;
    }
    public int getHashCode(){
        return day_number.hashCode();
    }
    public double getUv(){
        return uv;
    }
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
    /*public String toString(){
        return getDate();
    }*/
    
    
}
