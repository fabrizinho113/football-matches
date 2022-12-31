package com.solvd.football.team;

import com.solvd.football.person.Coach;

public class Team {

    private String name;
    private String uniform;
    private Coach coach;
    private int rating;

    public Team() {

    }

    public Team(String name, String uniform, Coach coach, int rating) {
        this.name = name;
        this.uniform = uniform;
        this.coach = coach;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
