package org.balaur.rpgcharactercreation.util.races.human;

import org.balaur.rpgcharactercreation.model.races.NPCRaceType;

public enum HumanRaceTypeNPCs implements NPCRaceType {
    // GROUND ARMY
    PEASANT, // the only Human npc that can build; besides the hero
    PIKEMAN,
    ARCHER,
    MERCENARY_SWORDSMAN, // foot soldier
    KNIGHT, // soldier with big sword
    MERCENARY_CAVALRY,
    LORD_CAVALRY,
    ROYAL_SWORDSMAN, // the most elite in the human army

    // SIEGE ARMY
    BATTERING_RAM,
    BOMBARD,
    BALLISTA,

    // FLYING ARMY
    EAGLE,
    PEGASUS,
    DRAGON,

    // TITAN
    PYROLYNTHIAN; // name of the human titan

    public static boolean canNPCAttackAir(HumanRaceTypeNPCs npc) {
        return switch (npc) {
            case PEASANT, PIKEMAN, MERCENARY_SWORDSMAN, KNIGHT, MERCENARY_CAVALRY, LORD_CAVALRY, ROYAL_SWORDSMAN,
                 BATTERING_RAM -> false;

            case BOMBARD, BALLISTA, EAGLE, PEGASUS, DRAGON, PYROLYNTHIAN, ARCHER -> true;
        };

    }
}
