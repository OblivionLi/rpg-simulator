package org.balaur.rpgcharactercreation.model.attributes.sub;

import org.balaur.rpgcharactercreation.model.attributes.resistances.Resistances;
import org.balaur.rpgcharactercreation.util.StatUpdateAction;

import java.util.Map;

public interface SubAttributesType {
    void increaseStatsOnLevelUp(int levels);
    void updateStrengthRelatedAttributes(int strength);
    void updateDexterityRelatedAttributes(int dexterity);
    void updateIntelligenceRelatedAttributes(int intelligence);
    void updateCharismaRelatedAttributes(int charisma);
    void updateResistances();
    String displaySubAttributes();
    Resistances getResistances();
    void reduceHealth(int damage);

    int getHealth();
    int getMana();
    int getCombat();
    int getSpeed();
    int getLifeRegeneration();
    float getLifeRegenerationTimer();
    int getManaRegeneration();
    float getManaRegenerationTimer();
    int getTroopXP();
    double getSpellCastingChance();
    int getCommand();
    int getMorale();
    double getDiscount();
    int getRetinueSlots();

    void updateStatsBasedOnItem(Map<String, Integer> properties, StatUpdateAction action);
}
