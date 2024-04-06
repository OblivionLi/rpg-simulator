package org.balaur.rpgcharactercreation.model.inventory.weapon;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class Flamebrand extends BaseItemSlot implements BaseItem {
    public Flamebrand() {
        super(
                ItemQuality.AVERAGE,
                "Flamebrand",
                "A sword imbued with fire, enhancing combat abilities and speed.",
                "weapon"
        );

        addProperty("COMBAT", 3);
        addProperty("SPEED", 2);

        super.slotHeight = 2;
        super.slotWidth = 1;
    }
}
