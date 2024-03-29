package org.balaur.rpgcharactercreation.model.races;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.BaseCharacter;
import org.balaur.rpgcharactercreation.model.attributes.main.MainAttributes;
import org.balaur.rpgcharactercreation.model.attributes.sub.SubAttributes;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;
import org.balaur.rpgcharactercreation.util.Races;
import org.balaur.rpgcharactercreation.util.TeamColors;

@Getter
public class PlayerHero extends BaseCharacter {
    private Races race;
    private TeamColors teamColor;
    private final boolean canAttackGroundUnits = true;
    private final boolean canAttackAirUnits = true;

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
                        builder.charisma
                )
        );

        this.race = builder.race;
        this.teamColor = builder.teamColor;
    }

    public String displayCharacterInfo() {
        return super.displayCharacterInfo(race.getRace());
    }

    @Override
    public void gainExperience(int experience) {
        super.gainExperience(experience);
    }

    @Override
    public LevelingSystem getLevelingSystem() {
        return super.getLevelingSystem();
    }

    @Override
    public MainAttributes getMainAttributes() {
        return super.getAttributes();
    }

    @Override
    public SubAttributes getSubAttributes() {
        return super.getAttributes().getSubAttributes();
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

        public PlayerHero build() {
            return new PlayerHero(this);
        }
    }
}
