package com.solvd.football_matches;

import com.solvd.football_matches.exceptions.InvalidLeague;
import com.solvd.football_matches.exceptions.InvalidOption;
import com.solvd.football_matches.main.MatchSchedule;
import com.solvd.football_matches.main.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

    public static final Logger LOGGER = LogManager.getLogger(Test.class);

    public static void main(String[] args) {

        LOGGER.info("Start of the algorithm");

        int option = 0;

        //Menu
        Menu.showMenu();
        //Selected option

        try {
            option = Menu.selectOption();
        } catch (InvalidOption e) {
            LOGGER.warn(e.getMessage());
        }

        switch (option) {
            case 1:

                Menu.showLeagues();

                try {
                    option = Menu.selectLeague();
                    LOGGER.info("Option selected successfully");
                } catch (InvalidLeague e) {
                    LOGGER.warn(e.getMessage());
                }

                MatchSchedule firstMatch = new MatchSchedule();

                firstMatch.setTeams();
                firstMatch.callMatch();

                System.out.println("Results: " + firstMatch.getTeams(0) + " " + firstMatch.homeScore(0) + " " + firstMatch.getTeams(1) + " " + firstMatch.awayScore(0));
                LOGGER.info("Results: " + firstMatch.getTeams(0) + " " + firstMatch.homeScore(0) + " " + firstMatch.getTeams(1) + " " + firstMatch.awayScore(0));

            case 2:
                Menu.showLeagues();

                try {
                    option = Menu.selectLeague();
                    LOGGER.info("Option selected successfully");
                } catch (InvalidLeague e) {
                    LOGGER.warn(e.getMessage());
                }

                break;
            case 3:

                break;

        }


    }
}
