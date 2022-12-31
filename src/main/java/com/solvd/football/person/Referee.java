package com.solvd.football.person;

import com.solvd.football.interfaces.ITrain;

import java.util.ArrayList;

public class Referee extends Person implements ITrain {

    private int yellowCards;
    private int redCards;
    private int physical;

    public static ArrayList<Referee> refereeArrayList = new ArrayList<>();

    public Referee() {
    }

    public Referee(String name, int age, String fitness, int yellowCards, int redCards, int physical) {
        super(name, age, fitness);
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.physical = physical;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }


    @Override
    public void physicalEffort() {
        switch (fitness) {
            case "low":
                physical = -5;
                break;
            case "medium":
                physical = -10;
                break;
            case "high":
                physical = -20;
                break;
        }
    }

    @Override
    public void training() {
        if (LEVEL_FITNESS > physical) {
            System.out.println("The referee is not ready for a match");
        } else {
            System.out.println("The referee is ready to play a match");
        }
    }
}
