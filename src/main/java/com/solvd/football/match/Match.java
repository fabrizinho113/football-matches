package com.solvd.football.match;

import com.solvd.football.exception.*;
import com.solvd.football.person.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Match {

    public static final Logger LOGGER = LogManager.getLogger(Match.class);
    public static ArrayList<Player> homePlayerArrayList = new ArrayList<>();

    public static ArrayList<Player> awayPlayerArrayList = new ArrayList<>();

    //Score starts at 0-0
    public int team1goal = 0;
    public int team2goal = 0;


    public void menu() throws InvalidCaptain {

        System.out.println("These are the best rating players for the home team (you): ");

        ArrayList<Player> homePlayersSorted = (ArrayList<Player>) homePlayerArrayList.stream()
                .filter(player -> player.getSkill() == 1).sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());

        homePlayersSorted.forEach(player -> System.out.println(player.getName()));

        System.out.println("These are the best rating players for the away team (opponent): ");

        ArrayList<Player> awayPlayersSorted = (ArrayList<Player>) awayPlayerArrayList.stream()
                .filter(player -> player.getSkill() == 1).sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());

        awayPlayersSorted.forEach(player -> System.out.println(player.getName()));

        Scanner input = new Scanner(System.in);

        System.out.println("Select the captain for your team: ");
        System.out.println("0-" + homePlayerArrayList.get(0).getName() + "\n" +
                "1-" + homePlayerArrayList.get(1).getName() + "\n" +
                "2-" + homePlayerArrayList.get(2).getName() + "\n" +
                "3-" + homePlayerArrayList.get(3).getName() + "\n" +
                "4-" + homePlayerArrayList.get(4).getName() + "\n" +
                "5-" + homePlayerArrayList.get(5).getName() + "\n" +
                "6-" + homePlayerArrayList.get(6).getName() + "\n" +
                "7-" + homePlayerArrayList.get(7).getName() + "\n" +
                "8-" + homePlayerArrayList.get(8).getName() + "\n" +
                "9-" + homePlayerArrayList.get(9).getName() + "\n" +
                "10-" + homePlayerArrayList.get(10).getName() + "\n"
        );

        int chooseCaptain = input.nextInt();

        if (chooseCaptain < 0 || chooseCaptain > 10) {
            throw new InvalidCaptain();
        } else {
            int captainIndex = homePlayerArrayList.get(chooseCaptain).getSkill();
            System.out.println(homePlayerArrayList.get(captainIndex).getName() + " is the captain of the home team.");
        }

    }

    public void play(ArrayList<Player> homeTeam, ArrayList<Player> awayTeam) throws InvalidTeamSize, InvalidGoalkeeperValue, InvalidForwardValue {

        if (homeTeam.size() < 8 || awayTeam.size() < 8) {
            throw new InvalidTeamSize();
        }

        //Home team filtered

        ArrayList<Player> homeGkSorted = (ArrayList<Player>) homeTeam.stream()
                .filter(player -> player.getPosition() == "GK")
                .sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());

        ArrayList<Player> homeDfSorted = (ArrayList<Player>) homeTeam.stream()
                .filter(player -> player.getPosition() == "DF").sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());

        ArrayList<Player> homeMfSorted = (ArrayList<Player>) homeTeam.stream()
                .filter(player -> player.getPosition() == "MF").sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());

        ArrayList<Player> homeFwSorted = (ArrayList<Player>) homeTeam.stream()
                .filter(player -> player.getPosition() == "FW").sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());


        System.out.println("Home team: \n");


        if (homeGkSorted.size() != 1) {
            throw new InvalidGoalkeeperValue();
        } else {
            System.out.println("Goalkeeper:");
            homeGkSorted.forEach(player -> System.out.println(player.getName()));
        }

        if (homeDfSorted.size() < 2 || homeDfSorted.size() > 5 || homeMfSorted.size() < 2 || homeMfSorted.size() > 5) {
            throw new InvalidPlayerValue();
        } else {
            System.out.println("---");
            System.out.println("Defenders:");
            homeDfSorted.forEach(player -> System.out.println(player.getName()));
            System.out.println("---");
            System.out.println("Midfielders:");
            homeMfSorted.forEach(player -> System.out.println(player.getName()));
        }

        if (homeFwSorted.size() > 3) {
            throw new InvalidForwardValue();
        } else {
            System.out.println("---");
            System.out.println("Forwards:");
            homeFwSorted.forEach(player -> System.out.println(player.getName()));
        }


        //Away team filtered

        ArrayList<Player> awayGkSorted = (ArrayList<Player>) awayTeam.stream()
                .filter(player -> player.getPosition() == "GK").sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());

        ArrayList<Player> awayDfSorted = (ArrayList<Player>) awayTeam.stream()
                .filter(player -> player.getPosition() == "DF").sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());


        ArrayList<Player> awayMfSorted = (ArrayList<Player>) awayTeam.stream()
                .filter(player -> player.getPosition() == "MF").sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());

        ArrayList<Player> awayFwSorted = (ArrayList<Player>) awayTeam.stream()
                .filter(player -> player.getPosition() == "FW").sorted(Comparator.comparing(player -> player.getName()))
                .collect(Collectors.toList());

        System.out.println("Away team: \n");

        if (awayGkSorted.size() != 1) {
            throw new InvalidGoalkeeperValue();
        } else {
            System.out.println("Goalkeeper:");
            awayGkSorted.forEach(player -> System.out.println(player.getName()));
        }

        if (awayDfSorted.size() < 2 || awayDfSorted.size() > 5 || awayMfSorted.size() < 2 || awayMfSorted.size() > 5) {
            throw new InvalidPlayerValue();
        } else {
            System.out.println("---");
            System.out.println("Defenders:");
            awayDfSorted.forEach(player -> System.out.println(player.getName()));
            System.out.println("---");
            System.out.println("Midfielders:");
            awayMfSorted.forEach(player -> System.out.println(player.getName()));
        }

        if (awayFwSorted.size() > 3) {
            throw new InvalidForwardValue();
        } else {
            System.out.println("---");
            System.out.println("Forwards:");
            awayFwSorted.forEach(player -> System.out.println(player.getName()));
        }


        for (int i = 0; i < 25; i++) {

            //To see which team gets the "ball" (output will be either 0 or 1)
            int bPossession = 0 + (int) (Math.random() * ((1 - 0) + 1));

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


            if (bPossession == 1) {
                pass = 0 + (int) (Math.random() * ((1 - 0) + 1));

                switch (pass) {
                    case 0:
                        break;
                    case 1:
                        if (homeMfSorted.get(0).getTechnique() > awayMfSorted.get(0).getTechnique() ||
                                homeMfSorted.get(1).getTechnique() > awayMfSorted.get(1).getTechnique()) {

                            finalthird = 0 + (int) (Math.random() * ((1 - 0) + 1));

                            switch (finalthird) {
                                case 0:
                                    break;
                                case 1:
                                    goalSituation = 0 + (int) (Math.random() * ((1 - 0) + 1));

                                    if (goalSituation == 1) {

                                        if (homeFwSorted.get(0).getTechnique() > awayGkSorted.get(0).getTechnique() ||
                                                homeFwSorted.get(1).getTechnique() > awayGkSorted.get(0).getTechnique()) {
                                            //Logger here saying which team did score
                                            team1goal = team1goal + 1;
                                            LOGGER.info("Goal!");
                                        } else {

                                            corner = 0 + (int) (Math.random() * ((1 - 0) + 1));
                                            longshots = 0 + (int) (Math.random() * ((1 - 0) + 1));

                                            if (corner == 1) {

                                                if (homeDfSorted.get(0).getTechnique() > awayGkSorted.get(0).getTechnique() ||
                                                        homeDfSorted.get(1).getTechnique() > awayGkSorted.get(0).getTechnique()) {

                                                    team1goal = team1goal + 1;
                                                    LOGGER.info("Goal!");
                                                } else if (longshots == 1) {

                                                    if (homeMfSorted.get(0).getTechnique() > awayGkSorted.get(0).getTechnique() ||
                                                            homeMfSorted.get(1).getTechnique() > awayGkSorted.get(0).getTechnique()) {

                                                        team1goal = team1goal + 1;
                                                        LOGGER.info("Goal!");
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            break;
                        }
                }
            } else if (bPossession == 0) {

                pass = 0 + (int) (Math.random() * ((1 - 0) + 1));

                switch (pass) {
                    case 0:
                        break;
                    case 1:
                        if (awayMfSorted.get(0).getTechnique() > homeDfSorted.get(0).getTechnique() ||
                                awayMfSorted.get(1).getTechnique() > homeDfSorted.get(1).getTechnique()) {

                            finalthird = 0 + (int) (Math.random() * ((1 - 0) + 1));

                            switch (finalthird) {
                                case 0:
                                    break;
                                case 1:
                                    goalSituation = 0 + (int) (Math.random() * ((1 - 0) + 1));

                                    if (goalSituation == 1) {

                                        if (awayFwSorted.get(0).getTechnique() > homeDfSorted.get(0).getTechnique() ||
                                                awayFwSorted.get(0).getTechnique() > homeDfSorted.get(1).getTechnique()) {

                                            //Logger here saying which team did score
                                            team2goal = team2goal + 1;
                                            LOGGER.info("Goal!");
                                        } else {

                                            corner = 0 + (int) (Math.random() * ((1 - 0) + 1));
                                            longshots = 0 + (int) (Math.random() * ((1 - 0) + 1));

                                            if (corner == 1) {

                                                if (awayDfSorted.get(0).getTechnique() > homeGkSorted.get(0).getTechnique() ||
                                                        awayDfSorted.get(1).getTechnique() > homeGkSorted.get(0).getTechnique()) {

                                                    team2goal = team2goal + 1;
                                                    LOGGER.info("Goal!");
                                                } else if (longshots == 1) {

                                                    if (awayMfSorted.get(0).getTechnique() > homeGkSorted.get(0).getTechnique() ||
                                                            awayMfSorted.get(1).getTechnique() > homeGkSorted.get(0).getTechnique()) {

                                                        team2goal = team2goal + 1;
                                                        LOGGER.info("Goal!");
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            break;
                        }
                }
            } else {
                break;
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
