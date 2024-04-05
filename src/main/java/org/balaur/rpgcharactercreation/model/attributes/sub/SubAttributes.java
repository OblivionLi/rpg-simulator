package org.balaur.rpgcharactercreation.model.attributes.sub;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.attributes.resistances.Resistances;
import org.balaur.rpgcharactercreation.model.races.troops.TroopType;
import org.balaur.rpgcharactercreation.util.AttributesConsts;

@Getter
public class SubAttributes implements SubAttributesType {
    private int combat;
    private int health;
    private int speed;
    private int command;
    private int morale;
    private int magery;
    private int resistance;
    private int training;
    private int merchant;
    private int troopXP;
    private int lifeRegeneration;
    private float lifeRegenerationTimer;
    private int armor;
    private int mana;
    private int manaRegeneration;
    private float manaRegenerationTimer;
    private double spellCastingChance;
    private double discount;
    private int retinueSlots;
    private int viewRange;

    private Resistances resistances = new Resistances();

    public SubAttributes(TroopType troop) {
        combat = troop.getCombat();
        health = troop.getHealth();
        speed = troop.getSpeed();
        command = troop.getCommand();
        morale = troop.getMorale();
        magery = troop.getMagery();
        resistance = troop.getResistance();
        training = troop.getTraining();
        merchant = troop.getMerchant();
        lifeRegeneration = troop.getLifeRegeneration();
        lifeRegenerationTimer = troop.getLifeRegenerationTimer();
        armor = troop.getArmor();
        mana = troop.getMana();
        manaRegeneration = troop.getManaRegeneration();
        manaRegenerationTimer = troop.getManaRegenerationTimer();
        spellCastingChance = troop.getSpellCastingChance();
        discount = troop.getDiscount();
        retinueSlots = troop.getRetinueSlots();
        viewRange = troop.getViewRange();
    }

    @Override
    public void reduceHealth(int damage) {
        if (health - damage < 0) {
            health = 0;
            return;
        }

        health -= damage;
    }

    @Override
    public void updateResistances() {
        resistances.calculateResistances(resistance, armor);
    }

    @Override
    public void increaseStatsOnLevelUp(int levels) {
        while (levels-- != 0) {
            health += AttributesConsts.INCREMENT_HEALTH_ON_LEVEL_UP;
            mana += AttributesConsts.INCREMENT_MANA_ON_LEVEL_UP;
        }
    }

    @Override
    public void updateStrengthRelatedAttributes(int strength) {
        calculateCombat(strength);
        // TODO:: implement setDamage(); its more complicated, leave it for later
        calculateHealth(strength);
        calculateLifeRegeneration(strength);
        calculateLifeRegenerationTimer(strength);
    }

    private void calculateLifeRegenerationTimer(int strength) {
        lifeRegenerationTimer -= (float) strength / AttributesConsts.LIFE_REGEN_TIMER_DIVISOR * AttributesConsts.LIFE_REGEN_TIMER_REDUCTION;
    }

    private void calculateHealth(int strength) {
        health += strength * AttributesConsts.HEALTH_MULTIPLIER;
    }

    private void calculateLifeRegeneration(int strength) {
        lifeRegeneration += strength / AttributesConsts.LIFE_REGEN_DIVISOR;
    }

    private void calculateCombat(int strength) {
        combat += strength / AttributesConsts.COMBAT_DIVISOR;
    }

    @Override
    public void updateDexterityRelatedAttributes(int dexterity) {
        calculateSpeed(dexterity);
        calculateResistance(dexterity);
        calculateArmor(dexterity);

        resistances.calculateResistances(resistance, armor);
    }

    private void calculateArmor(int dexterity) {
        armor += dexterity / AttributesConsts.ARMOR_DIVISOR;
    }

    private void calculateResistance(int dexterity) {
        resistance += dexterity / AttributesConsts.RESISTANCE_DIVISOR;
    }

    private void calculateSpeed(int dexterity) {
        speed += dexterity / AttributesConsts.SPEED_DIVISOR;
    }

    @Override
    public void updateIntelligenceRelatedAttributes(int intelligence) {
        calculateMana(intelligence);
        calculateManaRegeneration(intelligence);
        calculateManaRegenerationTimer(intelligence);
        calculateSpellCastingChance(intelligence);
    }

    private void calculateSpellCastingChance(int intelligence) {
        double increase = intelligence * (AttributesConsts.SPELL_CASTING_PERCENTAGE_INCREASE / 100.f);
        spellCastingChance += increase;
    }

    private void calculateManaRegenerationTimer(int intelligence) {
        manaRegenerationTimer -= (float) intelligence / AttributesConsts.MANA_REGEN_TIMER_DIVISOR * AttributesConsts.MANA_REGEN_TIMER_REDUCTION;
    }

    private void calculateManaRegeneration(int intelligence) {
        manaRegeneration += intelligence / AttributesConsts.MANA_REGEN_DIVISOR;
    }

    private void calculateMana(int intelligence) {
        mana += intelligence * AttributesConsts.MANA_MULTIPLIER;
    }

    @Override
    public void updateCharismaRelatedAttributes(int charisma) {
        calculateCommandRadius(charisma);
        calculateMorale(charisma);
        calculateDiscount(charisma);
        calculateRetinueSlots(charisma);
    }

    private void calculateRetinueSlots(int charisma) {
        retinueSlots += charisma / AttributesConsts.RETINUE_SLOT_DIVISOR;
    }

    private void calculateDiscount(int charisma) {
        if (charisma < 6) {
            discount = 0;
            return;
        }

        double increase = charisma * (AttributesConsts.DISCOUNT_PERCENTAGE_INCREASE / 100.f);
        discount += increase;
    }

    private void calculateMorale(int charisma) {
        morale += charisma / AttributesConsts.MORALE_DIVISOR;
    }

    private void calculateCommandRadius(int charisma) {
        command += charisma / AttributesConsts.COMMAND_RADIUS_DIVISOR;
    }

    public SubAttributes display() {
        return this;
    }

    @Override
    public String displaySubAttributes() {
        return "Health: " + health + "\n" +
                "Combat: " + combat + "\n" +
                "Speed: " + speed + "\n" +
                "Command: " + command + "\n" +
                "Morale: " + morale + "\n" +
                "Magery: " + magery + "\n" +
                "Resistance: " + resistance + "\n" +
                "Training: " + training + "\n" +
                "Merchant: " + merchant + "\n" +
                "Life Regeneration: " + lifeRegeneration + "\n" +
                "Life Regeneration Timer: " + lifeRegenerationTimer + "\n" +
                "Armor: " + armor + "\n" +
                "Mana: " + mana + "\n" +
                "Mana Regeneration: " + manaRegeneration + "\n" +
                "Mana Regeneration Timer: " + manaRegenerationTimer + "\n" +
                "Spell Casting Chance: " + spellCastingChance + "\n" +
                "Discount: " + discount + "\n" +
                "Retinue Slots: " + retinueSlots +
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
