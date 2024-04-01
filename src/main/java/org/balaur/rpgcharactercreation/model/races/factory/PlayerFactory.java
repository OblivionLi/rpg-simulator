package org.balaur.rpgcharactercreation.model.races.factory;

import org.balaur.rpgcharactercreation.model.races.PlayerHero;
import org.balaur.rpgcharactercreation.model.races.player.human.HumanPlayer;
import org.balaur.rpgcharactercreation.util.AttributesStartingValues;

public class PlayerFactory {
    public PlayerHero createPlayerHero(String race, PlayerHero.Builder builder) {
        switch (race.toLowerCase()) {
            case "human" -> builder.withStrength(AttributesStartingValues.HUMAN_STR_STARTING_VALUE)
                    .withDexterity(AttributesStartingValues.HUMAN_DEX_STARTING_VALUE)
                    .withIntelligence(AttributesStartingValues.HUMAN_INT_STARTING_VALUE)
                    .withCharisma(AttributesStartingValues.HUMAN_CHA_STARTING_VALUE)
                    .withPlayerType(new HumanPlayer());
            case "orc" -> builder.withStrength(AttributesStartingValues.ORC_STR_STARTING_VALUE)
                    .withDexterity(AttributesStartingValues.ORC_DEX_STARTING_VALUE)
                    .withIntelligence(AttributesStartingValues.ORC_INT_STARTING_VALUE)
                    .withCharisma(AttributesStartingValues.ORC_CHA_STARTING_VALUE);
//                    .withPlayerType(new OrcPlayer);
            default -> throw new IllegalArgumentException("Unknown race: " + race);
        }

        return builder.build();
    }
}
