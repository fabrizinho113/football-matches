package com.solvd.football.exception;

public class InvalidGoalkeeperValue extends Exception {
    public InvalidGoalkeeperValue() {
        super("You only need to have one goalkeeper");
    }
}
