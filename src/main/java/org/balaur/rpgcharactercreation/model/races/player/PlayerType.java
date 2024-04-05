package org.balaur.rpgcharactercreation.model.races.player;

public interface PlayerType {
    int getCombat();
    int getHealth();
    int getSpeed();
    int getCommand();
    float getMorale();
    int getMagery();
    int getResistance();
    int getTraining();
    int getMerchant();
    int getArmor();
    int getLifeRegeneration();
    float getLifeRegenerationTimer();
    int getMana();
    int getManaRegeneration();
    float getManaRegenerationTimer();
    double getSpellCastingChance();
    double getDiscount();
    int getRetinueSlots();
    int getViewRange();
}
