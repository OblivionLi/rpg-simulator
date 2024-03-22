package org.balaur.rpgcharactercreation.model.attributes;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MainAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int charisma;

    private SubAttributes subAttributes;

    public MainAttributes(int strength, int dexterity, int intelligence, int charisma, int troopXP) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;

        subAttributes = new SubAttributes();

        subAttributes.updateStrengthRelatedAttributes(this.strength);
        subAttributes.updateDexterityRelatedAttributes(this.dexterity);
        subAttributes.updateIntelligenceRelatedAttributes(this.intelligence, troopXP);
        subAttributes.updateCharismaRelatedAttributes(this.charisma);
    }

    public void increaseStrength(int strength) {
        this.strength += strength;

        subAttributes.updateStrengthRelatedAttributes(this.strength);
    }

    public void increaseDexterity(int dexterity) {
        this.dexterity += dexterity;

        subAttributes.updateDexterityRelatedAttributes(this.dexterity);
    }

    public void increaseIntelligence(int intelligence, int troopXP) {
        this.intelligence += intelligence;

        subAttributes.updateIntelligenceRelatedAttributes(this.intelligence, troopXP);
    }

    public void increaseCharisma(int charisma) {
        this.charisma += charisma;

        subAttributes.updateCharismaRelatedAttributes(this.charisma);
    }

    public String displayAttributes() {
        return "Strength: " + strength + "\n" +
                "Dexterity: " + dexterity + "\n" +
                "Intelligence: " + intelligence + "\n" +
                "Charisma: " + charisma + "\n" +
                "------------------------------------" + "\n" +
                subAttributes.displaySubAttributes();
    }
}
