package com.example.WeatherApp;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootTest
public class WeatherAppApplicationTests {

    static {
        String envPath = System.getProperty("user.dir");
        Dotenv dotenv = null;

        try {
            // Try current directory first (for main())
            dotenv = Dotenv.configure()
                    .directory(envPath)
                    .filename(".env")
                    .load();
        } catch (Exception e) {
            // Fallback to parent dir (for JUnit from /WeatherApp)
            envPath = Paths.get(envPath).getParent().toString();
            dotenv = Dotenv.configure()
                    .directory(envPath)
                    .filename(".env")
                    .load();
        }

        System.setProperty("spring.datasource.username", "root");
        System.setProperty("spring.datasource.password", dotenv.get("MYSQL_PASSWORD"));
        System.setProperty("weather.api.key", dotenv.get("WEATHER_API_KEY"));

        System.out.println("Loaded .env from: " + envPath);
        System.out.println("MYSQL_PASSWORD: " + dotenv.get("MYSQL_PASSWORD"));
    }

    @Test
    void contextLoads() {
        System.out.println("Spring Boot context loaded successfully.");
    }
}
