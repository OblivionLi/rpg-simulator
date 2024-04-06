package org.balaur.rpgcharactercreation.model.inventory.necklace;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class PendantOfVitality extends BaseItemSlot implements BaseItem {
    public PendantOfVitality() {
        super(
                ItemQuality.MAJOR,
                "Pendant of Vitality",
                "A pendant that boosts health, armor, and lifeRegeneration.",
                "necklace"
        );

        addProperty("LIFE_REGENERATION", 4);
        addProperty("ARMOR", 4);
        addProperty("HEALTH", 50);

        super.slotHeight = 1;
        super.slotWidth = 2;
    }
}
