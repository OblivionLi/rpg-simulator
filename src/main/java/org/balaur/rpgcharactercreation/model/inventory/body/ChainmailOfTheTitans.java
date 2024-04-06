package org.balaur.rpgcharactercreation.model.inventory.body;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class ChainmailOfTheTitans extends BaseItemSlot implements BaseItem {
    public ChainmailOfTheTitans() {
        super(
                ItemQuality.MAJOR,
                "Chainmail of the Titans",
                "Armor crafted in the style of the Titans, boosting health , armor and resistance.",
                "body"
        );

        addProperty("HEALTH", 60);
        addProperty("ARMOR", 3);
        addProperty("RESISTANCE", 3);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
