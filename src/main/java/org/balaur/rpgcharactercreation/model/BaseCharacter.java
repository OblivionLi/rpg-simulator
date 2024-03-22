package org.balaur.rpgcharactercreation.model;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.attributes.MainAttributes;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;

@Getter
public abstract class BaseCharacter implements RPGCharacter {
    private String name;
    private AlignmentType alignment;
    private LevelingSystem levelingSystem;
    private DamageType damageType;
    private MainAttributes attributes;

    public BaseCharacter(String name, AlignmentType alignment, LevelingSystem levelingSystem, DamageType damageType, MainAttributes attributes) {
        this.name = name;
        this.alignment = alignment;
        this.levelingSystem = levelingSystem;
        this.damageType = damageType;
        this.attributes = attributes;
    }
}
