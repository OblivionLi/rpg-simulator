package org.balaur.rpgcharactercreation.model.inventory.boots;

import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

public class TitanSabatons extends BaseItemSlot implements BaseItem {
    public TitanSabatons() {
        super(
                ItemQuality.MAJOR,
                "Titan's Sabatons",
                "Heavy boots that boost health, armor and speed.",
                "boots"
        );

        addProperty("SPEED", 2);
        addProperty("ARMOR", 2);
        addProperty("HEALTH", 70);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
