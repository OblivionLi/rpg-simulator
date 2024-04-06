package org.balaur.rpgcharactercreation.model.inventory.boots;

import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

public class CelestialSandals extends BaseItemSlot implements BaseItem {
    public CelestialSandals() {
        super(
                ItemQuality.ARTIFACT,
                "Celestial Sandals",
                "Sandals said to have been worn by the celestial beings, providing a major boost to speed, command, morale and magery.",
                "boots"
        );

        addProperty("SPEED", 6);
        addProperty("COMMAND", 6);
        addProperty("MORALE", 6);
        addProperty("MAGERY", 6);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
