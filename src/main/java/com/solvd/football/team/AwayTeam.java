package com.solvd.football.team;

import com.solvd.football.interfaces.IShout;
import com.solvd.football.person.Coach;
import com.solvd.football.person.Player;

import java.util.ArrayList;

public class AwayTeam extends Team implements IShout {

    private ArrayList<Player> homePlayers;

    public AwayTeam() {
    }

    public AwayTeam(String name, String uniform, Coach coach, int rating, ArrayList<Player> homePlayers) {
        super(name, uniform, coach, rating);
        this.homePlayers = homePlayers;
    }

    public ArrayList<Player> getHomePlayers() {
        return homePlayers;
    }

    public void setHomePlayers(ArrayList<Player> homePlayers) {
        this.homePlayers = homePlayers;
    }

    @Override
    public void cheer() {
        System.out.println(CROWD + "is cheering for the away team!");
    }
}
