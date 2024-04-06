package org.balaur.rpgcharactercreation.model.inventory.helmet;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class TitanHelm extends BaseItemSlot implements BaseItem {
    public TitanHelm() {
        super(
                ItemQuality.AVERAGE,
                "Titan's Helm",
                "A heavily worn helmet, once adorned by the Titans of old. Despite its diminished state, it still offers slight increases to health and armor.",
                "helmet"
        );

        addProperty("SPEED", 3);
        addProperty("HEALTH", 60);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
