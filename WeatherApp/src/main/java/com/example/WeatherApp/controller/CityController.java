package com.example.WeatherApp.controller;

import java.io.IOException;
import java.sql.Date;

import org.hibernate.query.sqm.mutation.internal.temptable.LocalTemporaryTableInsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WeatherApp.api.WeatherAppController;
import com.example.WeatherApp.model.*;
import com.example.WeatherApp.database.*;
import com.example.WeatherApp.services.CityService;
import com.example.WeatherApp.services.LocationService;
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private LocationService locationService;
    @PostMapping("/add")
    public String add(@RequestBody City city){
        cityService.saveCity(city);
        return "City added to databse";

    }
    @GetMapping("/getCity")
    public City get(){
        City city = null;
        try{
            city = WeatherAppController.populateCity('c', "chantilly", -1);
        }
        catch(IOException e){

        }
        Day currentDay = city.getCurrentweather().getCurrentDay();
        city.getCurrentweather().setLocation(null);
        currentDay.setTwenty4Hours(currentDay.getHoursMap().toArrayList());
        currentDay.setHoursMap(null);
        currentDay.setDate(currentDay.getForecast().getDate());
        currentDay.setForecast(null);
        currentDay.setLocation(null);
        city.setPastFiveDays(city.getPastDays().toArrayList());
        city.setFutureFiveDays(city.getFutureDays().toArrayList());
        for(Day d : city.getPastFiveDays()){
            d.setTwenty4Hours(d.getHoursMap().toArrayList());
            d.setHoursMap(null);
            d.setDate(d.getForecast().getDate()); 
            d.setForecast(null);
            d.setLocation(null);
            for(Hour h: d.getTwenty4Hours()){
                h.setLocation(null);
                h.setForecast(null);
            }
        }
        for(Day d : city.getFutureFiveDays()){
            d.setTwenty4Hours(d.getHoursMap().toArrayList());
            d.setHoursMap(null);
            d.setDate(d.getForecast().getDate()); 
            d.setForecast(null);
            d.setLocation(null);
            for(Hour h: d.getTwenty4Hours()){
                h.setLocation(null);
                h.setForecast(null);
            }
        }
        city.setPast_five_days(null);
        city.setFuture_five_days(null);
        return city;
    }
    public City populateCity(){
        City city = null;
        try{
            city = WeatherAppController.populateCity('c', "chantilly", -1);
        }
        catch(IOException e){

        }
        return city;
    }
    public static void main(String[] args){
        CityController c = new CityController();
        //System.out.println(c.get().getPastFiveDays());
    }
    
}
