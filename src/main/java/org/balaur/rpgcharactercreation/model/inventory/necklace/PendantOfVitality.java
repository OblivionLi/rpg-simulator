package org.balaur.rpgcharactercreation.model.inventory.necklace;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class PendantOfVitality extends BaseItemSlot implements BaseItem {
    private final int HEALTH = 50;
    private final int ARMOR = 4;
    private final int LIFE_REGENERATION = 4;

    public PendantOfVitality() {
        super(
                ItemQuality.MAJOR,
                "Pendant of Vitality",
                "A pendant that boosts health, armor, and lifeRegeneration.",
                "necklace"
        );

        super.slotHeight = 1;
        super.slotWidth = 2;
    }
}
