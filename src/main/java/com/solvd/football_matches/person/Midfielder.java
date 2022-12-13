package com.solvd.football_matches.person;

public class Midfielder extends Player{
    public int passing;
    public int LongShots;

    public Midfielder(){

    }

    public Midfielder(String FirstName, String LastName, String Position, int age, int passing, int LongShots){
        super(FirstName, LastName, Position, age);
        this.passing=passing;
        this.LongShots=LongShots;
    }

    public int getPassing(){
        return this.passing;
    }
    public int getLongShots(){
        return this.LongShots;
    }

}
