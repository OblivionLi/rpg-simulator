package org.balaur.rpgcharactercreation.model;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.attributes.main.MainAttributes;
import org.balaur.rpgcharactercreation.model.attributes.sub.SubAttributes;
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
    private boolean canAttackGroundUnits = true;
    private boolean canAttackAirUnits = true;

    public BaseCharacter(String name, AlignmentType alignment, LevelingSystem levelingSystem, DamageType damageType, MainAttributes attributes) {
        this.name = name;
        this.alignment = alignment;
        this.levelingSystem = levelingSystem;
        this.damageType = damageType;
        this.attributes = attributes;
    }

    public void updateAllowedAttacks(boolean canAttackGroundUnits, boolean canAttackAirUnits) {
        this.canAttackAirUnits = canAttackAirUnits;
        this.canAttackGroundUnits = canAttackGroundUnits;
    }

    public String displayCharacterInfo(String race) {
        return "------------------------------------" + "\n" +
                "Name: " + name + "\n" +
                "Race: " + race + "\n" +
                "Alignment: " + alignment.name() + "\n" +
                "Damage Type: " + damageType.name() + "\n" +
                "------------------------------------" + "\n" +
                "Level: " + levelingSystem.getLevel() + "\n" +
                "Unspent Level Points: " + levelingSystem.getLevelPoints() + "\n" +
                "Current Experience: " + levelingSystem.getCurrentExperience() + "\n" +
                "Experience Required: " + levelingSystem.getExperienceRequired() + "\n" +
                "------------------------------------" + "\n" +
                attributes.displayAttributes();
    }

    public void gainExperience(int experience) {
        if (experience <= 0) {
            return;
        }

        if (levelingSystem.shouldLevelUp(experience)) {
            int prevLevel = levelingSystem.getLevel();
            levelingSystem.levelUp(((SubAttributes) attributes.getSubAttributes()).getTraining());
            attributes.getSubAttributes().increaseStatsOnLevelUp(levelingSystem.getLevel() - prevLevel);
        }
    }
}
