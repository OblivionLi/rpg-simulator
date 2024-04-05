package org.balaur.rpgcharactercreation.model;

import lombok.Getter;

@Getter
public class CharacterActions {
    private boolean canAttackGroundUnits;
    private boolean canAttackAirUnits;
    private boolean canRangeAttack;
    private boolean canStun;
    private boolean canBurn;
    private boolean canFreeze;
    private boolean canPoison;
    private boolean canDisease;

    public CharacterActions(boolean canAttackGroundUnits, boolean canAttackAirUnits, boolean canRangeAttack,
                         boolean canStun, boolean canBurn, boolean canFreeze, boolean canPoison, boolean canDisease) {
        this.canAttackGroundUnits = canAttackGroundUnits;
        this.canAttackAirUnits = canAttackAirUnits;
        this.canRangeAttack = canRangeAttack;
        this.canStun = canStun;
        this.canBurn = canBurn;
        this.canFreeze = canFreeze;
        this.canPoison = canPoison;
        this.canDisease = canDisease;
    }
}
