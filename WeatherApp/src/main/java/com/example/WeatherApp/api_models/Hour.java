package com.example.WeatherApp.api_models;

public class Hour {
    private Condition condition;

    private int last_updated_epoch;
    private int is_day;
    private int wind_degree;
    private int humidity;
    private int cloud;
    private int time_epoch;
    private int will_it_rain;
    private int chance_of_rain;
    private int will_it_snow;
    private int chance_of_snow;

    private double temp_c;
    private double temp_f;
    private double feelslike_c;
    private double feelslike_f;
    private double wind_mph;
    private double wind_kph;
    private double pressure_mb;
    private double pressure_in;
    private double precip_mm;
    private double precip_in;
    private double vis_km;
    private double vis_miles;
    private double uv;
    private double gust_mph;
    private double gust_kph;
    private double windchill_c;
    private double windchill_f;
    private double heatindex_c;
    private double heatindex_f;
    private double dewpoint_c;
    private double dewpoint_f;


    private String last_updated;
    private String wind_dir;
    private String time;

    public void setUv(double uv) {
        this.uv = uv;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setTemp_f(double temp_f) {
        this.temp_f = temp_f;
    }

    public void setChance_of_rain(int chance_of_rain) {
        this.chance_of_rain = chance_of_rain;
    }

    public void setChance_of_snow(int chance_of_snow) {
        this.chance_of_snow = chance_of_snow;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
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

    public void setTime_epoch(int time_epoch) {
        this.time_epoch = time_epoch;
    }

    public void setVis_km(double vis_km) {
        this.vis_km = vis_km;
    }

    public void setVis_miles(double vis_miles) {
        this.vis_miles = vis_miles;
    }

    public void setWill_it_rain(int will_it_rain) {
        this.will_it_rain = will_it_rain;
    }

    public void setWill_it_snow(int will_it_snow) {
        this.will_it_snow = will_it_snow;
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

    public void setDewpoint_c(double dewpoint_c) {
        this.dewpoint_c = dewpoint_c;
    }

    public void setDewpoint_f(double dewpoint_f) {
        this.dewpoint_f = dewpoint_f;
    }

    public void setHeatindex_c(double heatindex_c) {
        this.heatindex_c = heatindex_c;
    }

    public void setWindchill_c(double windchill_c) {
        this.windchill_c = windchill_c;
    }

    public void setWindchill_f(double windchill_f) {
        this.windchill_f = windchill_f;
    }

    public void setHeatindex_f(double heatindex_f) {
        this.heatindex_f = heatindex_f;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public Condition getCondition() {
        return condition;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public double getFeelslike_f() {
        return feelslike_f;
    }

    public double getPrecip_in() {
        return precip_in;
    }

    public double getPrecip_mm() {
        return precip_mm;
    }

    public double getDewpoint_c() {
        return dewpoint_c;
    }

    public double getPressure_in() {
        return pressure_in;
    }

    public double getGust_kph() {
        return gust_kph;
    }

    public double getGust_mph() {
        return gust_mph;
    }

    public double getPressure_mb() {
        return pressure_mb;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public double getHeatindex_c() {
        return heatindex_c;
    }

    public double getTemp_f() {
        return temp_f;
    }

    public double getUv() {
        return uv;
    }

    public double getVis_km() {
        return vis_km;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public double getVis_miles() {
        return vis_miles;
    }

    public double getHeatindex_f() {
        return heatindex_f;
    }

    public double getWind_mph() {
        return wind_mph;
    }

    public int getChance_of_rain() {
        return chance_of_rain;
    }

    public int getChance_of_snow() {
        return chance_of_snow;
    }

    public double getWindchill_c() {
        return windchill_c;
    }

    public double getWindchill_f() {
        return windchill_f;
    }

    public int getCloud() {
        return cloud;
    }

    public double getDewpoint_f() {
        return dewpoint_f;
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

    public int getTime_epoch() {
        return time_epoch;
    }

    public int getWill_it_rain() {
        return will_it_rain;
    }

    public int getWill_it_snow() {
        return will_it_snow;
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public String getTime() {
        return time;
    }

    public String getWind_dir() {
        return wind_dir;
    }
}
