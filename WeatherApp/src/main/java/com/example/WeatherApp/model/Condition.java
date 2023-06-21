package com.example.WeatherApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="condition_table")
public class Condition {
    private int id;
    private String text;
    private String icon;
    private int code;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public String getIcon() {
        return icon;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setText(String text) {
        this.text = text;
    }
}
