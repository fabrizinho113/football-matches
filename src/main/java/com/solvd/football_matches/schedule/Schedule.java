package com.solvd.football_matches.schedule;

public class Schedule {

    private String country;
    private DaysOfTheWeek available;

    public Schedule(){

    }

    public Schedule(String country, DaysOfTheWeek available){
        this.country = country;
        this.available = available;
    }

    public String getCountry() {
        return country;
    }

    public DaysOfTheWeek getAvailable() {
        return available;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAvailable(DaysOfTheWeek available) {
        this.available = available;
    }
}
