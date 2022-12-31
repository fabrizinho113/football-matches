package com.solvd.football.exception;

public class InvalidTeamSize extends Exception {
    public InvalidTeamSize() {
        super("One team has less than 8 players. The match cannot continue");
    }
}
