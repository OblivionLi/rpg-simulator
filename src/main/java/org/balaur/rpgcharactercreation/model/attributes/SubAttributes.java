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

    public SubAttributes(int combat, int health, int speed, int command, int morale, int magery, int resistance, int training, int merchant) {
        this.combat = combat;
        this.health = health;
        this.speed = speed;
        this.command = command;
        this.morale = morale;
        this.magery = magery;
        this.resistance = resistance;
        this.training = training;
        this.merchant = merchant;
    }
}
