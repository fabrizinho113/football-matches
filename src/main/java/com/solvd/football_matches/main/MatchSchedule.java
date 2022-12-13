package com.solvd.football_matches.main;

import com.solvd.football_matches.person.Defender;
import com.solvd.football_matches.person.Forward;
import com.solvd.football_matches.person.Goalkeeper;
import com.solvd.football_matches.person.Midfielder;
import com.solvd.football_matches.teams.Team;

public class MatchSchedule {

    Match[] games = new Match[1];
    Team[] teams = new Team[2];

    //Barcelona
    Goalkeeper t1g = new Goalkeeper("Marc Andre", "ter Stegen", "GK", 30, 17, 17);
    Defender t1d1 = new Defender("Ronald Federico", "Araujo da Silva", "CB", 23, 15, 17, 17);
    Defender t1d2 = new Defender("Hector", "Bellerin", "CB", 27, 19, 17, 18);
    Defender t1d3 = new Defender("Andreas", "Christensen", "RB", 26, 13, 16, 17);
    Defender t1d4 = new Defender("Jordi", "Alba", "LB", 33, 15, 17, 16);
    Midfielder t1m1 = new Midfielder("Sergio", "Busquets", "CDM", 34, 16, 15);
    Midfielder t1m2 = new Midfielder("Frenkie", "de Jong", "CM", 25, 17, 15);
    Midfielder t1m3 = new Midfielder("Pedro", "Gonzalez Lopez", "CM", 20, 18, 19);
    Midfielder t1m4 = new Midfielder("Pablo", "Paez Gavira", "CM", 18, 16, 18);
    Forward t1f1 = new Forward("Anssumane", "Fati", "ST", 20, 18, 17);
    Forward t1f2 = new Forward("Robert", "Lewandowski", "ST", 34, 19, 17);

    //Barcelona
    Goalkeeper t2g = new Goalkeeper("Marc Andre", "ter Stegen", "GK", 30, 17, 17);
    Defender t2d1 = new Defender("Ronald Federico", "Araujo da Silva", "CB", 23, 15, 17, 17);
    Defender t2d2 = new Defender("Hector", "Bellerin", "CB", 27, 19, 17, 18);
    Defender t2d3 = new Defender("Andreas", "Christensen", "RB", 26, 13, 16, 17);
    Defender t2d4 = new Defender("Jordi", "Alba", "LB", 33, 15, 17, 16);
    Midfielder t2m1 = new Midfielder("Sergio", "Busquets", "CDM", 34, 16, 15);
    Midfielder t2m2 = new Midfielder("Frenkie", "de Jong", "CM", 25, 17, 15);
    Midfielder t2m3 = new Midfielder("Pedro", "Gonzalez Lopez", "CM", 20, 18, 19);
    Midfielder t2m4 = new Midfielder("Pablo", "Paez Gavira", "CM", 18, 16, 18);
    Forward t2f1 = new Forward("Anssumane", "Fati", "ST", 20, 18, 17);
    Forward t2f2 = new Forward("Robert", "Lewandowski", "ST", 34, 19, 17);


    public void setTeams() {
        teams[0] = new Team("Barcelona FC", 7);
        teams[1] = new Team("Barcelona FC", 7);
    }

    public String getTeams(int i){
        return teams[i].getTeamName();
    }

    public void callMatch(){

        //Barcelona vs Barcelona as test
        games[0] = new Match(t1g, t1d1, t1d2, t1d3, t1d4, t1m1, t1m2, t1m3, t1m4, t1f1, t1f2, t2g, t2d1, t2d2, t2d3, t2d4, t2m1, t2m2, t2m3, t2m4, t2f1, t2f2);

        for(int i=0; i<1; i++){
            games[i].score();
        }
    }

    public int homeScore(int i){
        return games[i].getTeam1Score();
    }

    public int awayScore(int i){
        return games[i].getTeam2Score();
    }
}
