package com.solvd.football.exception;

public class InvalidSeason extends RuntimeException {
    public InvalidSeason() {
        super("Summer season is not playable due to vacations");
    }
}
