package org.balaur.rpgcharactercreation.model.inventory.body;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class ChainmailOfTheTitans extends BaseItemSlot implements BaseItem {
    private final int HEALTH = 60;
    private final int ARMOR = 3;
    private final int RESISTANCE = 3;

    public ChainmailOfTheTitans() {
        super(
                ItemQuality.MAJOR,
                "Chainmail of the Titans",
                "Armor crafted in the style of the Titans, boosting health , armor and resistance.",
                "body"
        );

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
