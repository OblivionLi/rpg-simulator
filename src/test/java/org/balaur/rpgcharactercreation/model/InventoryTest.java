package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.inventory.body.CelestialRobes;
import org.balaur.rpgcharactercreation.model.races.PlayerHero;
import org.balaur.rpgcharactercreation.model.races.factory.PlayerFactory;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;
import org.balaur.rpgcharactercreation.util.Races;
import org.balaur.rpgcharactercreation.util.TeamColors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private PlayerHero playerHero;

    @BeforeEach
    public void setUp() {
        PlayerHero.Builder builder = new PlayerHero.Builder();

        CharacterActions actions = new CharacterActions(
                true,
                true,
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

        builder.withName("Blaster")
                .withAlignmentType(AlignmentType.GOOD)
                .withRace(Races.HUMAN)
                .withDamageType(DamageType.SLASHING)
                .withColor(TeamColors.BLUE)
                .withCharacterEffects(effects)
                .withCharacterActions(actions);

        PlayerFactory pf = new PlayerFactory();

        playerHero = pf.createPlayerHero(Races.HUMAN.getRace(), builder);
    }

    @Test
    public void AddItemToHeroInventory_Success() {
        int heroHealth = playerHero.getAttributes().getSubAttributes().getHealth();
        assertEquals(135, heroHealth); // initial health

        CelestialRobes celestialRobes = new CelestialRobes(); // this item has a bonus health value of 80
        playerHero.equipItem(celestialRobes);

        heroHealth = playerHero.getAttributes().getSubAttributes().getHealth();
        assertEquals(215, heroHealth); // new health after equipping the item

        playerHero.unequipItem(celestialRobes);

        heroHealth = playerHero.getAttributes().getSubAttributes().getHealth();
        assertEquals(135, heroHealth); // health after un-equipping the item (goes back to the original value)
    }
}
