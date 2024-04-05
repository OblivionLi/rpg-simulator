package org.balaur.rpgcharactercreation.model.inventory.weapon;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.inventory.BaseItem;
import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;
import org.balaur.rpgcharactercreation.util.ItemQuality;

@Getter
public class Demonbane extends BaseItemSlot implements BaseItem {
    private final int COMBAT = 10;
    private final int SPEED = 7;
    private final int COMMAND = 5;

    public Demonbane() {
        super(
                ItemQuality.LEGENDARY,
                "Demonbane",
                "A sword said to have slain the demon lord, greatly boosting combat, speed, and provides a special bonus of increased command.",
                "weapon"
        );

        super.slotHeight = 2;
        super.slotWidth = 1;
    }
}
