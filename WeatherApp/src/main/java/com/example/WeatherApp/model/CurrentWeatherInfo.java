package com.example.WeatherApp.model;

public class CurrentWeatherInfo {
    private Condition condition;

    private int last_updated_epoch;
    private int is_day;
    private int wind_degree;
    private int humidity;
    private int cloud;

    private double temp_c = -500;
    private double temp_f = -500;
    private double feelslike_c = -500;
    private double feelslike_f = -500;
    private double wind_mph = -1;
    private double wind_kph = -1;
    private double pressure_mb = -1;
    private double pressure_in = -1;
    private double precip_mm = -1;
    private double precip_in = -1;
    private double vis_km;
    private double vis_miles;
    private double uv;
    private double gust_mph;
    private double gust_kph;

    private String last_updated;
    private String wind_dir;

    public Condition getCondition() {
        return condition;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public double getFeelslike_f() {
        return feelslike_f;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public double getTemp_f() {
        return temp_f;
    }
    public double getGust_kph() {
        return gust_kph;
    }

    public double getGust_mph() {
        return gust_mph;
    }

    public int getCloud() {
        return cloud;
    }

    public double getPrecip_in() {
        return precip_in;
    }

    public double getPrecip_mm() {
        return precip_mm;
    }

    public double getPressure_in() {
        return pressure_in;
    }

    public double getPressure_mb() {
        return pressure_mb;
    }

    public double getUv() {
        return uv;
    }

    public double getVis_km() {
        return vis_km;
    }

    public double getVis_miles() {
        return vis_miles;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public double getWind_mph() {
        return wind_mph;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getIs_day() {
        return is_day;
    }

    public int getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public void setFeelslike_f(double feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public void setGust_kph(double gust_kph) {
        this.gust_kph = gust_kph;
    }

    public void setGust_mph(double gust_mph) {
        this.gust_mph = gust_mph;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setIs_day(int is_day) {
        this.is_day = is_day;
    }

    public void setLast_updated_epoch(int last_updated_epoch) {
        this.last_updated_epoch = last_updated_epoch;
    }

    public void setPrecip_in(double precip_in) {
        this.precip_in = precip_in;
    }

    public void setPrecip_mm(double precip_mm) {
        this.precip_mm = precip_mm;
    }

    public void setPressure_in(double pressure_in) {
        this.pressure_in = pressure_in;
    }

    public void setPressure_mb(double pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public void setTemp_f(double temp_f) {
        this.temp_f = temp_f;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public void setVis_km(double vis_km) {
        this.vis_km = vis_km;
    }

    public void setVis_miles(double vis_miles) {
        this.vis_miles = vis_miles;
    }

    public void setWind_degree(int wind_degree) {
        this.wind_degree = wind_degree;
    }

    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public void setWind_mph(double wind_mph) {
        this.wind_mph = wind_mph;
    }
    
}
