package org.balaur.rpgcharactercreation.model;

import lombok.Getter;
import lombok.Setter;
import org.balaur.rpgcharactercreation.model.attributes.main.MainAttributes;
import org.balaur.rpgcharactercreation.model.attributes.sub.SubAttributes;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.model.races.GameEntity;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;
import org.balaur.rpgcharactercreation.util.HitType;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public abstract class BaseCharacter implements RPGCharacter, GameEntity {
    private String name;
    private AlignmentType alignment;
    private LevelingSystem levelingSystem;
    private DamageType damageType;
    private MainAttributes attributes;
    @Setter
    private CharacterActions actions;
    @Setter
    private CharacterEffects effects;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public BaseCharacter(String name, AlignmentType alignment, LevelingSystem levelingSystem, DamageType damageType, MainAttributes attributes) {
        this.name = name;
        this.alignment = alignment;
        this.levelingSystem = levelingSystem;
        this.damageType = damageType;
        this.attributes = attributes;
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

    public void startAttacking(GameEntity target) {
        int delay = calculateDelay(getSubAttributes().getSpeed());
        scheduler.scheduleAtFixedRate(() -> attack(target), 0, delay, TimeUnit.SECONDS);
    }

    private int calculateDelay(int speed) {
        // TODO:: test and check if these values are fine for the speed
        return Math.max(1, 10 - speed);
    }

    public void stopAttacking() {
        scheduler.shutdown();
    }

    public void attack(GameEntity target) {
        int damage = calculateDamageDealt(target);
        target.getAttributes().getSubAttributes().reduceHealth(damage);
        System.out.println(name + " received " + damage + " damage");
    }

    private int calculateDamageDealt(GameEntity target) {
        // formula to calculate the damage:

        // 1.Combat comparison
        HitType hitType = calculateHitType(getSubAttributes().getCombat(), target.getAttributes().getSubAttributes().getCombat());

        // 2.Armour/resistance reduction
        DamageType thisDamageType = getDamageType();
        double resistanceToThisDamageType = target.getAttributes().getSubAttributes().getResistances().getResistanceBasedOnDamageType(thisDamageType) * 1.0;

        // TODO:: Not implemented yet 3.Special resistance/weakness

        // 4.Applying damage/reducing HP
        return getFinalDamage(hitType, resistanceToThisDamageType);
    }

    private int getFinalDamage(HitType hitType, double resistance) {
        double damage = getAttributes().getSubAttributes().getCombat();
        double resistedDamage = damage * (resistance / 10);
        int finalDamage = (int) Math.max(0, damage - resistedDamage);

        switch (hitType) {
            case MISS:
                finalDamage = 1;
                break;
            case MARGINAL_HIT:
                finalDamage = Math.max(1, finalDamage / 2);
                break;
            case STANDARD_HIT:
                break;  // No change to the damage
            case CRITICAL_HIT:
                finalDamage *= 2;
                break;
            case DEATHBLOW:
                finalDamage *= 4;
                break;
        }

        return finalDamage;
    }

    private HitType calculateHitType(int attackerCombat, int defenderCombat) {
        double ratio = (double) attackerCombat / defenderCombat;
        double rand = Math.random();

        double missThreshold = 0.2 / ratio;
        double marginalHitThreshold = missThreshold + 0.2 / ratio;
        double standardHitThreshold = marginalHitThreshold + 0.2 * ratio;
        double criticalHitThreshold = standardHitThreshold + 0.2 * ratio;

        if (rand < missThreshold) {
            return HitType.MISS;
        } else if (rand < marginalHitThreshold) {
            return HitType.MARGINAL_HIT;
        } else if (rand < standardHitThreshold) {
            return HitType.STANDARD_HIT;
        } else if (rand < criticalHitThreshold) {
            return HitType.CRITICAL_HIT;
        } else {
            return HitType.DEATHBLOW;
        }
    }
}
