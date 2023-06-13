package com.example.WeatherApp.api_models;

public class Location {
    private String name;
    private String region;
    private String country;
    private String tz_id;
    private String localtime;

    private double lat;
    private double lon;

    private int localtime_epoch;

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

    public String getLocaltime() {
        return localtime;
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

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public void setLocaltome_epoch(int localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }
}
