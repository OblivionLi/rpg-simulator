package org.balaur.rpgcharactercreation.model.races;

import org.balaur.rpgcharactercreation.model.CharacterFactory;
import org.balaur.rpgcharactercreation.model.RPGCharacter;
import org.balaur.rpgcharactercreation.model.races.human.HumanFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void InitializeHumanHero_Success() {
        CharacterFactory humanFactory = new HumanFactory();
        RPGCharacter humanCharacter = humanFactory.createCharacter("Blaster");

        assertNotNull(humanCharacter);

        if (humanCharacter.displayCharacterInfo().contains("Name: Blaster")) {
            assertTrue(true);
        } else {
            fail();
        }
    }
}
