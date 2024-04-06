package org.balaur.rpgcharactercreation.model.inventory.helmet;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class CrownOfTheDemonLord extends BaseItemSlot implements BaseItem {
    public CrownOfTheDemonLord() {
        super(
                ItemQuality.LEGENDARY,
                "Crown of the Demon Lord",
                "A crown said to have been worn by the demon lord himself. It greatly enhances combat abilities, increases health, and provides a special bonus of increased morale.",
                "helmet"
        );

        addProperty("COMBAT", 10);
        addProperty("HEALTH", 100);
        addProperty("MORALE", 5);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
