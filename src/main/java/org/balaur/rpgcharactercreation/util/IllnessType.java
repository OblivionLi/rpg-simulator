package org.balaur.rpgcharactercreation.util;

public enum IllnessType {
    POISON,
    DISEASE;

    public static IllnessType fromString(String illness) {
        for (IllnessType type : IllnessType.values()) {
            if (type.toString().equalsIgnoreCase(illness)) {
                return type;
            }
        }

        return null;
    }
}
