package org.balaur.rpgcharactercreation.model.races.factory;

import org.balaur.rpgcharactercreation.model.races.NPCTroop;

public class NPCTroopFactory {
    public NPCTroop createNPCTroop(NPCTroop.Builder builder) {
        return builder.build();
    }
}
