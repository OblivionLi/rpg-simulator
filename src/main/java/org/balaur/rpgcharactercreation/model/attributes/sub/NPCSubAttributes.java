package org.balaur.rpgcharactercreation.model.attributes.sub;

import org.balaur.rpgcharactercreation.model.attributes.resistances.Resistances;
import org.balaur.rpgcharactercreation.model.races.troops.TroopType;

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
        combat = troop.getCombat();
        health = troop.getHealth();
        speed = troop.getSpeed();
        morale = troop.getMorale();
        magery = troop.getMagery();
        resistance = troop.getResistance();
        armor = troop.getArmor();
        lifeRegeneration = troop.getLifeRegeneration();
        lifeRegenerationTimer = troop.getLifeRegenerationTimer();
        mana = troop.getMana();
        manaRegeneration = troop.getManaRegeneration();
        manaRegenerationTimer = troop.getManaRegenerationTimer();
        troopXP = troop.getTroopXP();
        spellCastingChance = troop.getSpellCastingChance();
    }

    @Override
    public void updateResistances() {
        resistances.calculateResistances(resistance, armor);
    }

    @Override
    public void increaseStatsOnLevelUp(int levels) {

    }

    @Override
    public void updateStrengthRelatedAttributes(int strength) {

    }

    @Override
    public void updateDexterityRelatedAttributes(int dexterity) {

    }

    @Override
    public void updateIntelligenceRelatedAttributes(int intelligence) {

    }

    @Override
    public void updateCharismaRelatedAttributes(int charisma) {

    }

    @Override
    public String displaySubAttributes() {
        return "Health: " + health + "\n" +
                "Combat: " + combat + "\n" +
                "Speed: " + speed + "\n" +
                "Morale: " + morale + "\n" +
                "Magery: " + magery + "\n" +
                "Resistance: " + resistance + "\n" +
                "Life Regeneration: " + lifeRegeneration + "\n" +
                "Life Regeneration Timer: " + lifeRegenerationTimer + "\n" +
                "Armor: " + armor + "\n" +
                "Mana: " + mana + "\n" +
                "Mana Regeneration: " + manaRegeneration + "\n" +
                "Mana Regeneration Timer: " + manaRegenerationTimer + "\n" +
                "Spell Casting Chance: " + spellCastingChance + "\n" +
                "\n------------------------------------\n" +
                "Crushing resistance: " + resistances.getResistanceToCrushing() + "\n" +
                "Piercing resistance: " + resistances.getResistanceToPiercing() + "\n" +
                "Slashing resistance: " + resistances.getResistanceToSlashing() + "\n" +
                "Cold resistance: " + resistances.getResistanceToCold() + "\n" +
                "Fire resistance: " + resistances.getResistanceToFire() + "\n" +
                "Electric resistance: " + resistances.getResistanceToElectric() + "\n" +
                "Magic resistance: " + resistances.getResistanceToMagic();
    }
}
