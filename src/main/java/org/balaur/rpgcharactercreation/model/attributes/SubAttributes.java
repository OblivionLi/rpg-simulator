package org.balaur.rpgcharactercreation.model.attributes;

import lombok.Getter;
import lombok.Setter;
import org.balaur.rpgcharactercreation.util.AttributesConsts;

@Getter
@Setter
public class SubAttributes {
    // main sub attributes
    private int combat;
    private int health;
    private int speed;
    private int command; // command radius
    private int morale;
    private int magery;
    private int resistance;
    private int training;
    private int merchant;

    // ~ sub-sub attributes that can't be changed directly but indirectly by the main sub attributes
    // for STR specific
    private int lifeRegeneration;
    private int lifeRegenerationTimer; // in seconds

    // for DEX specific
    private int armor;

    // for INT specific
    private int mana;
    private int manaRegeneration;
    private int manaRegenerationTimer;  // in seconds
    private int troopXP;
    private double spellcastingChance; // in percentage

    // for CHA specific
    private double discount;  // in percentage
    private int retinueSlots;

    public SubAttributes() {
    }

    public void increaseStatsOnLevelUp() {
        health += AttributesConsts.INCREMENT_HEALTH_ON_LEVEL_UP;
        mana += AttributesConsts.INCREMENT_MANA_ON_LEVEL_UP;
    }

    public void updateStrengthRelatedAttributes(int strength) {
        calculateCombat(strength);
        // TODO:: implement setDamage(); its more complicated, leave it for later
        calculateHealth(strength);
        calculateLifeRegeneration(strength);
        calculateLifeRegenerationTimer(strength);
    }

    private void calculateLifeRegenerationTimer(int strength) {
        lifeRegenerationTimer -= strength / AttributesConsts.LIFE_REGEN_TIMER_DIVISOR * AttributesConsts.LIFE_REGEN_TIMER_REDUCTION;
    }

    private void calculateHealth(int strength) {
        health += AttributesConsts.HEALTH_STARTING_VALUE + strength * AttributesConsts.HEALTH_MULTIPLIER;
    }

    private void calculateLifeRegeneration(int strength) {
        lifeRegeneration += strength / AttributesConsts.LIFE_REGEN_DIVISOR;
    }

    private void calculateCombat(int strength) {
        combat += AttributesConsts.SUB_ATTRIBUTE_STARTING_VALUE + AttributesConsts.SUB_ATTRIBUTE_STARTING_VALUE + strength / AttributesConsts.COMBAT_DIVISOR;
    }

    public void updateDexterityRelatedAttributes(int dexterity) {
        calculateSpeed(dexterity);
        // TODO:: resistance, need more thought into it, resistance can increase for all damage types
        calculateResistance(dexterity);
        calculateArmor(dexterity);
    }

    private void calculateArmor(int dexterity) {
        armor += dexterity / AttributesConsts.ARMOR_DIVISOR;
    }

    private void calculateResistance(int dexterity) {
        resistance += dexterity / AttributesConsts.RESISTANCE_DIVISOR;
    }

    private void calculateSpeed(int dexterity) {
        speed += AttributesConsts.SUB_ATTRIBUTE_STARTING_VALUE + dexterity / AttributesConsts.SPEED_DIVISOR;
    }

    public void updateIntelligenceRelatedAttributes(int intelligence, int troopXP) {
        calculateMana(intelligence);
        calculateManaRegeneration(intelligence);
        calculateManaRegenerationTimer(intelligence);

        // TODO:: create a static final variable in the character to check if its hero or npc, if its hero dont calculateTroopXP()
        calculateTroopXP(intelligence, troopXP);
        calculateSpellCastingChance(intelligence);
    }

    private void calculateSpellCastingChance(int intelligence) {
        double increase = intelligence * (AttributesConsts.SPELL_CASTING_PERCENTAGE_INCREASE / 100.f);
        spellcastingChance += increase;
    }

    private void calculateTroopXP(int intelligence, int troopXP) {
        this.troopXP += troopXP + (intelligence / AttributesConsts.TROOP_XP_DIVISOR);
    }

    private void calculateManaRegenerationTimer(int intelligence) {
        manaRegenerationTimer -= intelligence / AttributesConsts.MANA_REGEN_TIMER_DIVISOR * AttributesConsts.MANA_REGEN_TIMER_REDUCTION;
    }

    private void calculateManaRegeneration(int intelligence) {
        manaRegeneration += intelligence / AttributesConsts.MANA_REGEN_DIVISOR;
    }

    private void calculateMana(int intelligence) {
        mana += intelligence * AttributesConsts.MANA_MULTIPLIER;
    }

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
                "Troop XP: " + troopXP + "\n" +
                "Spell Casting Chance: " + spellcastingChance + "\n" +
                "Discount: " + discount + "\n" +
                "Retinue Slots: " + retinueSlots;
    }
}
