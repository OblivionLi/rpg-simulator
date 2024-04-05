package org.balaur.rpgcharactercreation.model.inventory.helmet;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class RavenShadow extends BaseItemSlot implements BaseItem {
    private final int SPEED = 1;

    public RavenShadow() {
        super(
                ItemQuality.MINOR,
                "Raven's Shadow",
                "A helmet made from the feathers of a raven. It provides a slight boost to speed.",
                "helmet"
        );

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
