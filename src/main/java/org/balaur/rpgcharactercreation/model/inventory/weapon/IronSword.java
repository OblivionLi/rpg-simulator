package org.balaur.rpgcharactercreation.model.inventory.weapon;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class IronSword extends BaseItemSlot implements BaseItem {
    private final int COMBAT = 3;

    public IronSword() {
        super(
                ItemQuality.MINOR,
                "Iron Sword",
                "A basic sword that provides a small increase to combat.",
                "weapon"
        );

        super.slotHeight = 2;
        super.slotWidth = 1;
    }
}
