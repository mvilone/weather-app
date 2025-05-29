package com.example.WeatherApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WeatherApp.model.City;
import com.example.WeatherApp.model.CurrentWeather;
import com.example.WeatherApp.repository.CityRepository;
@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;
    public City saveCity(City city){
        return cityRepository.save(city);

    }
    
}
