package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.races.PlayerHero;
import org.balaur.rpgcharactercreation.model.races.factory.NPCTroopFactory;
import org.balaur.rpgcharactercreation.model.races.factory.PlayerFactory;
import org.balaur.rpgcharactercreation.model.races.troops.NPCTroop;
import org.balaur.rpgcharactercreation.model.races.troops.TroopType;
import org.balaur.rpgcharactercreation.model.races.troops.human.Pikeman;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;
import org.balaur.rpgcharactercreation.util.Races;
import org.balaur.rpgcharactercreation.util.TeamColors;
import org.balaur.rpgcharactercreation.util.races.human.HumanRaceTypeNPCs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

public class CombatTest {
    private PlayerHero playerHero;
    private NPCTroop npcTroop;

    @BeforeEach
    public void setUp() {
        buildTroop();
        buildHero();
    }

    @Test
    public void AttackCombatSystem_Success() {
        int heroHealth = playerHero.getAttributes().getSubAttributes().getHealth();
        int troopHealth = npcTroop.getAttributes().getSubAttributes().getHealth();

        System.out.println("Hero started with Health: " + heroHealth);
        System.out.println("Troop started with Health: " + troopHealth);
        System.out.println("------------------------\n");

        while (heroHealth > 0 && troopHealth > 0) {
            // ignore speed attribute for now
            playerHero.startAttacking(npcTroop);
            System.out.println(playerHero.getName() + " dealt damage to " + npcTroop.getName() + ". Has " + playerHero.getSubAttributes().getCombat() + " combat.");
            troopHealth = npcTroop.getAttributes().getSubAttributes().getHealth();

            System.out.println(npcTroop.getName() + " health remaining: " + troopHealth + "\n");

            if (troopHealth <= 0) {
                System.out.println(npcTroop.getName() + " was defeated. Hero: " + playerHero.getName() + " wins the battle with " + playerHero.getAttributes().getSubAttributes().getHealth() + " health remaining.");
                break;
            }

            npcTroop.startAttacking(playerHero);
            System.out.println(npcTroop.getName() + " dealt damage. Has " + npcTroop.getSubAttributes().getCombat() + " combat.");
            heroHealth = playerHero.getAttributes().getSubAttributes().getHealth();

            System.out.println(playerHero.getName() + " health remaining: " + heroHealth + "\n");

            if (heroHealth <= 0) {
                System.out.println(playerHero.getName() + " was defeated. NPC: " + npcTroop.getName() + " wins the battle with " + npcTroop.getAttributes().getSubAttributes().getHealth() + " health remaining.");
                break;
            }
        }

        // this method doesnt really test anything, it manually/visually test if the combat its ok
        assertTrue(true);
    }

    @Test
    public void AttackCombatSystemConcurrent_Success() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        // Start the battle in a separate thread
        new Thread(() -> {
            while (playerHero.getAttributes().getSubAttributes().getHealth() > 0 && npcTroop.getAttributes().getSubAttributes().getHealth() > 0) {
                playerHero.startAttacking(npcTroop);
                npcTroop.startAttacking(playerHero);

                // Add a delay to simulate the time it takes for an attack to complete
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Battle is over, count down the latch
            latch.countDown();
        }).start();

        // Wait for the latch to count down
        latch.await();

        if (playerHero.getAttributes().getSubAttributes().getHealth() <= 0) {
            System.out.println(playerHero.getName() + " was defeated. NPC: " + npcTroop.getName() + " wins the battle with " + npcTroop.getAttributes().getSubAttributes().getHealth() + " health remaining.");
        } else {
            System.out.println(npcTroop.getName() + " was defeated. Hero: " + playerHero.getName() + " wins the battle with " + playerHero.getAttributes().getSubAttributes().getHealth() + " health remaining.");
        }

        assertTrue(true);
    }

    private void buildHero() {
        PlayerHero.Builder builder = new PlayerHero.Builder();

        builder.withName("Blaster")
                .withAlignmentType(AlignmentType.GOOD)
                .withRace(Races.HUMAN)
                .withDamageType(DamageType.SLASHING)
                .withColor(TeamColors.BLUE);

        PlayerFactory pf = new PlayerFactory();

        playerHero = pf.createPlayerHero(Races.HUMAN.getRace(), builder);
    }

    private void buildTroop() {
        NPCTroop.Builder builder = new NPCTroop.Builder();

        TroopType pikemanType = new Pikeman();

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
                .withNPCTroopType(pikemanType)
                .build();

        NPCTroopFactory npcTroopFactory = new NPCTroopFactory();
        npcTroop = npcTroopFactory.createNPCTroop(builder);
    }
}
