package com.example.WeatherApp.database;

public class Hour {
    private double temperatureC;
    private double temperatureF;
    private String responseApi;
    public Hour(String responseApi){
        this.responseApi = responseApi;
        parse_responseApi();
    }
    public void parse_responseApi(){

    }
    public double getTempC(){
        return temperatureC;
    }
    public double getTempF(){
        return temperatureF;
    }
    public String getResponseApi(){
        return responseApi;
    }
}
