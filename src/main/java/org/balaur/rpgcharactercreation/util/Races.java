package org.balaur.rpgcharactercreation.util;

public enum Races {
    HUMAN("Human"),
    ORC("Orc");

    private String race;

    Races(String race) {
        this.race = race;
    }

    public String getRace() {
        return race;
    }
}
