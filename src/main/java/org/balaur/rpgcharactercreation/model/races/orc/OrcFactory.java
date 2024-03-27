package org.balaur.rpgcharactercreation.model.races.orc;

import org.balaur.rpgcharactercreation.model.CharacterFactory;
import org.balaur.rpgcharactercreation.model.RPGCharacter;

public class OrcFactory implements CharacterFactory {
    @Override
    public RPGCharacter createCharacter(String name) {
        return new OrcPlayer(name);
    }
}
