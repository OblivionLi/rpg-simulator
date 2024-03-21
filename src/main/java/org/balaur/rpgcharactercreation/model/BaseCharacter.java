package org.balaur.rpgcharactercreation.model;


import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;

public abstract class BaseCharacter {
    protected String name;
    protected LevelingSystem levelingSystem;
    protected DamageType damageType;
    protected AlignmentType alignment;

}
