package com.solvd.football.person;

import com.solvd.football.interfaces.IFoul;

import java.util.Scanner;

public class Coach extends Person implements IFoul {

    int players;
    int complains;


    public Coach() {

    }

    public Coach(String name, int age, String fitness, int players, int complains) {
        super(name, age, fitness);
        this.players = players;
        this.complains = complains;
    }

    public void nameCoach() {
        System.out.println("Write your name here: ");
        Scanner input = new Scanner(System.in);
        name = "Coach " + input.nextLine();
        System.out.println("You are " + name);
    }

    @Override
    public void foul() {
        if (complains >= 4) {
            System.out.println("The coach receives a " + YELLOW_CARD + " for protest");
        } else if (complains >= 6) {
            System.out.println("The coach receives a " + RED_CARD);
            System.out.println("The coach has been sent off!");
        }
    }

    @Override
    public void physicalEffort() {
        System.out.println("Coaches don't need to train since they aren't playing");
    }
}
