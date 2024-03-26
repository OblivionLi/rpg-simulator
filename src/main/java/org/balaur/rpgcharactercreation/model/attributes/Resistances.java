package org.balaur.rpgcharactercreation.model.attributes;

import lombok.Getter;

@Getter
public class Resistances {
    // resistances affected by the resistance sub attribute
    private int resistanceToFire;
    private int resistanceToElectric;
    private int resistanceToCold;
    private int resistanceToMagic;

    // resistances affected by the armor sub attribute
    private int resistanceToSlashing;
    private int resistanceToCrushing;
    private int resistanceToPiercing;

    public Resistances() {
    }

    public void calculateResistances(int initialResistance, int initialArmor) {
        // is calculated this way so that the difference between resistances is by most 1
        // if the armor is 5 then the resistances points should become 2, 2, 1
        // if the armor becomes 6 then the resistances update to 2, 2, 2
        // for armor 7 -> 3, 2, 2 and so on
        // !!!! an incorrect way to assign resistances points is if armor is 5 for example and the distribution is 3, 1, 1 <- this is incorrect
        calculateElementalResistance(initialResistance);
        calculateArmorResistance(initialArmor);
    }

    private void calculateArmorResistance(int initialArmor) {
        int baseResistance = initialArmor / 3;

        int remainder = initialArmor % 3;

        resistanceToSlashing = baseResistance + (remainder > 0 ? 1 : 0);
        resistanceToCrushing = baseResistance + (remainder > 1 ? 1 : 0);
        resistanceToPiercing = baseResistance;
    }

    private void calculateElementalResistance(int initialResistance) {
        int baseResistance = initialResistance / 4;

        int remainder = initialResistance % 4;

        resistanceToFire = baseResistance + (remainder > 0 ? 1 : 0);
        resistanceToElectric = baseResistance + (remainder > 1 ? 1 : 0);
        resistanceToCold = baseResistance + (remainder > 2 ? 1 : 0);
        resistanceToMagic = baseResistance;
    }
}
