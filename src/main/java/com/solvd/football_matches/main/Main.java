package com.solvd.football_matches.main;

import com.solvd.football_matches.exceptions.InvalidLeague;
import com.solvd.football_matches.exceptions.InvalidOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Main {

    public static final Logger LOGGER = (Logger) LogManager.getLogger(Main.class);

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
                    /*
                    Referee mainRef = new Referee("Danny", "Makkelie", 39, "Main Referee");
                    Referee lineJudgeOne = new Referee("Antonio", "Mateu Lahoz", 45, "Line Judge");
                    Referee lineJudgeTwo = new Referee("Said", "Martinez", 31, "Line Judge");

                    //Creating an array
                    Referee[] referees = {mainRef, lineJudgeOne, lineJudgeTwo};

                    //ForEach
                    for (Referee referee : referees) {
                        System.out.println(referee.toString());
                    }
                     */
                break;

        }


    }
}
