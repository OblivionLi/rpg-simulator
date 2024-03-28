package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.races.PlayerHero;
import org.balaur.rpgcharactercreation.model.races.factory.PlayerFactory;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.AttributesConsts;
import org.balaur.rpgcharactercreation.util.DamageType;
import org.balaur.rpgcharactercreation.util.Races;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private PlayerHero playerHero;

    @BeforeEach
    public void setUp() {
        PlayerHero.Builder builder = new PlayerHero.Builder();

        builder.withName("Blaster")
                .withAlignmentType(AlignmentType.GOOD)
                .withCanAttackGroundUnits(true)
                .withCanAttackAirUnits(true)
                .withRace(Races.HUMAN)
                .withDamageType(DamageType.SLASHING);

        PlayerFactory pf = new PlayerFactory();

        playerHero = pf.createPlayerHero(Races.HUMAN.getRace(), builder);
    }

    @Test
    void InitializeHumanHero_Success() {
        assertNotNull(playerHero);

        if (playerHero.displayCharacterInfo().contains("Name: Blaster")) {
            assertTrue(true);
            System.out.println(playerHero.displayCharacterInfo());
        } else {
            fail();
        }
    }

    @Test
    void LevelUpHero_Success() {
        assertNotNull(playerHero);

        // before levelUp
        int currentHealth = playerHero.getSubAttributes().getHealth();
        int currentMana = playerHero.getSubAttributes().getMana();
        assertEquals(currentHealth, playerHero.getSubAttributes().getHealth());
        assertEquals(currentMana, playerHero.getSubAttributes().getMana());

        playerHero.gainExperience(100); // should increase level from 1 to 4

        assertEquals(4, playerHero.getLevelingSystem().getLevel());

        int newLevel = playerHero.getLevelingSystem().getLevel() - 1; // - 1 because we are starting from 1 not 0

        // health increases every level by AttributesConsts.INCREMENT_HEALTH_ON_LEVEL_UP
        int newHealth = currentHealth + (newLevel * AttributesConsts.INCREMENT_HEALTH_ON_LEVEL_UP);
        assertEquals(newHealth, playerHero.getSubAttributes().getHealth());

        // mana increases every level by AttributesConsts.INCREMENT_MANA_ON_LEVEL_UP
        int newMana = currentMana + (newLevel * AttributesConsts.INCREMENT_MANA_ON_LEVEL_UP);
        assertEquals(newMana, playerHero.getSubAttributes().getMana());

        System.out.println(playerHero.displayCharacterInfo());
    }


    @Test
    void LevelUpHero_Fail() {
        assertNotNull(playerHero);

        // before gaining negative exp
        assertEquals(1, playerHero.getLevelingSystem().getLevel());

        playerHero.gainExperience(-100); // this should return void

        // the expected behaviour shouldn't return anything or throw any exception; just don't change anything
        assertEquals(1, playerHero.getLevelingSystem().getLevel());
    }

    @Test
    void IncreaseHeroStrength_Success() {
        assertNotNull(playerHero);

        int currentCombat = playerHero.getSubAttributes().getCombat();
        int currentHealth = playerHero.getSubAttributes().getHealth();
        int currentLifeReg = playerHero.getSubAttributes().getLifeRegeneration();
        float currentLifeRegTimer = playerHero.getSubAttributes().getLifeRegenerationTimer();

        int pointsOfStrengthToIncrease = 2;
        playerHero.getMainAttributes().increaseStrength(pointsOfStrengthToIncrease); // increased strength by 2 points

        int newStrength = playerHero.getMainAttributes().getStrength();
        assertEquals(newStrength, playerHero.getMainAttributes().getStrength());

        int newCombat = currentCombat + newStrength / AttributesConsts.COMBAT_DIVISOR;
        assertEquals(newCombat, playerHero.getSubAttributes().getCombat());

        int newHealth = currentHealth + newStrength * AttributesConsts.HEALTH_MULTIPLIER;
        assertEquals(newHealth, playerHero.getSubAttributes().getHealth());

        int newLifeReg = currentLifeReg + newStrength / AttributesConsts.LIFE_REGEN_DIVISOR;
        assertEquals(newLifeReg, playerHero.getSubAttributes().getLifeRegeneration());

        float newLifeRegTimer = currentLifeRegTimer - (float) newStrength / AttributesConsts.LIFE_REGEN_TIMER_DIVISOR * AttributesConsts.LIFE_REGEN_TIMER_REDUCTION;
        assertEquals(newLifeRegTimer, playerHero.getSubAttributes().getLifeRegenerationTimer());

        System.out.println(playerHero.displayCharacterInfo());
    }

    @Test
    void IncreaseHeroIntelligence_Success() {
        assertNotNull(playerHero);

        int currentMana = playerHero.getSubAttributes().getMana();
        int currentManaReg = playerHero.getSubAttributes().getManaRegeneration();
        float currentManaRegTimer = playerHero.getSubAttributes().getManaRegenerationTimer();
        int currentTroopXP = playerHero.getSubAttributes().getTroopXP();
        double currentSpellCastingChance = playerHero.getSubAttributes().getSpellcastingChance();

        int pointsOfIntelligenceToIncrease = 2;
        playerHero.getMainAttributes().increaseIntelligence(pointsOfIntelligenceToIncrease, 0); // increased intelligence by 2 points

        int newIntelligence = playerHero.getMainAttributes().getIntelligence();
        assertEquals(newIntelligence, playerHero.getMainAttributes().getIntelligence());

        double newSpellCastingChance = currentSpellCastingChance + newIntelligence * (AttributesConsts.SPELL_CASTING_PERCENTAGE_INCREASE / 100.f);
        assertEquals(newSpellCastingChance, playerHero.getSubAttributes().getSpellcastingChance());

        int newTroopXP = currentTroopXP + (newIntelligence / AttributesConsts.TROOP_XP_DIVISOR);
        assertEquals(newTroopXP, playerHero.getSubAttributes().getTroopXP());

        int newManaReg = currentManaReg + newIntelligence / AttributesConsts.MANA_REGEN_DIVISOR;
        assertEquals(newManaReg, playerHero.getSubAttributes().getManaRegeneration());

        int newMana = currentMana + newIntelligence * AttributesConsts.MANA_MULTIPLIER;
        assertEquals(newMana, playerHero.getSubAttributes().getMana());

        float newManaRegTimer = currentManaRegTimer - (float) newIntelligence / AttributesConsts.MANA_REGEN_TIMER_DIVISOR * AttributesConsts.MANA_REGEN_TIMER_REDUCTION;
        assertEquals(newManaRegTimer, playerHero.getSubAttributes().getManaRegenerationTimer());

        System.out.println(playerHero.displayCharacterInfo());
    }

    @Test
    void IncreaseHeroCharisma_Success() {
        assertNotNull(playerHero);

        int currentCommandRadius = playerHero.getSubAttributes().getCommand();
        int currentMorale = playerHero.getSubAttributes().getMorale();
        double currentDiscount = playerHero.getSubAttributes().getDiscount();
        int currentRetinueSlots = playerHero.getSubAttributes().getRetinueSlots();

        int pointsOfCharismaToIncrease = 2;
        playerHero.getMainAttributes().increaseCharisma(pointsOfCharismaToIncrease); // increased charisma by 2 points

        int newCharisma = playerHero.getMainAttributes().getCharisma();
        assertEquals(newCharisma, playerHero.getMainAttributes().getCharisma());

        int newRetinueSlots = currentRetinueSlots + newCharisma / AttributesConsts.RETINUE_SLOT_DIVISOR;
        assertEquals(newRetinueSlots, playerHero.getSubAttributes().getRetinueSlots());

        double newDiscount = newCharisma < 6 ? 0.0 : currentDiscount + newCharisma * (AttributesConsts.DISCOUNT_PERCENTAGE_INCREASE / 100.f);
        assertEquals(newDiscount, playerHero.getSubAttributes().getDiscount());

        int newMorale = currentMorale + newCharisma / AttributesConsts.MORALE_DIVISOR;
        assertEquals(newMorale, playerHero.getSubAttributes().getMorale());

        int newCommandRadius = currentCommandRadius + newCharisma / AttributesConsts.COMMAND_RADIUS_DIVISOR;
        assertEquals(newCommandRadius, playerHero.getSubAttributes().getCommand());

        System.out.println(playerHero.displayCharacterInfo());
    }
}
