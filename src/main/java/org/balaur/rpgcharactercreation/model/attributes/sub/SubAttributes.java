package org.balaur.rpgcharactercreation.model.attributes.sub;

import lombok.Getter;
import lombok.Setter;
import org.balaur.rpgcharactercreation.model.attributes.resistances.Resistances;
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
    private float lifeRegenerationTimer; // in seconds

    // for DEX specific
    private int armor;

    // for INT specific
    private int mana;
    private int manaRegeneration;
    private float manaRegenerationTimer;  // in seconds
    private int troopXP;
    private double spellCastingChance; // in percentage

    // for CHA specific
    private double discount;  // in percentage
    private int retinueSlots;

    private Resistances resistances = new Resistances();

    public SubAttributes() {
    }

    private void initializePlayerStartingValues() {
        combat = AttributesConsts.SUB_ATTRIBUTE_STARTING_VALUE;
        health = AttributesConsts.HEALTH_STARTING_VALUE;
        lifeRegenerationTimer = AttributesConsts.LIFE_REGEN_TIMER_STARTING_VALUE;
        mana = AttributesConsts.MANA_STARTING_VALUE;
        manaRegenerationTimer = AttributesConsts.MANA_REGEN_TIMER_STARTING_VALUE;
    }

    private void initializeNPCStartingValues() {
    }

    public void updateResistances(int resistance, int armor) {
        resistances.calculateResistances(resistance, armor);
    }

    public void increaseStatsOnLevelUp(int levels) {
        while (levels-- != 0) {
            health += AttributesConsts.INCREMENT_HEALTH_ON_LEVEL_UP;
            mana += AttributesConsts.INCREMENT_MANA_ON_LEVEL_UP;
        }
    }

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
        speed += AttributesConsts.SUB_ATTRIBUTE_STARTING_VALUE + dexterity / AttributesConsts.SPEED_DIVISOR;
    }

    public void updateIntelligenceRelatedAttributes(int intelligence, int troopXP) {
        calculateMana(intelligence);
        calculateManaRegeneration(intelligence);
        calculateManaRegenerationTimer(intelligence);
        calculateTroopXP(intelligence, troopXP);
        calculateSpellCastingChance(intelligence);
    }

    private void calculateSpellCastingChance(int intelligence) {
        double increase = intelligence * (AttributesConsts.SPELL_CASTING_PERCENTAGE_INCREASE / 100.f);
        spellCastingChance += increase;
    }

    private void calculateTroopXP(int intelligence, int troopXP) {
        if (troopXP == 0) {
            return;
        }

        this.troopXP += troopXP + (intelligence / AttributesConsts.TROOP_XP_DIVISOR);
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

    public String displayNPCSubAttributes() {
        return "Health: " + health + "\n" +
                "Combat: " + combat + "\n" +
                "Speed: " + speed + "\n" +
                "Resistance: " + resistance + "\n" +
                "Life Regeneration: " + lifeRegeneration + "\n" +
                "Life Regeneration Timer: " + lifeRegenerationTimer + "\n" +
                "Armor: " + armor + "\n" +
                "Mana: " + mana + "\n" +
                "Mana Regeneration: " + manaRegeneration + "\n" +
                "Mana Regeneration Timer: " + manaRegenerationTimer + "\n" +
                "Troop XP: " + troopXP + "\n" +
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
