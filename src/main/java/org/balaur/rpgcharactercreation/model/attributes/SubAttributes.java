package org.balaur.rpgcharactercreation.model.attributes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubAttributes {
    private int combat;
    private int health;
    private int speed;
    private int command;
    private int morale;
    private int magery;
    private int resistance;
    private int training;
    private int merchant;

    public SubAttributes() {
        combat = combat;
        health = health;
        speed = speed;
        command = command;
        morale = morale;
        magery = magery;
        resistance = resistance;
        training = training;
        merchant = merchant;
    }
}
