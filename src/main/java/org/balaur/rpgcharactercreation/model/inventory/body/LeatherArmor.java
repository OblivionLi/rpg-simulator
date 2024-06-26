package org.balaur.rpgcharactercreation.model.inventory.body;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class LeatherArmor extends BaseItemSlot implements BaseItem {
    public LeatherArmor() {
        super(
                ItemQuality.MINOR,
                "Leather Armor",
                "Basic armor that provides a slight increase to armor.",
                "body"
        );

        addProperty("ARMOR", 3);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
