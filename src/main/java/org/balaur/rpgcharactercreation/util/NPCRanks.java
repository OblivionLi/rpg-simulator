package org.balaur.rpgcharactercreation.util;

public enum NPCRanks {
    // ORDER MATTERS
    RECRUIT,
    ROOKIE,
    EXPERIENCED,
    VETERAN;

    public static NPCRanks fromString(String rank) {
        for (NPCRanks type : NPCRanks.values()) {
            if (type.toString().equalsIgnoreCase(rank)) {
                return type;
            }
        }

        return null;
    }

    public static int getPointsBasedOnRank(NPCRanks rank) {
        return switch (rank) {
            case RECRUIT -> 0;
            case ROOKIE -> 1;
            case EXPERIENCED -> 2;
            case VETERAN -> 4;
        };
    }

    public static NPCRanks getRankBasedOnExperience(int experience) {
        if (experience >= 70 && experience < AttributesConsts.NPC_MAX_EXP) {
            return NPCRanks.EXPERIENCED;
        }

        if (experience >= 40 && experience < 70) {
            return NPCRanks.ROOKIE;
        }

        if (experience < 40) {
            return NPCRanks.RECRUIT;
        }

        return NPCRanks.VETERAN;
    }
}
