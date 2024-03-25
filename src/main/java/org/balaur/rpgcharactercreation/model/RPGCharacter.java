package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.attributes.MainAttributes;
import org.balaur.rpgcharactercreation.model.attributes.SubAttributes;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;

public interface RPGCharacter {
    String displayCharacterInfo();
    void gainExperience(int experience);
    LevelingSystem getLevelingSystem();
    MainAttributes getMainAttributes();
    SubAttributes getSubAttributes();
}
