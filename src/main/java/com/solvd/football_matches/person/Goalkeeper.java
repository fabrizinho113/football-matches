package com.solvd.football_matches.person;

public class Goalkeeper extends Player {
    public int reflexes;
    public int save;

    public Goalkeeper(){

    }

    public Goalkeeper(String FirstName, String LastName, String Position, int age, int reflexes, int save){
        super(FirstName, LastName, Position, age);
        this.reflexes=reflexes;
        this.save=save;
    }

    public int getSave(){
        return this.save;
    }
    public int getReflexes(){
        return this.reflexes;
    }

}
