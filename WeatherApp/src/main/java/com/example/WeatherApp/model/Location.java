package com.example.WeatherApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "location")
public class Location{
    private int locationid;
    private String name;
    private String region;
    private String country;
    private String tz_id;
    private String replacelt;
    private String localtime;


    private double lat;
    private double lon;

    private int localtime_epoch;
    
    private CurrentWeather currentweather;
    public Location(){
        //name = "maher";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public int getLocaltime_epoch() {
        return localtime_epoch;
    }

    public String getCountry() {
        return country;
    }
    @Transient
    public String getLocaltime() {
        return localtime;
    }
    public String getReplacelt(){
        return replacelt;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getTz_id() {
        return tz_id;
    }
    @Transient
    public CurrentWeather getCurrentweather() {
        return currentweather;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setReplacelt(String replacelt) {
        this.replacelt = replacelt;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public void setLocaltime_epoch(int localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }
    


    public void setCurrentweather(CurrentWeather currentweather) {
        this.currentweather = currentweather;
    }
    
}
