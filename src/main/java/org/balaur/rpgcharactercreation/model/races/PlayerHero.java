package org.balaur.rpgcharactercreation.model.races;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.BaseCharacter;
import org.balaur.rpgcharactercreation.model.attributes.main.MainAttributes;
import org.balaur.rpgcharactercreation.model.attributes.sub.SubAttributesType;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.model.races.troops.TroopType;
import org.balaur.rpgcharactercreation.util.*;

@Getter
public class PlayerHero extends BaseCharacter {
    private Races race;
    private TeamColors teamColor;

    public PlayerHero(Builder builder) {
        super(
                builder.name,
                builder.alignmentType,
                new LevelingSystem(),
                builder.damageType,
                new MainAttributes(
                        builder.strength,
                        builder.dexterity,
                        builder.intelligence,
                        builder.charisma,
                        builder.player
                )
        );

        this.race = builder.race;
        this.teamColor = builder.teamColor;
    }

    public String displayCharacterInfo() {
        return displayCharacterInfo(race.getRace());
    }

    @Override
    public void gainExperience(int experience) {
        gainExperience(experience);
    }

    @Override
    public LevelingSystem getLevelingSystem() {
        return getLevelingSystem();
    }

    @Override
    public MainAttributes getMainAttributes() {
        return getAttributes();
    }

    @Override
    public SubAttributesType getSubAttributes() {
        return super.getAttributes().getSubAttributes();
    }

    public void attack(GameEntity enemy) {
        int damage = calculateDamageDealt(enemy);
        enemy.getAttributes().getSubAttributes().reduceHealth(damage);
    }

    private int calculateDamageDealt(GameEntity enemy) {
        // formula to calculate the damage:

        // 1.Combat comparison
        HitType hitType = calculateHitType(getSubAttributes().getCombat(), enemy.getAttributes().getSubAttributes().getCombat());

        // 2.Armour/resistance reduction
        DamageType thisDamageType = getDamageType();
        double resistanceToThisDamageType = enemy.getAttributes().getSubAttributes().getResistances().getResistanceBasedOnDamageType(thisDamageType) * 1.0;

        // TODO:: Not implemented yet 3.Special resistance/weakness

        // 4.Applying damage/reducing HP
        return getFinalDamage(hitType, resistanceToThisDamageType);
    }

    private int getFinalDamage(HitType hitType, double resistance) {
        double damage = getAttributes().getSubAttributes().getCombat();

        // Calculate the amount of damage resisted
        double resistedDamage = damage * resistance;

        // Subtract the resisted damage from the initial damage
        int finalDamage = (int) (damage - resistedDamage);

        // Apply the multiplier based on the hit type
        switch (hitType) {
            case MISS:
                finalDamage = 1;
                break;
            case MARGINAL_HIT:
                finalDamage /= 2;
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
        // TODO:: improve this; right now the ratio is pretty static which isn't good; needs to be expanded a little bit more to work properly
        double ratio = (double) attackerCombat / defenderCombat;

        if (ratio < 1) {
            // If the attacker's combat score is lower than the defender's, the attack misses
            return HitType.MISS;
        } else if (ratio < 1.5) {
            // If the attacker's combat score is slightly higher than the defender's, the hit is marginal
            return HitType.MARGINAL_HIT;
        } else if (ratio < 2) {
            // If the attacker's combat score is moderately higher than the defender's, the hit is standard
            return HitType.STANDARD_HIT;
        } else if (ratio < 4) {
            // If the attacker's combat score is significantly higher than the defender's, the hit is critical
            return HitType.CRITICAL_HIT;
        } else {
            // If the attacker's combat score is much higher than the defender's, the hit is a deathblow
            return HitType.DEATHBLOW;
        }
    }

    // TODO:: duplicated in NPCTroop with additional properties; either leave it like it is now or abstract it (there will be only 2 builders for now, 1 for player and 1 for npc troop)
    public static class Builder {
        private AlignmentType alignmentType;
        private int strength;
        private int dexterity;
        private int intelligence;
        private int charisma;
        private String name;
        private DamageType damageType;
        private Races race;
        private boolean canAttackGroundUnits;
        private boolean canAttackAirUnits;
        private TeamColors teamColor;
        private TroopType player;

        public Builder withAlignmentType(AlignmentType alignmentType) {
            this.alignmentType = alignmentType;
            return this;
        }

        public Builder withColor(TeamColors color) {
            this.teamColor = color;
            return this;
        }

        public Builder withStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder withDexterity(int dexterity) {
            this.dexterity = dexterity;
            return this;
        }

        public Builder withIntelligence(int intelligence) {
            this.intelligence = intelligence;
            return this;
        }

        public Builder withCharisma(int charisma) {
            this.charisma = charisma;
            return this;
        }

        public Builder withCanAttackGroundUnits(boolean canAttackGroundUnits) {
            this.canAttackGroundUnits = canAttackGroundUnits;
            return this;
        }

        public Builder withCanAttackAirUnits(boolean canAttackAirUnits) {
            this.canAttackAirUnits = canAttackAirUnits;
            return this;
        }

        public Builder withRace(Races race) {
            this.race = race;
            return this;
        }


        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDamageType(DamageType damageType) {
            this.damageType = damageType;
            return this;
        }

        public Builder withPlayerType(TroopType player) {
            this.player = player;
            return this;
        }

        public PlayerHero build() {
            return new PlayerHero(this);
        }
    }
}
