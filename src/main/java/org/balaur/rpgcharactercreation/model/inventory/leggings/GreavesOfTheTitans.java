package org.balaur.rpgcharactercreation.model.inventory.leggings;

import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

public class GreavesOfTheTitans extends BaseItemSlot implements BaseItem {
    public GreavesOfTheTitans() {
        super(
                ItemQuality.AVERAGE,
                "Greaves of the Titans",
                "Heavy greaves that increase health and armor.",
                "leggings"
        );

        addProperty("ARMOR", 3);
        addProperty("HEALTH", 50);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
