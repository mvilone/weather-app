package com.example.WeatherApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.WeatherApp.model.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
    
}
