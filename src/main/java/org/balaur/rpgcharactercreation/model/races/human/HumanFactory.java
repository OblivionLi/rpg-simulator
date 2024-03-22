package org.balaur.rpgcharactercreation.model.races.human;

import org.balaur.rpgcharactercreation.model.CharacterFactory;
import org.balaur.rpgcharactercreation.model.RPGCharacter;

public class HumanFactory implements CharacterFactory {
    @Override
    public RPGCharacter createCharacter(String name) {
        return new HumanPlayer(name);
    }
}
