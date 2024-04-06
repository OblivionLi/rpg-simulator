package org.balaur.rpgcharactercreation.model.inventory.boots;

import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

public class BootsOfSwiftness extends BaseItemSlot implements BaseItem {
    public BootsOfSwiftness() {
        super(
                ItemQuality.MINOR,
                "Boots of Swiftness",
                "Light boots that slightly increase speed.",
                "boots"
        );

        addProperty("SPEED", 1);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
