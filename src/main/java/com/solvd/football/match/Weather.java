package com.solvd.football.match;

import java.util.Random;

public enum Weather {
    SUNNY("Sunny", 29, 0),
    CLOUDY("Cloudy", 15, 45),
    WINDY("Windy", 13, 30),
    RAINY("Rainy", 23, 95),
    STORMY("Stormy", -2, 40);

    private String name;
    private int temperature;
    private int humidity;

    private Weather(String name, int temperature, int humidity) {
        this.name = name;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public Weather randomWeather() {
        int number = new Random().nextInt(Weather.values().length);
        return Weather.values()[number];
    }

    @Override
    public String toString() {
        return "The weather is " + name + ", temperature is " + temperature + "°C and the humidity is " + humidity + "%.";
    }
}
