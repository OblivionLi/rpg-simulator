package org.balaur.rpgcharactercreation.model.races.troops;

import lombok.Getter;
import org.balaur.rpgcharactercreation.model.races.statuses.StatusEffectReceiver;
import org.balaur.rpgcharactercreation.util.IllnessType;
import org.balaur.rpgcharactercreation.util.PsycheType;

@Getter
public abstract class BaseTroop implements TroopType, StatusEffectReceiver {
    protected int combat;
    protected int health;
    protected int speed;
    protected int command;
    protected int morale;
    protected int magery;
    protected int resistance;
    protected int training;
    protected int merchant;
    protected int lifeRegeneration;
    protected float lifeRegenerationTimer;
    protected int armor;
    protected int mana;
    protected int manaRegeneration;
    protected float manaRegenerationTimer;
    protected double spellCastingChance;
    protected double discount;
    protected int retinueSlots;
    protected int troopXP;
    protected int viewRange;

    protected boolean isInTower;
    protected boolean canAttack = true;
    protected boolean canReceivePsyches = true;

    @Override
    public void receiveIllness(IllnessType illness) {
        switch (illness) {
            case POISON -> applyPoison();
            case DISEASE -> applyDisease();
        }
    }

    private void applyDisease() {
        int originalLifeRegeneration = lifeRegeneration;
        lifeRegeneration = 0;
        combat /= 2;
        speed /= 2;

        new Thread(() -> {
            int duration = 10 * 60;

            try {
                Thread.sleep(duration * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            combat *= 2;
            speed *= 2;
            lifeRegeneration = originalLifeRegeneration;
        }).start();
    }

    private void applyPoison() {
        int originalLifeRegeneration = lifeRegeneration;
        lifeRegeneration = 0;

        new Thread(() -> {
            int duration = 10 * 60;

            for (int i = 0; i < duration; i++) {
                if (health > 0.12 * health && !isInTower) { // check if the troop HP is above 12% of their max HP
                    health -= 1;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lifeRegeneration = originalLifeRegeneration;
        }).start();
    }

    @Override
    public void receivePsyche(PsycheType psyche) {
        switch (psyche) {
            case FEAR -> applyFear();
            case TERROR -> applyTerror();
            case PASSED_CHECK -> applyPassedCheck();
        }
    }

    private void applyPassedCheck() {
        canReceivePsyches = false;

        new Thread(() -> {
            int duration = 30;

            try {
                Thread.sleep(duration * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            canReceivePsyches = true;
        }).start();
    }

    private void applyTerror() {
        canAttack = false;

        new Thread(() -> {
            int duration = 15;

            try {
                Thread.sleep(duration * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            canAttack = true;
        }).start();
    }

    private void applyFear() {
        combat /= 2;
        speed /= 2;

        new Thread(() -> {
            int duration = 45;

            try {
                Thread.sleep(duration * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            combat *= 2;
            speed *= 2;
        }).start();
    }
}
