package org.balaur.rpgcharactercreation.model.inventory.ring;

import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

public class RingOfStrength extends BaseItemSlot implements BaseItem {
    public RingOfStrength() {
        super(
                ItemQuality.MINOR,
                "Ring of Strength",
                "A simple ring that provides a small increase to combat.",
                "ring"
        );

        addProperty("COMBAT", 3);

        super.slotHeight = 1;
        super.slotWidth = 1;
    }
}
