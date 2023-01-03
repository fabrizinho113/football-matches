package com.solvd.football.person;

import com.solvd.football.interfaces.IFoul;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Coach extends Person implements IFoul {

    private static final Logger LOGGER = LogManager.getLogger(Coach.class);

    int complains;


    public Coach() {

    }

    public Coach(String name, int age, String fitness, int complains) {
        super(name, age, fitness);
        this.complains = complains;
    }

    public void nameCoach() {
        LOGGER.info("Write your name here: ");
        Scanner input = new Scanner(System.in);
        name = "Coach " + input.nextLine();
        LOGGER.info("Write your age here: ");
        age = input.nextInt();
        LOGGER.info("You are " + name + " and you're " + age + " years old");

    }

    @Override
    public void foul() {
        if (complains >= 4) {
            LOGGER.warn("The coach receives a " + YELLOW_CARD + " for protest");
        } else if (complains >= 6) {
            LOGGER.warn("The coach receives a " + RED_CARD);
            LOGGER.warn("The coach has been sent off!");
        }
    }

    @Override
    public void physicalEffort() {
        LOGGER.error("Coaches don't need to train since they aren't playing");
    }
}
