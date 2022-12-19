package com.solvd.football_matches.person;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age && Objects.equals(firstName, player.firstName) && Objects.equals(lastName, player.lastName) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, position, age);
    }


}
