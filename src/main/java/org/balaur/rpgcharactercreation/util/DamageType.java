package org.balaur.rpgcharactercreation.util;

public enum DamageType {
    // normal damage
    SLASHING,
    CRUSHING,
    PIERCING,

    // elemental damage
    FIRE,
    COLD,
    ELECTRIC,

    MAGIC;

    public static DamageType fromString(String damageType) {
        for (DamageType type : DamageType.values()) {
            if (type.toString().equalsIgnoreCase(damageType)) {
                return type;
            }
        }

        return null;
    }
}
