package org.balaur.rpgcharactercreation.model.inventory.weapon;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class Flamebrand extends BaseItemSlot implements BaseItem {
    private final int COMBAT = 3;
    private final int SPEED = 2;

    public Flamebrand() {
        super(
                ItemQuality.AVERAGE,
                "Flamebrand",
                "A sword imbued with fire, enhancing combat abilities and speed.",
                "weapon"
        );

        super.slotHeight = 2;
        super.slotWidth = 1;
    }
}
