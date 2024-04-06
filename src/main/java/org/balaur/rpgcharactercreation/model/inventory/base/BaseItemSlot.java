package org.balaur.rpgcharactercreation.model.inventory.base;

import lombok.Getter;
import org.balaur.rpgcharactercreation.util.ItemQuality;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseItemSlot {
    @Getter
    private final Map<String, Integer> properties = new HashMap<String, Integer>();
    @Getter
    protected ItemQuality itemQuality;
    @Getter
    protected String name;
    @Getter
    protected String description;
    @Getter
    protected String itemSlotType; // maybe change this an enum??

    protected int slotWidth;
    protected int slotHeight;

    public BaseItemSlot(ItemQuality itemQuality, String name, String description, String itemSlotType) {
        this.itemQuality = itemQuality;
        this.name = name;
        this.description = description;
        this.itemSlotType = itemSlotType;
    }

    public int[] getItemSize() {
        return new int[]{slotWidth, slotHeight};
    }

    public void addProperty(String propertyName, int value) {
        properties.put(propertyName, value);
    }

    public Integer getProperty(String propertyName) {
        return properties.get(propertyName);
    }
}
