package org.balaur.rpgcharactercreation.util;

public enum PsycheType {
    FEAR,
    TERROR,
    PASSED_CHECK;

    public static PsycheType fromString(String psyche) {
        for (PsycheType type : PsycheType.values()) {
            if (type.toString().equalsIgnoreCase(psyche)) {
                return type;
            }
        }

        return null;
    }
}
