package com.solvd.football_matches.person;

public class Forward extends Player{
    public int finishing;
    public int dribbling;

    public Forward(){

    }
    public Forward(String FirstName, String LastName, String Position, int age, int finishing, int dribbling){
        super(FirstName, LastName, Position, age);
        this.finishing=finishing;
        this.dribbling=dribbling;
    }

    public int getFinishing(){
        return this.finishing;
    }

    public int getDribbling(){
        return this.dribbling;
    }


}
