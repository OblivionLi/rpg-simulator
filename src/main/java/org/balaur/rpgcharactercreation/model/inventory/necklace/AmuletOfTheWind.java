package org.balaur.rpgcharactercreation.model.inventory.necklace;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class AmuletOfTheWind extends BaseItemSlot implements BaseItem {
    private final int SPEED = 1;

    public AmuletOfTheWind() {
        super(
                ItemQuality.MINOR,
                "Amulet of the Wind",
                "A light amulet that slightly increases speed.",
                "necklace"
        );

        super.slotHeight = 1;
        super.slotWidth = 2;
    }
}
