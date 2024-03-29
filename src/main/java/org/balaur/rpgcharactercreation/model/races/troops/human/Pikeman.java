package org.balaur.rpgcharactercreation.model.races.troops.human;

import org.balaur.rpgcharactercreation.model.races.troops.BaseTroop;

public class Pikeman extends BaseTroop {
    private final int COMBAT_STARTING_VALUE = 9;
    private final int HEALTH_STARTING_VALUE = 75;
    private final int SPEED_STARTING_VALUE = 7;
    private final float MORALE_STARTING_VALUE = 0;
    private final int MAGERY_STARTING_VALUE = 0;
    private final int RESISTANCE_STARTING_VALUE = 0;
    private final int ARMOR_STARTING_VALUE = 6;
    private final int LIFE_REGENERATION_STARTING_VALUE = 1;
    private final float LIFE_REGENERATION_TIMER_STARTING_VALUE = 30;
    private final int MANA_STARTING_VALUE = 0;
    private final int MANA_REGENERATION_STARTING_VALUE = 0;
    private final float MANA_REGENERATION_TIMER_STARTING_VALUE = 0;
    private final int TROOP_XP_STARTING_VALUE = 0;
    private final double SPELL_CASTING_CHANCE_STARTING_VALUE = 0;

    public Pikeman() {
        super.combat = COMBAT_STARTING_VALUE;
        super.health = HEALTH_STARTING_VALUE;
        super.speed = SPEED_STARTING_VALUE;
        super.morale = MORALE_STARTING_VALUE;
        super.magery = MAGERY_STARTING_VALUE;
        super.resistance = RESISTANCE_STARTING_VALUE;
        super.armor = ARMOR_STARTING_VALUE;
        super.lifeRegeneration = LIFE_REGENERATION_STARTING_VALUE;
        super.lifeRegenerationTimer = LIFE_REGENERATION_TIMER_STARTING_VALUE;
        super.mana = MANA_STARTING_VALUE;
        super.manaRegeneration = MANA_REGENERATION_STARTING_VALUE;
        super.manaRegenerationTimer = MANA_REGENERATION_TIMER_STARTING_VALUE;
        super.troopXP = TROOP_XP_STARTING_VALUE;
        super.spellCastingChance = SPELL_CASTING_CHANCE_STARTING_VALUE;
    }
}
