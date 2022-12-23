package com.solvd.football_matches;

import com.solvd.football_matches.buildings.Stadium;
import com.solvd.football_matches.exceptions.InvalidLeague;
import com.solvd.football_matches.exceptions.InvalidOption;
import com.solvd.football_matches.main.Games;
import com.solvd.football_matches.main.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Test {

    public static final Logger LOGGER = LogManager.getLogger(Test.class);

    public static ArrayList<Stadium> stadiumList = new ArrayList<>();


    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {


        LOGGER.info("Start of the algorithm");

        //Add Stadiums
        Stadium campNou = new Stadium(90000, true, "Spotify Camp Nou");
        Stadium santBernabeu = new Stadium(81000, true, "Santiago Bernabéu");
        Stadium myGarden = new Stadium(2, false, "Fabri's garden");

        //Reflection for myGarden fields (available, name and capacity)

        //1st attempt (only boolean worked)
        /*
        try{
            Field fieldBoolean = myGarden.getClass().getField("available");
            fieldBoolean.setBoolean(myGarden, Boolean.TRUE);
            Field fieldName = myGarden.getClass().getField("name");
            fieldName.setAccessible(true);
            fieldName.set(myGarden, "Metropolitano");
            Field fieldCapacity = myGarden.getClass().getField("capacity");
            fieldCapacity.setAccessible(true);
            fieldCapacity.set(myGarden, 68000);
        } catch (Throwable ex){

        }
        */

        //2nd Attemp (String works)
        Field[] gardenFields = myGarden.getClass().getDeclaredFields();

        for(Field field: gardenFields){
            if(field.getName().equals("available")){
                field.setAccessible(true);
                field.set(myGarden, Boolean.TRUE);
            }
            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(myGarden, "Metropolitano");
            }
            if(field.getName().equals("capacity")){
                field.setAccessible(true);
                field.set(myGarden, 68000);
            }
        }


        //Adding stadiums to array
        stadiumList.add(campNou);
        stadiumList.add(santBernabeu);
        stadiumList.add(myGarden);


        //Lambda to sort stadium that are available  (if true they show up, false they will not)
        LOGGER.info("These are the stadiums available: ");
        ArrayList<Stadium> availableStadiums = (ArrayList<Stadium>) stadiumList.stream()
                .filter(stadium -> stadium.available == true)
                .collect(Collectors.toList());

        availableStadiums.forEach(stadium -> LOGGER.info(stadium.getName() + stadium.getCapacity() + stadium.isAvailable()));


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



                Games firstMatch = new Games();

                firstMatch.setTeamsTest();
                firstMatch.callMatch();

                String result = "Results: " + firstMatch.getTeamsTest(0) + " " + firstMatch.homeScore(0) + " " + firstMatch.getTeamsTest(1) + " " + firstMatch.awayScore(0);
                LOGGER.info(result);

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
