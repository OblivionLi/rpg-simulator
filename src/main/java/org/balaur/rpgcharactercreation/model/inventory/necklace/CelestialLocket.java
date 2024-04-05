package org.balaur.rpgcharactercreation.model.inventory.necklace;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class CelestialLocket extends BaseItemSlot implements BaseItem {
    private final int HEALTH = 70;
    private final int ARMOR = 4;
    private final int MANA = 14;
    private final int MANA_REGENERATION = 4;

    public CelestialLocket() {
        super(
                ItemQuality.ARTIFACT,
                "Celestial Locket",
                "A locket containing a piece of Celestia, providing a major boost to health, armor, mana and mana regeneration.",
                "necklace"
        );

        super.slotHeight = 1;
        super.slotWidth = 2;
    }
}
