package org.balaur.rpgcharactercreation.model.races.factory;

import org.balaur.rpgcharactercreation.model.races.troops.NPCTroop;

public class NPCTroopFactory {
    public NPCTroop createNPCTroop(NPCTroop.Builder builder) {
        return builder.build();
    }
}
