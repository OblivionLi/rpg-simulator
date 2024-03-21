package org.balaur.rpgcharactercreation.model.attributes;

import lombok.Getter;
import lombok.Setter;
import org.balaur.rpgcharactercreation.util.AttributesConsts;

@Setter
@Getter
public class MainAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int charisma;

    public MainAttributes() {
        strength = AttributesConsts.STR_STARTING_VALUE;
        dexterity = AttributesConsts.DEX_STARTING_VALUE;
        intelligence = AttributesConsts.INT_STARTING_VALUE;
        charisma = AttributesConsts.CHAR_STARTING_VALUE;
    }
}
