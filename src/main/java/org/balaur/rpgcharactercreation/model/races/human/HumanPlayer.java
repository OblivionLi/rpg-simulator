package org.balaur.rpgcharactercreation.model.races.human;

import org.balaur.rpgcharactercreation.model.BaseCharacter;
import org.balaur.rpgcharactercreation.model.attributes.MainAttributes;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;

public class HumanPlayer extends BaseCharacter {
    private static final int STR_STARTING_VALUE = 5;
    private static final int DEX_STARTING_VALUE = 5;
    private static final int INT_STARTING_VALUE = 5;
    private static final int CHAR_STARTING_VALUE = 5;

    public HumanPlayer(String name) {
        super(
                name,
                AlignmentType.GOOD,
                new LevelingSystem(),
                DamageType.SLASHING,
                new MainAttributes(STR_STARTING_VALUE, DEX_STARTING_VALUE, INT_STARTING_VALUE, CHAR_STARTING_VALUE, 0)
        );
    }

    @Override
    public String displayCharacterInfo() {
        int level = getLevelingSystem().getLevel();
        int levelPoints = getLevelingSystem().getLevelPoints();
        int currentExperience = getLevelingSystem().getCurrentExperience();
        int experienceRequired = getLevelingSystem().getExperienceRequired();

        return "Name: " + getName() + "\n" +
                "Race: " + "Human" + "\n" +
                "Alignment: " + getAlignment().name() + "\n" +
                "Damage: " + getDamageType().name() + "\n" +
                "------------------------------------" + "\n" +
                "Level: " + level + "\n" +
                "Unspent Level Points: " + levelPoints + "\n" +
                "Current Experience: " + currentExperience + "\n" +
                "Experience Required: " + experienceRequired + "\n" +
                "------------------------------------" + "\n" +
                getAttributes().displayAttributes();
    }

    @Override
    public void gainExperience(int experience) {
        LevelingSystem ls = getLevelingSystem();
        MainAttributes ma = getAttributes();

        if (ls.shouldLevelUp(experience)) {
            ls.levelUp(ma.getSubAttributes().getTraining());
            ma.getSubAttributes().increaseStatsOnLevelUp();
        }
    }
}
