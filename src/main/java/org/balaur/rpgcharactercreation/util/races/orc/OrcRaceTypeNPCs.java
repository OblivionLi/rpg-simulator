package org.balaur.rpgcharactercreation.util.races.orc;

public enum OrcRaceTypeNPCs {
    // GROUND ARMY
    SLAVE, // the only Orc npc that can build; besides the hero
    AXETHROWER,
    BERSERKER, // foot soldier
    SHAMAN, // magic user
    WARG_RIDER,
    TROLL, // heavy infantry
    OGRE, // very heavy infantry
    WARLORD, // soldier with big axe
    CHIEFTAIN,
    ELITE_BERSERKER, // the most elite in the orc army
    GOBLIN_SCOUT, // fast and agile unit
    WITCH_DOCTOR, // healer unit
    BLACK_ORC, // heavily armored unit

    // SIEGE ARMY
    SIEGE_TOWER,
    CATAPULT,
    TREBUCHET,

    // FLYING ARMY
    WYVERN,
    FROST_WYVERN,
    FIRE_DRAGON,

    // TITAN
    GORGONOTH; // name of the orc titan


    public static boolean canNPCAttackAir(OrcRaceTypeNPCs npc) {
        return switch (npc) {
            case SLAVE, BERSERKER, SHAMAN, WARG_RIDER, TROLL, OGRE, WARLORD, CHIEFTAIN, ELITE_BERSERKER,
                 SIEGE_TOWER, GOBLIN_SCOUT, WITCH_DOCTOR, BLACK_ORC -> false;

            case CATAPULT, TREBUCHET, WYVERN, FROST_WYVERN, FIRE_DRAGON, GORGONOTH, AXETHROWER -> true;
        };
    }
}
