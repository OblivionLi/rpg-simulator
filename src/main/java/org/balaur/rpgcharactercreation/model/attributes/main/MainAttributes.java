package org.balaur.rpgcharactercreation.model.attributes.main;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.attributes.sub.SubAttributes;
import org.balaur.rpgcharactercreation.model.attributes.sub.SubAttributesType;
import org.balaur.rpgcharactercreation.model.races.troops.TroopType;

@Getter
public class MainAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int charisma;

    private SubAttributesType subAttributes;

    public MainAttributes(int strength, int dexterity, int intelligence, int charisma, TroopType troopType) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;

        this.subAttributes = new SubAttributes(troopType);

        subAttributes.updateStrengthRelatedAttributes(this.strength);
        subAttributes.updateDexterityRelatedAttributes(this.dexterity);
        subAttributes.updateIntelligenceRelatedAttributes(this.intelligence);
        subAttributes.updateCharismaRelatedAttributes(this.charisma);
        subAttributes.updateResistances();
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

        subAttributes.updateIntelligenceRelatedAttributes(this.intelligence);
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
