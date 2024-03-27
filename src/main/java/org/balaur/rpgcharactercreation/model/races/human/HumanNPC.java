package org.balaur.rpgcharactercreation.model.races.human;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.BaseCharacter;
import org.balaur.rpgcharactercreation.model.attributes.MainAttributes;
import org.balaur.rpgcharactercreation.model.attributes.SubAttributes;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;
import org.balaur.rpgcharactercreation.util.NPCRanks;

@Getter
public class HumanNPC extends BaseCharacter {
    private final String race = "Human";
    private NPCRanks rank;

    public HumanNPC(String name, DamageType damageType, int troopXP, int strength, int dexterity, int intelligence, int charisma) {
        super(
                name,
                AlignmentType.GOOD,
                new LevelingSystem(),
                damageType,
                new MainAttributes(
                        strength,
                        dexterity,
                        intelligence,
                        charisma,
                        troopXP
                ));

        rank = NPCRanks.RECRUIT;
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
                "Experience Required: " + super.getLevelingSystem().getExperienceRequired() + "\n" +
                "------------------------------------" + "\n" +
                super.getAttributes().displayNPCAttributes();
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
    public SubAttributes getSubAttributes() {
        return super.getAttributes().getSubAttributes();
    }
}
