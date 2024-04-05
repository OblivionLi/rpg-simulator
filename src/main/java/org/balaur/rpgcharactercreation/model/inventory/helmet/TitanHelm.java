package org.balaur.rpgcharactercreation.model.inventory.helmet;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class TitanHelm extends BaseItemSlot implements BaseItem {
    private final int HEALTH = 60;
    private final int ARMOR = 3;

    public TitanHelm() {
        super(
                ItemQuality.AVERAGE,
                "Titan's Helm",
                "A heavily worn helmet, once adorned by the Titans of old. Despite its diminished state, it still offers slight increases to health and armor.",
                "helmet"
        );

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
