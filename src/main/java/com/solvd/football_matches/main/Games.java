package com.solvd.football_matches.main;

import com.solvd.football_matches.person.Defender;
import com.solvd.football_matches.person.Forward;
import com.solvd.football_matches.person.Goalkeeper;
import com.solvd.football_matches.person.Midfielder;
import com.solvd.football_matches.teams.Team;

import java.util.ArrayList;
import java.util.LinkedList;

public class Games {

    //Match[] games = new Match[1];
    //Team[] teams = new Team[3];

    ArrayList<Team> teamsTest = new ArrayList<>();
    LinkedList<Match> gamesTest = new LinkedList<>();
    private int index;


    //La Liga

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

    //Real Madrid
    Goalkeeper t2g = new Goalkeeper("Thibaut", "Courtois", "GK", 30, 17, 18);
    Defender t2d1 = new Defender("Daniel", "Carvajal", "CB", 30, 15, 17, 17);
    Defender t2d2 = new Defender("David", "Alaba", "CB", 30, 19, 17, 18);
    Defender t2d3 = new Defender("Antonio", "Rüdiger", "RB", 29, 13, 16, 17);
    Defender t2d4 = new Defender("Ferland", "Mendy", "LB", 27, 15, 17, 16);
    Midfielder t2m1 = new Midfielder("Toni", "Kroos", "CM", 32, 16, 15);
    Midfielder t2m2 = new Midfielder("Luka", "Modrić", "CM", 37, 17, 15);
    Midfielder t2m3 = new Midfielder("Federico", "Valverde", "CM", 24, 18, 19);
    Midfielder t2m4 = new Midfielder("Daniel", "Ceballos", "CM", 26, 16, 18);
    Forward t2f1 = new Forward("Vinicius", "Junior", "ST", 22, 18, 17);
    Forward t2f2 = new Forward("Karim", "Benzema", "ST", 35, 19, 17);

    //Atletico de Madrid

    Goalkeeper t3g = new Goalkeeper("Thibaut", "Courtois", "GK", 30, 17, 18);
    Defender t3d1 = new Defender("Daniel", "Carvajal", "CB", 30, 15, 17, 17);
    Defender t3d2 = new Defender("David", "Alaba", "CB", 30, 19, 17, 18);
    Defender t3d3 = new Defender("Antonio", "Rüdiger", "RB", 29, 13, 16, 17);
    Defender t3d4 = new Defender("Ferland", "Mendy", "LB", 27, 15, 17, 16);
    Midfielder t3m1 = new Midfielder("Toni", "Kroos", "CM", 32, 16, 15);
    Midfielder t3m2 = new Midfielder("Luka", "Modrić", "CM", 37, 17, 15);
    Midfielder t3m3 = new Midfielder("Federico", "Valverde", "CM", 24, 18, 19);
    Midfielder t3m4 = new Midfielder("Daniel", "Ceballos", "CM", 26, 16, 18);
    Forward t3f1 = new Forward("Vinicius", "Junior", "ST", 22, 18, 17);
    Forward t3f2 = new Forward("Karim", "Benzema", "ST", 35, 19, 17);


    public void setTeams() {
        //teams[0] = new Team("Barcelona FC", 7);
        //teams[1] = new Team("Real Madrid FC", 3);
        //teams[2] = new Team("Atletico de Madrid FC", 5);
    }

    public void setTeamsTest(){
        teamsTest.add(new Team("Barcelona FC", 7));
        teamsTest.add(new Team("Real Madrid FC", 3));
    }

    public String getTeamsTest(int i){
        return teamsTest.get(i).getTeamName();
    }



    public void callMatch(){

        //Barcelona vs Barcelona as test
        //games[0] = new Match(t1g, t1d1, t1d2, t1d3, t1d4, t1m1, t1m2, t1m3, t1m4, t1f1, t1f2, t2g, t2d1, t2d2, t2d3, t2d4, t2m1, t2m2, t2m3, t2m4, t2f1, t2f2);
        gamesTest.add(new Match(t1g, t1d1, t1d2, t1d3, t1d4, t1m1, t1m2, t1m3, t1m4, t1f1, t1f2, t2g, t2d1, t2d2, t2d3, t2d4, t2m1, t2m2, t2m3, t2m4, t2f1, t2f2));

        for(int i=0; i<gamesTest.size(); i++){
            gamesTest.get(i).score();
        }

    }

    public int homeScore(int i){
        return gamesTest.get(i).getTeam1Score();
        //return games[i].getTeam1Score();
    }

    public int awayScore(int i){

        return gamesTest.get(i).getTeam2Score();
        //return games[i].getTeam2Score();
    }
}
