package org.balaur.rpgcharactercreation.model.races;

public interface TroopType {
    int getCombat();
    int getHealth();
    int getSpeed();
    float getMorale();
    int getMagery();
    int getResistance();
    int getArmor();
    int getLifeRegeneration();
    float getLifeRegenerationTimer();
    int getMana();
    int getManaRegeneration();
    float getManaRegenerationTimer();
    int getTroopXP();
    double getSpellCastingChance();
}
