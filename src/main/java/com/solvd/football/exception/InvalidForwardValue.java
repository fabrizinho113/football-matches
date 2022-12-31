package com.solvd.football.exception;

public class InvalidForwardValue extends Exception {
    public InvalidForwardValue() {
        super("You can only have 1 up to 3 forwards");
    }
}
