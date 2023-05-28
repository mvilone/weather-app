package com.example.WeatherApp.model;

import java.io.IOException;

public interface CityInterface {
    public String getTempInCelcius() throws IOException;
    public String getTempInFahrenheit();
    public City getCity();
    public boolean equals();

    
}
