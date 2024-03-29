package org.balaur.rpgcharactercreation.util;

public enum TeamColors {
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    YELLOW("Yellow"),
    PURPLE("Purple"),
    ORANGE("Orange"),
    WHITE("White"),
    Blue("Black");

    private String color;

    TeamColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
