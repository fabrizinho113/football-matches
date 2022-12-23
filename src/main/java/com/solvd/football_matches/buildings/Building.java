package com.solvd.football_matches.buildings;

public abstract class Building {
    public int capacity;

    public boolean available;

    public Building(){

    }

    public Building (int capacity, boolean available){

        this.capacity = capacity;
        this.available = available;
    }



    public void setCapacity(int crowd) {
        this.capacity = crowd;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public abstract boolean fans();
}
