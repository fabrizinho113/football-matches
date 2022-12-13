package com.solvd.football_matches.main;

import com.solvd.football_matches.person.Defender;
import com.solvd.football_matches.person.Forward;
import com.solvd.football_matches.person.Goalkeeper;
import com.solvd.football_matches.person.Midfielder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Match {

    public static final Logger LOGGER = (Logger) LogManager.getLogger(Menu.class);

    // 1 Goalkeeper, 4 defenders, 4 midfielders and 2 strikers for each team
    public Defender d1, d2, d3, d4, d5, d6, d7, d8;
    public Midfielder m1, m2, m3, m4, m5, m6, m7, m8;
    public Goalkeeper g1, g2;
    public Forward f1, f2, f3, f4;

    //Score starts at 0-0
    public int team1goal = 0;
    public int team2goal = 0;

    public Match(Goalkeeper g1, Defender d1, Defender d2, Defender d3, Defender d4, Midfielder m1, Midfielder m2, Midfielder m3, Midfielder m4, Forward f1, Forward f2,Goalkeeper g2, Defender d5, Defender d6, Defender d7, Defender d8, Midfielder m5, Midfielder m6, Midfielder m7, Midfielder m8, Forward f3, Forward f4){

        //Team 1
        this.g1=g1;
        this.d1=d1;
        this.d2=d2;
        this.d3=d3;
        this.d4=d4;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
        this.m4=m4;
        this.f1=f1;
        this.f2=f2;

        //Team 2
        this.g2=g2;
        this.d5=d5;
        this.d6=d6;
        this.d7=d7;
        this.d8=d8;
        this.m5=m5;
        this.m6=m6;
        this.m7=m7;
        this.m8=m8;
        this.f3=f3;
        this.f4=f4;
    }

    public void score(){

        //Amount of iterations that will happen (10 for testing)
        for (int i=0; i<10; i++){

            //To see which team gets the "ball" (output will be either 0 or 1)
            int bPossession = 0 + (int)(Math.random()*((1-0)+1));

            //How every play will start. If the pass goes through (1) then it will proceed to the next step.
            // Else it will reset and come back to the start point
            int pass = 0;

            //Almost near penalty area. This is where (most of the time) goals can happen.
            //Also in this section is where corners and penalties can happen
            int finalthird = 0;

            //If it's 1 then there's a chance to score
            int goalSituation = 0;

            //Corners and long shots (outside penalty area). Situation of goal
            int corner = 0;
            int longshots = 0;

            if(bPossession == 1){
                pass = 0 + (int)(Math.random()*((1-0)+1));

                switch(pass){
                    case 0:
                        break;
                    case 1:
                        if(m5.getPassing() > d3.getMarking() || m6.getPassing() > d2.getMarking()){

                            if(m7.getPassing() > d1.getMarking() || m8.getPassing() > d4.getMarking()){
                                finalthird = 0 + (int)(Math.random()*((1-0)+1));

                                switch (finalthird){
                                    case 0:
                                        break;
                                    case 1:
                                        goalSituation = 0 + (int)(Math.random()*((1-0)+1));

                                        if(goalSituation == 1){

                                            if(f3.getDribbling() > d2.getTackling() || f4.getDribbling() > d3.getTackling()){

                                                if(f4.getFinishing() > g1.getReflexes() || f3.getFinishing() > g1.getReflexes()){
                                                    //Logger here saying which team did score
                                                    team2goal = team2goal +1;
                                                }
                                                else{

                                                    corner = 0 + (int)(Math.random()*((1-0)+1));
                                                    longshots = 0 + (int)(Math.random()*((1-0)+1));

                                                    if(corner == 1){

                                                        if(d7.getHeading() > g1.getReflexes() || d6.getHeading() > g1.getReflexes()){

                                                            team2goal = team2goal+1;
                                                        }
                                                        else if (longshots == 1){

                                                            if(m7.getLongShots() > g1.getReflexes() || m6.getLongShots() > g1.getReflexes()){

                                                                team2goal = team2goal +1;
                                                            }
                                                        }
                                                        else{
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            else{
                                                break;
                                            }
                                        }
                                        else{
                                            break;
                                        }
                                }
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }
                }
            }

            else if(bPossession == 0){

                pass = 0 + (int)(Math.random()*((1-0)+1));

                switch(pass){
                    case 0:
                        break;
                    case 1:
                        if(m3.getPassing() > d7.getMarking() || m2.getPassing() > d6.getMarking()){

                            if(m7.getPassing() > d1.getMarking() || m8.getPassing() > d4.getMarking()){
                                finalthird = 0 + (int)(Math.random()*((1-0)+1));

                                switch (finalthird){
                                    case 0:
                                        break;
                                    case 1:
                                        goalSituation = 0 + (int)(Math.random()*((1-0)+1));

                                        if(goalSituation == 1){

                                            if(f1.getDribbling() > d7.getTackling() || f2.getDribbling() > d6.getTackling()){

                                                if(f1.getFinishing() > g2.getReflexes() || f2.getFinishing() > g2.getReflexes()){
                                                    //Logger here saying which team did score
                                                    team1goal = team1goal +1;
                                                }
                                                else{

                                                    corner = 0 + (int)(Math.random()*((1-0)+1));
                                                    longshots = 0 + (int)(Math.random()*((1-0)+1));

                                                    if(corner == 1){

                                                        if(d2.getHeading() > g2.getReflexes() || d3.getHeading() > g2.getReflexes()){

                                                            team1goal = team1goal+1;
                                                        }
                                                        else if (longshots == 1){

                                                            if(m3.getLongShots() > g2.getReflexes() || m2.getLongShots() > g2.getReflexes()){

                                                                team1goal = team1goal +1;
                                                            }
                                                        }
                                                        else{
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            else{
                                                break;
                                            }
                                        }
                                        else{
                                            break;
                                        }
                                }
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }
                }
            }
        }
    }

    public int getTeam1Score() {
        return this.team1goal;
    }

    public int getTeam2Score() {
        return this.team2goal;
    }
}
