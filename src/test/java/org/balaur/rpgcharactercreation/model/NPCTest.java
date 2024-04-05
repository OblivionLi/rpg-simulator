package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.races.troops.NPCTroop;
import org.balaur.rpgcharactercreation.model.races.factory.NPCTroopFactory;
import org.balaur.rpgcharactercreation.model.races.troops.TroopType;
import org.balaur.rpgcharactercreation.model.races.troops.human.Pikeman;
import org.balaur.rpgcharactercreation.util.*;
import org.balaur.rpgcharactercreation.util.races.human.HumanRaceTypeNPCs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NPCTest {
    private NPCTroop npcTroop;

    @BeforeEach
    public void setUp() {
        NPCTroop.Builder builder = new NPCTroop.Builder();

        CharacterActions actions = new CharacterActions(
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false
        );

        CharacterEffects effects = new CharacterEffects(
                false,
                false,
                false,
                false,
                false
        );

        TroopType pikemanType = new Pikeman();

        builder.withAlignmentType(AlignmentType.GOOD)
                .withNPCRaceType(HumanRaceTypeNPCs.PIKEMAN)
                .withName("Pikeman") // is a recruit, it doesn't have a name yet
                .withDamageType(DamageType.PIERCING)
                .withTroopXP(0)
                .withRace(Races.HUMAN)
                .withStrength(3)
                .withDexterity(3)
                .withIntelligence(2)
                .withCharisma(1)
                .withTeamColor(TeamColors.RED)
                .withNPCTroopType(pikemanType)
                .withCharacterActions(actions)
                .withCharacterEffects(effects)
            .build();

        NPCTroopFactory npcTroopFactory = new NPCTroopFactory();
        npcTroop = npcTroopFactory.createNPCTroop(builder);
    }

    @Test
    void InitializeNPC_Success() {
        assertNotNull(npcTroop);

        if (npcTroop.displayCharacterInfo(Races.HUMAN.getRace()).contains("Name: Pikeman")) {
            assertTrue(true);
            System.out.println(npcTroop.displayCharacterInfo(Races.HUMAN.getRace()));
        } else {
            fail();
        }
    }

    @Test
    void LevelUpPikemanNPC_Success() {
        assertNotNull(npcTroop);

        //  before levelUp
        int currentHealth = npcTroop.getSubAttributes().getHealth();
        int currentCombat = npcTroop.getSubAttributes().getCombat();
        int currentLifeReg = npcTroop.getSubAttributes().getLifeRegeneration();
        float currentLifeRegTimer = npcTroop.getSubAttributes().getLifeRegenerationTimer();
        assertEquals(currentHealth, npcTroop.getSubAttributes().getHealth());

        System.out.println(npcTroop.displayCharacterInfo(Races.HUMAN.getRace()));

        npcTroop.gainExperience(30); // should increase level from 1 to 4

        assertEquals(NPCRanks.RECRUIT, npcTroop.getRank());

        // kinda of useless asserts; while the troop gained exp, 30 is not enough to level up stats; check NPCRanks for this
        assertEquals(10, currentCombat);
        assertEquals(2, currentLifeReg);
        assertEquals(29, (int) currentLifeRegTimer);

        System.out.println(npcTroop.displayCharacterInfo(Races.HUMAN.getRace()));

        npcTroop.gainExperience(11);

        assertEquals(NPCRanks.ROOKIE, npcTroop.getRank());

        System.out.println(npcTroop.displayCharacterInfo(Races.HUMAN.getRace()));
    }
}
