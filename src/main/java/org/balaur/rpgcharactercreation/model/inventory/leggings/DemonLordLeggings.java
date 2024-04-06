package org.balaur.rpgcharactercreation.model.inventory.leggings;

import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

public class DemonLordLeggings extends BaseItemSlot implements BaseItem {
    public DemonLordLeggings() {
        super(
                ItemQuality.LEGENDARY,
                "Traveler's Trousers",
                "Leggings said to have been worn by the demon lord, greatly enhancing combat abilities, health and provides a special bonus of increased training.",
                "leggings"
        );

        addProperty("COMBAT", 10);
        addProperty("TRAINING", 10);
        addProperty("HEALTH", 100);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
