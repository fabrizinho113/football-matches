package com.solvd.football.match;

import java.time.LocalDateTime;
import java.util.Random;

public enum DaysAvailable {
    THURSDAY("Thursday", LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()),
    FRIDAY("Friday", LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()),
    SATURDAY("Saturday", LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());

    private String nameDay;
    private int timeHour;
    private int timeMinute;

    DaysAvailable(String nameDay, int timeHour, int timeMinute) {
        this.nameDay = nameDay;
        this.timeHour = timeHour;
        this.timeMinute = timeMinute;
    }

    public DaysAvailable randomDay() {
        int number = new Random().nextInt(DaysAvailable.values().length);
        return DaysAvailable.values()[number];
    }

    @Override
    public String toString() {
        return "The match is going to be on " + nameDay + " at " + timeHour + ":" + timeMinute;
    }
}
