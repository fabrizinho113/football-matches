package com.solvd.football;

import com.solvd.football.building.Stadium;
import com.solvd.football.exception.*;
import com.solvd.football.match.DaysAvailable;
import com.solvd.football.match.Match;
import com.solvd.football.match.Season;
import com.solvd.football.match.Weather;
import com.solvd.football.person.Coach;
import com.solvd.football.person.Player;
import com.solvd.football.person.Referee;
import com.solvd.football.team.AwayTeam;
import com.solvd.football.team.HomeTeam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LaLigaRunner {

    private static final Logger LOGGER = LogManager.getLogger(LaLigaRunner.class);

    public static void main(String[] args) {

        //Barcelona
        Player terStegen = new Player("ter Stegen", 30, "medium", 0, 70, 0, "GK", 7, 0);
        Player christensen = new Player("Christensen", 26, "medium", 0, 70, 0, "DF", 7, 1);
        Player sRoberto = new Player("Sergi Roberto", 30, "high", 0, 80, 0, "DF", 6, 2);
        Player garcia = new Player("Garcia", 21, "high", 0, 80, 0, "DF", 7, 3);
        Player jAlba = new Player("Jordi Alba", 33, "high", 0, 80, 0, "DF", 7, 4);
        Player busquets = new Player("Busquets", 34, "medium", 0, 70, 0, "MF", 8, 5);
        Player pedri = new Player("Pedri", 20, "high", 0, 90, 0, "MF", 8, 6);
        Player deJong = new Player("de Jong", 25, "high", 1, 90, 0, "MF", 9, 7);
        Player gavi = new Player("Gavi", 18, "high", 0, 90, 0, "MF", 8, 8);
        Player fati = new Player("Ansu Fati", 20, "high", 1, 90, 0, "FW", 8, 9);
        Player lewandowski = new Player("Lewandowski", 34, "high", 1, 90, 0, "FW", 9, 10);

        //Real Madrid
        Player courtois = new Player("Courtois", 30, "medium", 1, 70, 0, "GK", 8, 0);
        Player mendy = new Player("Mendy", 27, "high", 1, 80, 0, "DF", 8, 1);
        Player rudiger = new Player("Rüdiger", 29, "medium", 0, 80, 0, "DF", 7, 2);
        Player militao = new Player("Éder Militão", 24, "medium", 0, 70, 0, "DF", 7, 3);
        Player nacho = new Player("Nacho", 32, "medium", 0, 70, 0, "DF", 7, 4);
        Player valverde = new Player("Valverde", 24, "high", 1, 80, 0, "MF", 8, 5);
        Player modric = new Player("Modrić", 37, "medium", 1, 70, 0, "MF", 8, 6);
        Player kross = new Player("Kross", 32, "medium", 1, 70, 0, "MF", 9, 7);
        Player viniciusJr = new Player("Vinicius Junior", 22, "high", 1, 90, 0, "FW", 9, 8);
        Player benzema = new Player("Benzema", 35, "medium", 1, 70, 0, "FW", 8, 9);
        Player rodrygo = new Player("Rodrygo", 21, "high", 0, 90, 0, "FW", 8, 10);

        //Referees from LaLiga
        Referee lahoz = new Referee("Mateu Lahoz", 45, "medium", 10, 10, 70);
        Referee ricardo = new Referee("Ricardo de Burgos", 36, "high", 10, 10, 90);
        Referee carlos = new Referee("Carlos del Cerro", 46, "medium", 10, 10, 70);

        //Stadium
        Stadium campNou = new Stadium(100000, "Spotify Camp Nou");

        //Home team (you)
        //GK
        Match.homePlayerArrayList.add(terStegen);
        //DF
        Match.homePlayerArrayList.add(christensen);
        Match.homePlayerArrayList.add(sRoberto);
        Match.homePlayerArrayList.add(garcia);
        Match.homePlayerArrayList.add(jAlba);
        //MF
        Match.homePlayerArrayList.add(gavi);
        Match.homePlayerArrayList.add(busquets);
        Match.homePlayerArrayList.add(pedri);
        Match.homePlayerArrayList.add(deJong);
        //FW
        Match.homePlayerArrayList.add(lewandowski);
        Match.homePlayerArrayList.add(fati);


        //Away Team (opponent)
        //GK
        Match.awayPlayerArrayList.add(courtois);
        //DF
        Match.awayPlayerArrayList.add(mendy);
        Match.awayPlayerArrayList.add(rudiger);
        Match.awayPlayerArrayList.add(militao);
        Match.awayPlayerArrayList.add(nacho);
        //MF
        Match.awayPlayerArrayList.add(valverde);
        Match.awayPlayerArrayList.add(modric);
        Match.awayPlayerArrayList.add(kross);
        //FW
        Match.awayPlayerArrayList.add(benzema);
        Match.awayPlayerArrayList.add(rodrygo);
        Match.awayPlayerArrayList.add(viniciusJr);


        //Referees available
        Referee.refereeArrayList.add(lahoz);
        Referee.refereeArrayList.add(ricardo);
        Referee.refereeArrayList.add(carlos);


        Match match = new Match();

        Coach coach = new Coach();

        Coach ancelotti = new Coach("Carlo Ancelotti", 63, "medium", 0);

        HomeTeam homeTeam = new HomeTeam("FC Barcelona", "Home", coach, 3, Match.homePlayerArrayList, campNou);

        AwayTeam awayTeam = new AwayTeam("Real Madrid", "Away", ancelotti, 1, Match.awayPlayerArrayList);

        try {

            Season currentSeason = Season.FALL.randomSeason();

            Weather currentWeather = Weather.CLOUDY.randomWeather();

            DaysAvailable days = DaysAvailable.THURSDAY.randomDay();

            if (currentSeason != Season.SUMMER) {
                match.menu();

                coach.nameCoach();

                match.announcement(homeTeam, awayTeam);

                LOGGER.info(currentSeason::toString);

                LOGGER.info(currentWeather::toString);

                LOGGER.info(days::toString);

                homeTeam.playstyle();


                match.play(Match.homePlayerArrayList, Match.awayPlayerArrayList, Referee.selectRandomReferee(Referee.refereeArrayList));

                String result = "Results: " + homeTeam.getName() + " " + match.getTeam1Score() + " - " + awayTeam.getName() + " " + match.getTeam2Score();

                LOGGER.info(result);
            }


        } catch (InvalidCaptain | InvalidTeamSize | InvalidGoalkeeperValue | InvalidForwardValue | InvalidSeason e) {
            LOGGER.error(e.getMessage());
        }


    }
}
