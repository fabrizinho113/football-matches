package com.solvd.football_matches.person;

public abstract class Player {
    public String firstName;
    public String lastName;
    public String position;
    public int age;

    public Player(){
    }

    public Player(String firstName, String lastName, String position, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getPosition(){
        return this.position;
    }

    public int getAge(){
        return this.age;
    }


}
