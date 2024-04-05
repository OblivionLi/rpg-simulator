package org.balaur.rpgcharactercreation.model.races.player;

import lombok.Getter;

@Getter
public abstract class BasePlayer implements PlayerType {
    protected int combat;
    protected int health;
    protected int speed;
    protected int command;
    protected float morale;
    protected int magery;
    protected int resistance;
    protected int training;
    protected int merchant;
    protected int lifeRegeneration;
    protected float lifeRegenerationTimer;
    protected int armor;
    protected int mana;
    protected int manaRegeneration;
    protected float manaRegenerationTimer;
    protected double spellCastingChance;
    protected double discount;
    protected int retinueSlots;
    protected int viewRange;
}
