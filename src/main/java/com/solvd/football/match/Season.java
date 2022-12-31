package com.solvd.football.match;

public enum Season {
    WINTER("Winter", false),
    SPRING("Spring", false),
    SUMMER("Summer", true),
    FALL("Fall", false);

    private String seasonName;
    private boolean isOffSeason;

    private Season(String seasonName, boolean isOffSeason) {
        this.seasonName = seasonName;
        this.isOffSeason = isOffSeason;
    }
}
