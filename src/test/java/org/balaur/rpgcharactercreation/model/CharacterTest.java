package org.balaur.rpgcharactercreation.model;

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

        if (humanCharacter.displayCharacterInfo(humanCharacter.getRace()).contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
        } else {
            fail();
        }
    }

    @Test
    void LevelUpHero_Success() {
        CharacterFactory humanFactory = new HumanFactory();
        RPGCharacter humanCharacter = humanFactory.createCharacter("Blaster");

        assertNotNull(humanCharacter);

        if (humanCharacter.displayCharacterInfo(humanCharacter.getRace()).contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
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

        System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
    }

    @Test
    void LevelUpHero_Fail() {
        CharacterFactory humanFactory = new HumanFactory();
        RPGCharacter humanCharacter = humanFactory.createCharacter("Blaster");

        assertNotNull(humanCharacter);

        if (humanCharacter.displayCharacterInfo(humanCharacter.getRace()).contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
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

        if (humanCharacter.displayCharacterInfo(humanCharacter.getRace()).contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
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

        float newLifeRegTimer = currentLifeRegTimer - (float) newStrength / AttributesConsts.LIFE_REGEN_TIMER_DIVISOR * AttributesConsts.LIFE_REGEN_TIMER_REDUCTION;
        assertEquals(newLifeRegTimer, humanCharacter.getSubAttributes().getLifeRegenerationTimer());

        System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
    }

    @Test
    void IncreaseHeroIntelligence_Success() {
        CharacterFactory humanFactory = new HumanFactory();
        RPGCharacter humanCharacter = humanFactory.createCharacter("Blaster");

        assertNotNull(humanCharacter);

        if (humanCharacter.displayCharacterInfo(humanCharacter.getRace()).contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
        } else {
            fail();
        }

        int currentMana = humanCharacter.getSubAttributes().getMana();
        int currentManaReg = humanCharacter.getSubAttributes().getManaRegeneration();
        float currentManaRegTimer = humanCharacter.getSubAttributes().getManaRegenerationTimer();
        int currentTroopXP = humanCharacter.getSubAttributes().getTroopXP();
        double currentSpellCastingChance = humanCharacter.getSubAttributes().getSpellcastingChance();

        int pointsOfIntelligenceToIncrease = 2;
        humanCharacter.getMainAttributes().increaseIntelligence(pointsOfIntelligenceToIncrease, 0); // increased intelligence by 2 points

        int newIntelligence = humanCharacter.getMainAttributes().getIntelligence();
        assertEquals(newIntelligence, humanCharacter.getMainAttributes().getIntelligence());

        double newSpellCastingChance = currentSpellCastingChance + newIntelligence * (AttributesConsts.SPELL_CASTING_PERCENTAGE_INCREASE / 100.f);
        assertEquals(newSpellCastingChance, humanCharacter.getSubAttributes().getSpellcastingChance());

        int newTroopXP = currentTroopXP + (newIntelligence / AttributesConsts.TROOP_XP_DIVISOR);
        assertEquals(newTroopXP, humanCharacter.getSubAttributes().getTroopXP());

        int newManaReg = currentManaReg + newIntelligence / AttributesConsts.MANA_REGEN_DIVISOR;
        assertEquals(newManaReg, humanCharacter.getSubAttributes().getManaRegeneration());

        int newMana = currentMana + newIntelligence * AttributesConsts.MANA_MULTIPLIER;
        assertEquals(newMana, humanCharacter.getSubAttributes().getMana());

        float newManaRegTimer = currentManaRegTimer - (float) newIntelligence / AttributesConsts.MANA_REGEN_TIMER_DIVISOR * AttributesConsts.MANA_REGEN_TIMER_REDUCTION;
        assertEquals(newManaRegTimer, humanCharacter.getSubAttributes().getManaRegenerationTimer());

        System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
    }

    @Test
    void IncreaseHeroCharisma_Success() {
        CharacterFactory humanFactory = new HumanFactory();
        RPGCharacter humanCharacter = humanFactory.createCharacter("Blaster");

        assertNotNull(humanCharacter);

        if (humanCharacter.displayCharacterInfo(humanCharacter.getRace()).contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
        } else {
            fail();
        }

        int currentCommandRadius = humanCharacter.getSubAttributes().getCommand();
        int currentMorale = humanCharacter.getSubAttributes().getMorale();
        double currentDiscount = humanCharacter.getSubAttributes().getDiscount();
        int currentRetinueSlots = humanCharacter.getSubAttributes().getRetinueSlots();

        int pointsOfCharismaToIncrease = 2;
        humanCharacter.getMainAttributes().increaseCharisma(pointsOfCharismaToIncrease); // increased charisma by 2 points

        int newCharisma = humanCharacter.getMainAttributes().getCharisma();
        assertEquals(newCharisma, humanCharacter.getMainAttributes().getCharisma());

        int newRetinueSlots = currentRetinueSlots + newCharisma / AttributesConsts.RETINUE_SLOT_DIVISOR;
        assertEquals(newRetinueSlots, humanCharacter.getSubAttributes().getRetinueSlots());

        double newDiscount = newCharisma < 6 ? 0.0 : currentDiscount + newCharisma * (AttributesConsts.DISCOUNT_PERCENTAGE_INCREASE / 100.f);
        assertEquals(newDiscount, humanCharacter.getSubAttributes().getDiscount());

        int newMorale = currentMorale + newCharisma / AttributesConsts.MORALE_DIVISOR;
        assertEquals(newMorale, humanCharacter.getSubAttributes().getMorale());

        int newCommandRadius = currentCommandRadius + newCharisma / AttributesConsts.COMMAND_RADIUS_DIVISOR;
        assertEquals(newCommandRadius, humanCharacter.getSubAttributes().getCommand());

        System.out.println(humanCharacter.displayCharacterInfo(humanCharacter.getRace()));
    }
}
