package com.example.WeatherApp.model;


import java.util.List;
import java.util.ArrayList;

import com.example.WeatherApp.model.CurrentWeatherInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name = "currentweather")
public class CurrentWeather {
    private int currentweatherid;
    private Location location;
    private CurrentWeatherInfo current;
    private Day currentDay = null;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCurrentweatherid() {
        return currentweatherid;
    }

    public void setCurrentweatherid(int currentweatherid) {
        this.currentweatherid = currentweatherid;
    }
    @OneToOne(cascade=CascadeType.ALL, targetEntity = Location.class)
    @JoinColumn(name = "location")
    public Location getLocation() {
        return location;
    }
    @OneToOne(cascade=CascadeType.ALL, targetEntity = CurrentWeatherInfo.class)
    @JoinColumn(name = "current")
    public CurrentWeatherInfo getCurrent() {
        return current;
    }
    @Transient
    public Day getCurrentDay() {
        return currentDay;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setCurrent(CurrentWeatherInfo current) {
        this.current = current;
    }
    public void setCurrentDay(Day currentDay) {
        this.currentDay = currentDay;
    }
    


    
    
}
