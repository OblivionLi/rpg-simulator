package org.balaur.rpgcharactercreation.model.inventory.ring;

import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

public class CelestialBand extends BaseItemSlot implements BaseItem {
    public CelestialBand() {
        super(
                ItemQuality.LEGENDARY,
                "Celestial Band",
                "A ring said to contain a piece of Celestia, greatly enhancing all main stats and provides a special bonus of increased spellCastingChance.",
                "ring"
        );

        addProperty("COMBAT", 15);
        addProperty("SPEED", 7);
        addProperty("HEALTH", 200);
        addProperty("SPELL_CASTING_CHANCE", 5);

        super.slotHeight = 1;
        super.slotWidth = 1;
    }
}
