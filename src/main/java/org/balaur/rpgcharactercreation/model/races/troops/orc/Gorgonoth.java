package org.balaur.rpgcharactercreation.model.races.troops.orc;

import org.balaur.rpgcharactercreation.model.races.troops.BaseTroop;

public class Gorgonoth extends BaseTroop {
    private final int COMBAT_STARTING_VALUE = 8;
    private final int HEALTH_STARTING_VALUE = 60;
    private final int SPEED_STARTING_VALUE = 9;
    private final int MORALE_STARTING_VALUE = 0;
    private final int COMMAND_STARTING_VALUE = 0;
    private final int MAGERY_STARTING_VALUE = 0;
    private final int RESISTANCE_STARTING_VALUE = 0;
    private final int ARMOR_STARTING_VALUE = 5;
    private final int LIFE_REGENERATION_STARTING_VALUE = 2;
    private final float LIFE_REGENERATION_TIMER_STARTING_VALUE = 30;
    private final int MANA_STARTING_VALUE = 0;
    private final int MANA_REGENERATION_STARTING_VALUE = 0;
    private final float MANA_REGENERATION_TIMER_STARTING_VALUE = 0;
    private final int TROOP_XP_STARTING_VALUE = 0;
    private final double SPELL_CASTING_CHANCE_STARTING_VALUE = 0;
    private final int DISCOUNT_STARTING_VALUE = 0;
    private final int RETINUE_SLOTS_STARTING_VALUE = 0;
    private final int TRAINING_STARTING_VALUE = 0;
    private final int MERCHANT_STARTING_VALUE = 0;
    private final int VIEW_RANGE = 9;

    public Gorgonoth() {
        super.combat = COMBAT_STARTING_VALUE;
        super.health = HEALTH_STARTING_VALUE;
        super.speed = SPEED_STARTING_VALUE;
        super.morale = MORALE_STARTING_VALUE;
        super.command = COMMAND_STARTING_VALUE;
        super.magery = MAGERY_STARTING_VALUE;
        super.resistance = RESISTANCE_STARTING_VALUE;
        super.armor = ARMOR_STARTING_VALUE;
        super.training = TRAINING_STARTING_VALUE;
        super.merchant = MERCHANT_STARTING_VALUE;
        super.lifeRegeneration = LIFE_REGENERATION_STARTING_VALUE;
        super.lifeRegenerationTimer = LIFE_REGENERATION_TIMER_STARTING_VALUE;
        super.mana = MANA_STARTING_VALUE;
        super.manaRegeneration = MANA_REGENERATION_STARTING_VALUE;
        super.manaRegenerationTimer = MANA_REGENERATION_TIMER_STARTING_VALUE;
        super.troopXP = TROOP_XP_STARTING_VALUE;
        super.spellCastingChance = SPELL_CASTING_CHANCE_STARTING_VALUE;
        super.discount = DISCOUNT_STARTING_VALUE;
        super.retinueSlots = RETINUE_SLOTS_STARTING_VALUE;
        super.viewRange = VIEW_RANGE;
    }
}
