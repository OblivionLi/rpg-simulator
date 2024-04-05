package org.balaur.rpgcharactercreation.model.inventory.body;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class CelestialRobes extends BaseItemSlot implements BaseItem {
    private final int HEALTH = 80;
    private final int ARMOR = 6;
    private final int MANA = 16;
    private final int MANA_REGENERATION = 2;

    public CelestialRobes() {
        super(
                ItemQuality.ARTIFACT,
                "Celestial Robes",
                "Robes woven from the fabric of Celestia itself, providing a major boost to health, armor, mana and mana regeneration.",
                "body"
        );

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
