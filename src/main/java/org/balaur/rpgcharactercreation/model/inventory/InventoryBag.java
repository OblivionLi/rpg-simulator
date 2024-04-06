package org.balaur.rpgcharactercreation.model.inventory;

import org.balaur.rpgcharactercreation.model.inventory.base.BaseItemSlot;

public class InventoryBag {
    private final BaseItemSlot[][] grid;

    public InventoryBag(int rows, int cols) {
        grid = new BaseItemSlot[rows][cols];
    }

    public boolean addItem(BaseItemSlot item) {
        int itemWidth = item.getItemSize()[0];
        int itemHeight = item.getItemSize()[1];

        for (int i = 0; i < grid.length - itemHeight + 1; i++) {
            for (int j = 0; j < grid[i].length - itemWidth + 1; j++) {
                if (checkSpace(i, j, itemWidth, itemHeight)) {
                    fillSpace(i, j, item, itemWidth, itemHeight);
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkSpace(int startRow, int startCol, int width, int height) {
        for (int i = startRow; i < startRow + height; i++) {
            for (int j = startCol; j < startCol + width; j++) {
                if (grid[i][j] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    private void fillSpace(int startRow, int startCol, BaseItemSlot item, int width, int height) {
        for (int i = startRow; i < startRow + height; i++) {
            for (int j = startCol; j < startCol + width; j++) {
                grid[i][j] = item;
            }
        }
    }

    public void removeItem(BaseItemSlot item) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == item) {
                    grid[i][j] = null;
                }
            }
        }
    }
}
