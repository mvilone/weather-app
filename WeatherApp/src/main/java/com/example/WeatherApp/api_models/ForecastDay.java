package com.example.WeatherApp.api_models;

public class ForecastDay {
    private String date;

    private int date_epoch;

    private Day day;

    private Hour hour[];

    public void setDate(String date) {
        this.date = date;
    }

    public void setDate_epoch(int date_epoch) {
        this.date_epoch = date_epoch;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void setHour(Hour hour[]) {
        this.hour = hour;
    }

    public Day getDay() {
        return day;
    }

    public Hour[] getHour() {
        return hour;
    }

    public int getDate_epoch() {
        return date_epoch;
    }

    public String getDate() {
        return date;
    }
}
