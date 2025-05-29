package com.example.WeatherApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WeatherApp.model.Location;
import com.example.WeatherApp.repository.LocationRepository;

@Service
public class LocationImpl implements LocationService{
    @Autowired
    private LocationRepository currentweatherRepositor;
    public Location saveLocation(Location location){
        return currentweatherRepositor.save(location);
    }

    
}
