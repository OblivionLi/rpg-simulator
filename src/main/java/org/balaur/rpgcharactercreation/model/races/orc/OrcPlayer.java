package org.balaur.rpgcharactercreation.model.races.orc;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.BaseCharacter;
import org.balaur.rpgcharactercreation.model.attributes.MainAttributes;
import org.balaur.rpgcharactercreation.model.attributes.SubAttributes;
import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.balaur.rpgcharactercreation.util.AlignmentType;
import org.balaur.rpgcharactercreation.util.DamageType;
import org.balaur.rpgcharactercreation.util.AttributesStartingValues;

@Getter
public class OrcPlayer extends BaseCharacter {
    private final String race = "Orc";

    public OrcPlayer(String name) {
        super(
                name,
                AlignmentType.GOOD,
                new LevelingSystem(),
                DamageType.CRUSHING,
                new MainAttributes(
                        AttributesStartingValues.ORC_STR_STARTING_VALUE,
                        AttributesStartingValues.ORC_DEX_STARTING_VALUE,
                        AttributesStartingValues.ORC_INT_STARTING_VALUE,
                        AttributesStartingValues.ORC_CHA_STARTING_VALUE,
                        0
                )
        );
    }

    public String displayCharacterInfo() {
        return super.displayCharacterInfo(race);
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
}
