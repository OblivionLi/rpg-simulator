package org.balaur.rpgcharactercreation.model.races.troops;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.races.TroopType;

@Getter
public abstract class BaseTroop implements TroopType {
    protected int combat;
    protected int health;
    protected int speed;
    protected float morale;
    protected int magery;
    protected int resistance;
    protected int armor;
    protected int lifeRegeneration;
    protected float lifeRegenerationTimer;
    protected int mana;
    protected int manaRegeneration;
    protected float manaRegenerationTimer;
    protected int troopXP;
    protected double spellCastingChance;
}
