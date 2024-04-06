package org.balaur.rpgcharactercreation.model.inventory.ring;

import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

public class RingOfTheTitans extends BaseItemSlot implements BaseItem {
    public RingOfTheTitans() {
        super(
                ItemQuality.AVERAGE,
                "Ring of Strength",
                "A ring crafted in the style of the Titans, boosting health and armor.",
                "ring"
        );

        addProperty("HEALTH", 40);
        addProperty("ARMOR", 3);

        super.slotHeight = 1;
        super.slotWidth = 1;
    }
}
