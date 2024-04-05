package org.balaur.rpgcharactercreation.model;

import lombok.Getter;

@Getter
public class CharacterEffects {
    private boolean isStunned;
    private boolean isBurning;
    private boolean isFrozen;
    private boolean isPoisoned;
    private boolean isDiseased;

    public CharacterEffects(boolean isStunned, boolean isBurning, boolean isFrozen, boolean isPoisoned, boolean isDiseased) {
        this.isStunned = isStunned;
        this.isBurning = isBurning;
        this.isFrozen = isFrozen;
        this.isPoisoned = isPoisoned;
        this.isDiseased = isDiseased;
    }
}
