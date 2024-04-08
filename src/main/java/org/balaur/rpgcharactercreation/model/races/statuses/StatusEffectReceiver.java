package org.balaur.rpgcharactercreation.model.races.statuses;

import org.balaur.rpgcharactercreation.util.IllnessType;
import org.balaur.rpgcharactercreation.util.PsycheType;

public interface StatusEffectReceiver {
    void receiveIllness(IllnessType illness);
    void receivePsyche(PsycheType psyche);
}
