package org.balaur.rpgcharactercreation.model.races.troops;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.races.statuses.StatusEffectReceiver;
import org.balaur.rpgcharactercreation.util.IllnessType;
import org.balaur.rpgcharactercreation.util.PsycheType;

@Getter
public abstract class BaseTroop implements TroopType, StatusEffectReceiver {
    protected int combat;
    protected int health;
    protected int speed;
    protected int command;
    protected int morale;
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
    protected int troopXP;
    protected int viewRange;

    @Override
    public void receiveIllness(IllnessType illness) {
        //TODO:: implementation of receiving illness
        System.out.println("Received illness: " + illness);
    }

    @Override
    public void receivePsyche(PsycheType psyche) {
        //TODO:: implementation of receiving psyche
        System.out.println("Received psyche: " + psyche);
    }
}
