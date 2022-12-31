package com.solvd.football.match;

import java.time.LocalDateTime;

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

    
}
