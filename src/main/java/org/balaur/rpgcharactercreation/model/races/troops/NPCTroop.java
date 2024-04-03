package org.balaur.rpgcharactercreation.model.races.troops;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.BaseCharacter;
import org.balaur.rpgcharactercreation.model.attributes.main.MainAttributes;
import org.balaur.rpgcharactercreation.model.attributes.sub.SubAttributesType;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.model.races.GameEntity;
import org.balaur.rpgcharactercreation.model.races.NPCRaceType;
import org.balaur.rpgcharactercreation.util.*;

@Getter
public class NPCTroop extends BaseCharacter implements NPCRaceType {
    private Races race;
    private TeamColors teamColor;
    private NPCRanks rank;
    private NPCRaceType npcRaceType;

    public NPCTroop(Builder builder) {
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
                        builder.troopType
                )
        );

        this.rank = NPCRanks.RECRUIT;
        this.npcRaceType = builder.npcRaceType;
        this.race = builder.race;
        this.teamColor = builder.teamColor;
    }

    @Override
    public String displayCharacterInfo(String race) {
        return "------------------------------------" + "\n" +
                "Name: " + super.getName() + "\n" +
                "Race: " + race + "\n" +
                "Alignment: " + super.getAlignment().name() + "\n" +
                "Damage Type: " + super.getDamageType().name() + "\n" +
                "------------------------------------" + "\n" +
                "Current Experience: " + super.getLevelingSystem().getCurrentExperience() + "\n" +
                "Experience Required: " + super.getLevelingSystem().getNPCExperienceRequired() + "\n" +
                "------------------------------------" + "\n" +
                super.getAttributes().displayAttributes();
    }

    @Override
    public void gainExperience(int experience) {
        LevelingSystem ls = getLevelingSystem();
        int pointsToIncreaseStats = ls.getNPCAttributesPointsAmount(experience);

        if (pointsToIncreaseStats == 0) {
            return;
        }

        MainAttributes ma = getAttributes();

        // An NPC (troop) should increase only its strength and dexterity on level up
        ma.increaseStrength(pointsToIncreaseStats);
        ma.increaseDexterity(pointsToIncreaseStats);

        rank = NPCRanks.getRankBasedOnExperience(ls.getCurrentExperience());
    }

    @Override
    public MainAttributes getMainAttributes() {
        return super.getAttributes();
    }

    @Override
    public SubAttributesType getSubAttributes() {
        return super.getAttributes().getSubAttributes();
    }

    // TODO:: duplicated in PlayerHero with fewer properties; either leave it like it is now or abstract it (there will be only 2 builders for now, 1 for player and 1 for npc troop)
    public static class Builder {
        private AlignmentType alignmentType;
        private NPCRaceType npcRaceType;
        private String name;
        private DamageType damageType;
        private int troopXP;
        private int strength;
        private int dexterity;
        private int intelligence;
        private int charisma;
        private Races race;
        private boolean canAttackGroundUnits;
        private boolean canAttackAirUnits;
        private TeamColors teamColor;
        private TroopType troopType;

        public Builder withNPCTroopType(TroopType troopType) {
            this.troopType = troopType;
            return this;
        }

        public Builder withTeamColor(TeamColors teamColor) {
            this.teamColor = teamColor;
            return this;
        }

        public Builder withAlignmentType(AlignmentType alignmentType) {
            this.alignmentType = alignmentType;
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

        public Builder withNPCRaceType(NPCRaceType npcRaceType) {
            this.npcRaceType = npcRaceType;
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

        public Builder withTroopXP(int troopXP) {
            this.troopXP = troopXP;
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

        public NPCTroop build() {
            return new NPCTroop(this);
        }
    }
}
