package org.balaur.rpgcharactercreation.model.attributes.sub;

import org.balaur.rpgcharactercreation.model.attributes.resistances.Resistances;
import org.balaur.rpgcharactercreation.model.races.TroopType;

public class NPCSubAttributes implements SubAttributesType {
    private int combat;
    private int health;
    private int speed;
    private float morale;
    private int magery;
    private int resistance;
    private int armor;
    private int lifeRegeneration;
    private float lifeRegenerationTimer;
    private int mana;
    private int manaRegeneration;
    private float manaRegenerationTimer;
    private int troopXP;
    private double spellCastingChance;

    private Resistances resistances = new Resistances();

    public NPCSubAttributes(TroopType troop) {
        this.combat = troop.getCombat();
        this.health = troop.getHealth();
        this.speed = troop.getSpeed();
        this.morale = troop.getMorale();
        this.magery = troop.getMagery();
        this.resistance = troop.getResistance();
        this.armor = troop.getArmor();
        this.lifeRegeneration = troop.getLifeRegeneration();
        this.lifeRegenerationTimer = troop.getLifeRegenerationTimer();
        this.mana = troop.getMana();
        this.manaRegeneration = troop.getManaRegeneration();
        this.manaRegenerationTimer = troop.getManaRegenerationTimer();
        this.troopXP = troop.getTroopXP();
        this.spellCastingChance = troop.getSpellCastingChance();
    }

    public void updateResistances(int resistance, int armor) {
        resistances.calculateResistances(resistance, armor);
    }
}
