package com.solvd.football.person;

import com.solvd.football.interfaces.IFoul;
import com.solvd.football.interfaces.IShout;
import com.solvd.football.interfaces.ITrain;


public class Player extends Person implements ITrain, IFoul, IShout {

    private int skill;
    private int physical;
    int fouls;
    private String position;

    private int technique;

    public Player() {

    }

    public Player(String name, int age, String fitness, int skill, int physical, int fouls, String position, int technique) {
        super(name, age, fitness);
        this.skill = skill;
        this.physical = physical;
        this.fouls = fouls;
        this.position = position;
        this.technique = technique;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTechnique() {
        return technique;
    }

    public void setTechnique(int technique) {
        this.technique = technique;
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
    public void foul() {
        if (fouls >= 3) {
            System.out.println("The player receives a " + YELLOW_CARD + ".");
        } else if (fouls >= 6) {
            System.out.println("The player receives a " + RED_CARD + ". The player has been sent off!");
        }
    }

    @Override
    public void training() {
        if (LEVEL_FITNESS > physical) {
            System.out.println("This player is not ready for a match");
        } else {
            System.out.println("This player is ready to play a match");
        }
    }

    @Override
    public void cheer() {
        System.out.println(CROWD + "is shouting this player name!");
    }
}
