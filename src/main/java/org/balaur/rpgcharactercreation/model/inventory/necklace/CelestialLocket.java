package org.balaur.rpgcharactercreation.model.inventory.necklace;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class CelestialLocket extends BaseItemSlot implements BaseItem {
    public CelestialLocket() {
        super(
                ItemQuality.ARTIFACT,
                "Celestial Locket",
                "A locket containing a piece of Celestia, providing a major boost to health, armor, mana and mana regeneration.",
                "necklace"
        );

        addProperty("MANA", 14);
        addProperty("MANA_REGENERATION", 4);
        addProperty("ARMOR", 4);
        addProperty("HEALTH", 70);

        super.slotHeight = 1;
        super.slotWidth = 2;
    }
}
