package com.example.WeatherApp.repository;
import com.example.WeatherApp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{


}
