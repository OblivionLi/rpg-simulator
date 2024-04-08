package org.balaur.rpgcharactercreation.model.races.statuses;

import org.balaur.rpgcharactercreation.model.races.troops.BaseTroop;
import org.balaur.rpgcharactercreation.util.IllnessType;
import org.balaur.rpgcharactercreation.util.PsycheType;

public interface StatusEffectApplier {
    void inflictIllness(BaseTroop troop, IllnessType illness);
    void inflictPsyche(BaseTroop troop, PsycheType psyche);
}
