package org.balaur.rpgcharactercreation.model.races.troops;

public interface TroopType {
    int getCombat();
    int getHealth();
    int getSpeed();
    int getCommand();
    int getMorale();
    int getMagery();
    int getResistance();
    int getTraining();
    int getMerchant();
    int getTroopXP();
    int getArmor();
    int getLifeRegeneration();
    float getLifeRegenerationTimer();
    int getMana();
    int getManaRegeneration();
    float getManaRegenerationTimer();
    double getSpellCastingChance();
    double getDiscount();
    int getRetinueSlots();
}
