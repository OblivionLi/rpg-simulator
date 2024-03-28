package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.races.PlayerHero;

public interface CharacterFactory {
    RPGCharacter createCharacter(PlayerHero.Builder builder);
}
