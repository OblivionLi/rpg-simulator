package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.races.NPCTroop;
import org.balaur.rpgcharactercreation.model.races.factory.NPCTroopFactory;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;
import org.balaur.rpgcharactercreation.util.Races;
import org.balaur.rpgcharactercreation.util.TeamColors;
import org.balaur.rpgcharactercreation.util.races.human.HumanRaceTypeNPCs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NPCTest {
    private NPCTroop npcTroop;

    @BeforeEach
    public void setUp() {
        NPCTroop.Builder builder = new NPCTroop.Builder();

        builder.withAlignmentType(AlignmentType.GOOD)
                .withNPCRaceType(HumanRaceTypeNPCs.PIKEMAN)
                .withName("Pikeman") // is a recruit, it doesn't have a name yet
                .withDamageType(DamageType.PIERCING)
                .withTroopXP(0)
                .withRace(Races.HUMAN)
                .withCanAttackAirUnits(false)
                .withCanAttackGroundUnits(true)
                .withStrength(3)
                .withDexterity(3)
                .withIntelligence(2)
                .withCharisma(1)
                .withTeamColor(TeamColors.RED)
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
}
