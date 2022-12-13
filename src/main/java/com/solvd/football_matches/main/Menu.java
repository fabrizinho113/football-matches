package com.solvd.football_matches.main;

import com.solvd.football_matches.exceptions.InvalidLeague;
import com.solvd.football_matches.exceptions.InvalidOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Scanner;

public abstract class Menu {

    public static final Logger LOGGER = (Logger) LogManager.getLogger(Menu.class);

    public static void showMenu() {
        LOGGER.info("1. Check Leagues matches (WIP)\s" +
                "2. Check Champions League matches (WIP)\s" +
                "3. Exit \s");
    }

    public static void showLeagues() {
        LOGGER.info("Select what matches you want to see: \n");
        LOGGER.info("1- National leagues (Ligue 1, La Liga, Premier League, etc)\n" +
                "2- Champions League\n");
    }

    public static int selectOption() throws InvalidOption {

        Scanner input = new Scanner(System.in);

        int option;

        option = input.nextInt();

        if (option < 1 || option > 3) {
            throw new InvalidOption("Invalid option");
        }
        return option;
    }

    public static int selectLeague() throws InvalidLeague {
        Scanner input = new Scanner(System.in);
        int option;

        option = input.nextInt();
        if (option < 1 || option > 7) {
            throw new InvalidLeague("Invalid league");
        }
        return option;
    }
}