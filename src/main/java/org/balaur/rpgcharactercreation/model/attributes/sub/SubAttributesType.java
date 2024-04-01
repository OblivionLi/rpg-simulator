package org.balaur.rpgcharactercreation.model.attributes.sub;

public interface SubAttributesType {
    void increaseStatsOnLevelUp(int levels);
    void updateStrengthRelatedAttributes(int strength);
    void updateDexterityRelatedAttributes(int dexterity);
    void updateIntelligenceRelatedAttributes(int intelligence);
    void updateCharismaRelatedAttributes(int charisma);
    void updateResistances();
    String displaySubAttributes();
}
