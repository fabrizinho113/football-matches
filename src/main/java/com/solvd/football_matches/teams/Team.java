package com.solvd.football_matches.teams;

public class Team{

    public String teamName;
    public int teamRating;

    public Team(String teamName, int teamRating){
        this.teamName=teamName;
        this.teamRating=teamRating;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public int getTeamRating(){
        return this.teamRating;
    }

}
