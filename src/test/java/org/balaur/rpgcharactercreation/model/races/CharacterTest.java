package org.balaur.rpgcharactercreation.model.races;

import org.balaur.rpgcharactercreation.model.CharacterFactory;
import org.balaur.rpgcharactercreation.model.RPGCharacter;
import org.balaur.rpgcharactercreation.model.races.human.HumanFactory;
import org.balaur.rpgcharactercreation.util.AttributesConsts;
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
            System.out.println(humanCharacter.displayCharacterInfo());
        } else {
            fail();
        }
    }

    @Test
    void LevelUpHero_Success() {
        CharacterFactory humanFactory = new HumanFactory();
        RPGCharacter humanCharacter = humanFactory.createCharacter("Blaster");

        assertNotNull(humanCharacter);

        if (humanCharacter.displayCharacterInfo().contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(humanCharacter.displayCharacterInfo());
        } else {
            fail();
        }

        // before levelUp
        int currentHealth = humanCharacter.getSubAttributes().getHealth();
        int currentMana = humanCharacter.getSubAttributes().getMana();
        assertEquals(currentHealth, humanCharacter.getSubAttributes().getHealth());
        assertEquals(currentMana, humanCharacter.getSubAttributes().getMana());

        humanCharacter.gainExperience(100); // should increase level from 1 to 4

        assertEquals(4, humanCharacter.getLevelingSystem().getLevel());

        int newLevel = humanCharacter.getLevelingSystem().getLevel() - 1; // - 1 because we are starting from 1 not 0

        // health increases every level by AttributesConsts.INCREMENT_HEALTH_ON_LEVEL_UP
        int newHealth = currentHealth + (newLevel * AttributesConsts.INCREMENT_HEALTH_ON_LEVEL_UP);
        assertEquals(newHealth, humanCharacter.getSubAttributes().getHealth());

        // mana increases every level by AttributesConsts.INCREMENT_MANA_ON_LEVEL_UP
        int newMana = currentMana + (newLevel * AttributesConsts.INCREMENT_MANA_ON_LEVEL_UP);
        assertEquals(newMana, humanCharacter.getSubAttributes().getMana());

        System.out.println(humanCharacter.displayCharacterInfo());
    }

    @Test
    void LevelUpHero_Fail() {
        CharacterFactory humanFactory = new HumanFactory();
        RPGCharacter humanCharacter = humanFactory.createCharacter("Blaster");

        assertNotNull(humanCharacter);

        if (humanCharacter.displayCharacterInfo().contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(humanCharacter.displayCharacterInfo());
        } else {
            fail();
        }

        // before gaining negative exp
        assertEquals(1, humanCharacter.getLevelingSystem().getLevel());

        humanCharacter.gainExperience(-100); // this should return void

        // the expected behaviour shouldn't return anything or throw any exception; just don't change anything
        assertEquals(1, humanCharacter.getLevelingSystem().getLevel());
    }

    @Test
    void IncreaseHeroStrength_Success() {
        CharacterFactory humanFactory = new HumanFactory();
        RPGCharacter humanCharacter = humanFactory.createCharacter("Blaster");

        assertNotNull(humanCharacter);

        if (humanCharacter.displayCharacterInfo().contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(humanCharacter.displayCharacterInfo());
        } else {
            fail();
        }

        int currentCombat = humanCharacter.getSubAttributes().getCombat();
        int currentHealth = humanCharacter.getSubAttributes().getHealth();
        int currentLifeReg = humanCharacter.getSubAttributes().getLifeRegeneration();
        float currentLifeRegTimer = humanCharacter.getSubAttributes().getLifeRegenerationTimer();

        int pointsOfStrengthToIncrease = 2;
        humanCharacter.getMainAttributes().increaseStrength(pointsOfStrengthToIncrease); // increased strength by 2 points

        int newStrength = humanCharacter.getMainAttributes().getStrength();
        assertEquals(newStrength, humanCharacter.getMainAttributes().getStrength());

        int newCombat = currentCombat + newStrength / AttributesConsts.COMBAT_DIVISOR;
        assertEquals(newCombat, humanCharacter.getSubAttributes().getCombat());

        int newHealth = currentHealth + newStrength * AttributesConsts.HEALTH_MULTIPLIER;
        assertEquals(newHealth, humanCharacter.getSubAttributes().getHealth());

        int newLifeReg = currentLifeReg + newStrength / AttributesConsts.LIFE_REGEN_DIVISOR;
        assertEquals(newLifeReg, humanCharacter.getSubAttributes().getLifeRegeneration());

        System.out.printf("========= CHECK LIFE REG TIMER: %f, new str: %d", currentLifeRegTimer, newStrength);
        float newLifeRegTimer = currentLifeRegTimer - (float) newStrength / AttributesConsts.LIFE_REGEN_TIMER_DIVISOR * AttributesConsts.LIFE_REGEN_TIMER_REDUCTION;
        System.out.printf("========= CHECK NEW LIFE REG TIMER: %f", newLifeRegTimer);
        assertEquals(newLifeRegTimer, humanCharacter.getSubAttributes().getLifeRegenerationTimer());

        System.out.println(humanCharacter.displayCharacterInfo());
    }
}
