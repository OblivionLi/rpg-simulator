package org.balaur.rpgcharactercreation.model.inventory.body;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class CelestialRobes extends BaseItemSlot implements BaseItem {
    public CelestialRobes() {
        super(
                ItemQuality.ARTIFACT,
                "Celestial Robes",
                "Robes woven from the fabric of Celestia itself, providing a major boost to health, armor, mana and mana regeneration.",
                "body"
        );

        addProperty("HEALTH", 80);
        addProperty("ARMOR", 6);
        addProperty("MANA", 16);
        addProperty("MANAREGENERATION", 2);

        super.slotHeight = 2;
        super.slotWidth = 2;
    }
}
