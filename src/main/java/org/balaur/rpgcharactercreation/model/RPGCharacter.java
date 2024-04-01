package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.attributes.main.MainAttributes;
import org.balaur.rpgcharactercreation.model.attributes.sub.SubAttributesType;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.util.Races;

public interface RPGCharacter {
    String displayCharacterInfo(String race);
    Races getRace();
    void gainExperience(int experience);
    LevelingSystem getLevelingSystem();
    MainAttributes getMainAttributes();
    SubAttributesType getSubAttributes();
}
