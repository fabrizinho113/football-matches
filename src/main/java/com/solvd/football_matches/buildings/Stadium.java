package com.solvd.football_matches.buildings;

import com.solvd.football_matches.interfaces.IVisit;

import java.util.ArrayList;

public class Stadium extends Building implements IVisit {

    private String name;

    public ArrayList<Stadium> stadiumList = new ArrayList<>();

    public Stadium(){

    }

    public Stadium(int capacity, boolean available, String name){
        super(capacity, available);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean fans(){
        return true;
    }

    @Override
    public void visit(){
        System.out.println("The stadium will be filled by fans from both the Home and Away team");
    }
}
