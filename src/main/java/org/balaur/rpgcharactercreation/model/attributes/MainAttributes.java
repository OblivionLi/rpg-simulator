package org.balaur.rpgcharactercreation.model.attributes;

import lombok.Getter;

@Getter
public class MainAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int charisma;

    public MainAttributes(int strength, int dexterity, int intelligence, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
