package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.attributes.resistances.Resistances;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResistanceTest {

    @Test
    public void InitializeCharacterResistances_Success() {
        Resistances resistances = new Resistances();

        resistances.calculateResistances(5, 4);

        // (4) armor affected resistances
        assertEquals(2, resistances.getResistanceToSlashing());
        assertEquals(1, resistances.getResistanceToCrushing());
        assertEquals(1, resistances.getResistanceToPiercing());

        // (5) resistance affected elemental resistances
        assertEquals(2, resistances.getResistanceToFire());
        assertEquals(1, resistances.getResistanceToElectric());
        assertEquals(1, resistances.getResistanceToCold());
        assertEquals(1, resistances.getResistanceToMagic());


        resistances.calculateResistances(9, 12);

        // (12) armor affected resistances
        assertEquals(4, resistances.getResistanceToSlashing());
        assertEquals(4, resistances.getResistanceToCrushing());
        assertEquals(4, resistances.getResistanceToPiercing());

        // (9) resistance affected elemental resistances
        assertEquals(3, resistances.getResistanceToFire());
        assertEquals(2, resistances.getResistanceToElectric());
        assertEquals(2, resistances.getResistanceToCold());
        assertEquals(2, resistances.getResistanceToMagic());
    }
}
