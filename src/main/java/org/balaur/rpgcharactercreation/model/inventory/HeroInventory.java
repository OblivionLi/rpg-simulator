package org.balaur.rpgcharactercreation.model.inventory;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;

@Getter
public class HeroInventory {
    private BaseItemSlot helmet;
    private BaseItemSlot necklace;
    private BaseItemSlot weapon;
    private BaseItemSlot body;
    private BaseItemSlot leggings;
    private BaseItemSlot boots;
    private BaseItemSlot ring;

    public void equip(BaseItem item) {

    }

    public void unequip(BaseItem item) {

    }
}
