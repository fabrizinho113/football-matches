package com.solvd.football.exception;

public class InvalidPlayerValue extends RuntimeException {
    public InvalidPlayerValue() {
        super("You have less than 3 players or more than 5 players in that position.");
    }
}
