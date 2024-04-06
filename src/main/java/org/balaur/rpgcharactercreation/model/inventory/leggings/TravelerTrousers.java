package org.balaur.rpgcharactercreation.model.inventory.leggings;

import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

public class TravelerTrousers extends BaseItemSlot implements BaseItem {
    public TravelerTrousers() {
        super(
                ItemQuality.MINOR,
                "Traveler's Trousers",
                "Comfortable trousers that slightly increase speed.",
                "leggings"
        );

        addProperty("SPEED", 1);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
