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
    private final InventoryBag inventory = new InventoryBag(4, 8);

    public void equip(BaseItemSlot item) {
        switch (item.getItemSlotType()) {
            case "helmet" -> {
                if (this.helmet != null) {
                    unequip(this.helmet);
                }
                this.helmet = item;
            }
            case "necklace" -> {
                if (this.necklace != null) {
                    unequip(this.necklace);
                }
                this.necklace = item;
            }
            case "weapon" -> {
                if (this.weapon != null) {
                    unequip(this.weapon);
                }
                this.weapon = item;
            }
            case "body" -> {
                if (this.body != null) {
                    unequip(this.body);
                }
                this.body = item;
            }
            case "leggings" -> {
                if (this.leggings != null) {
                    unequip(this.leggings);
                }
                this.leggings = item;
            }
            case "boots" -> {
                if (this.boots != null) {
                    unequip(this.boots);
                }
                this.boots = item;
            }
            case "ring" -> {
                if (this.ring != null) {
                    unequip(this.ring);
                }
                this.ring = item;
            }
        }
    }

    public void unequip(BaseItemSlot item) {
        switch (item.getItemSlotType()) {
            case "helmet" -> this.helmet = null;
            case "necklace" -> this.necklace = null;
            case "body" -> this.body = null;
            case "leggings" -> this.leggings = null;
            case "boots" -> this.boots = null;
            case "ring" -> this.ring = null;
            case "weapon" -> this.weapon = null;
        }

        inventory.removeItem(item);
    }
}
