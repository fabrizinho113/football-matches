package com.solvd.football.team;

import com.solvd.football.building.Stadium;
import com.solvd.football.exception.InvalidFormation;
import com.solvd.football.exception.InvalidPlayerValue;
import com.solvd.football.linkedlist.CustomLinkedList;
import com.solvd.football.person.Coach;
import com.solvd.football.person.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeTeam extends Team {

    private ArrayList<Player> homePlayers;

    private Stadium stadium;

    public HomeTeam() {

    }

    public HomeTeam(String name, String uniform, Coach coach, int rating, ArrayList<Player> homePlayers, Stadium stadium) {
        super(name, uniform, coach, rating);
        this.homePlayers = homePlayers;
        this.stadium = stadium;
    }

    public ArrayList<Player> getHomePlayers() {
        return homePlayers;
    }

    public void setHomePlayers(ArrayList<Player> homePlayers) {
        this.homePlayers = homePlayers;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public void playstyle() throws InvalidPlayerValue {

        Scanner input = new Scanner(System.in);

        CustomLinkedList<Integer> tactics = new CustomLinkedList<>();

        System.out.println("Select which type of playstyle you want to play: " +
                "1- Aggressive \n" + "2- Passive \n" + "3- Neutral");

        int instruction = input.nextInt();

        if (instruction < 0 || instruction > 3) {
            throw new InvalidFormation();
        }

        tactics.insert(instruction);
        System.out.println("You selected option number ");
        tactics.show();
    }
}
