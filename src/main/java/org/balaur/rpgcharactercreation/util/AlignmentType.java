package org.balaur.rpgcharactercreation.util;

public enum AlignmentType {
    GOOD,
    EVIL,
    NEUTRAL;

    public static AlignmentType fromString(String alignmentType) {
        for (AlignmentType type : AlignmentType.values()) {
            if (type.toString().equalsIgnoreCase(alignmentType)) {
                return type;
            }
        }

        return null;
    }
}
