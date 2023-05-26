package com.example.WeatherApp.model;

public class Condition {
    private String text;
    private String icon;
    private int code;

    public String getIcon() {
        return icon;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
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
