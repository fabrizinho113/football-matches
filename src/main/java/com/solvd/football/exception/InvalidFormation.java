package com.solvd.football.exception;

public class InvalidFormation extends RuntimeException {
    public InvalidFormation() {
        super("You have to select between these formations");
    }
}
