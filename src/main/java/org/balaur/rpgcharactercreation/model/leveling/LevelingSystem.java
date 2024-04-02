package org.balaur.rpgcharactercreation.model.leveling;

import lombok.Getter;
import org.balaur.rpgcharactercreation.util.NPCRanks;

@Getter
public class LevelingSystem {
    private int level; // current level
    private int levelPoints; // points to allocated in main/sub attributes, magery etc..
    private int currentExperience; // current exp points
    private int accumulatedExperience; // total exp gained
    private int experienceRequired; // exp points required for next level

    public LevelingSystem() {
        level = 1;
        levelPoints = 0;
        currentExperience = 0;
        experienceRequired = getNextLevelExperience(2);
    }

    public boolean shouldLevelUp(int gainedExperience) {
        currentExperience += gainedExperience;
        accumulatedExperience += gainedExperience;
        return currentExperience >= experienceRequired;
    }

    public void levelUp(int trainingSkill) {
        while (experienceRequired <= currentExperience) {
            level++;
            currentExperience -= experienceRequired;
            experienceRequired = getRequiredExperience();
            levelPoints += getCurrentLevelPoints(trainingSkill);
        }
    }

    public void display() {
        System.out.printf("Level: %d\nLevel Points: %d\nCurrent exp: %d\nExp required: %d\nTotal exp accumulated: %d\n", level, levelPoints, currentExperience, experienceRequired, accumulatedExperience);
    }

    private int getRequiredExperience() {
        if (level <= 0) {
            throw new IllegalArgumentException("Level must be greater than 0. Stop cheating.");
        }

        int totalExperience = 0;
        for (int i = 1; i <= level; i++) {
            totalExperience += getNextLevelExperience(i);
        }

        return totalExperience;
    }

    private int getCurrentLevelPoints(int trainingSkill) {
        int additionalPoints = getAdditionalLevelPoints(trainingSkill);
        return getPoints() + additionalPoints;
    }

    private int getAdditionalLevelPoints(int trainingSkill) {
        if (trainingSkill >= 91) {
            return 7;
        }

        if (trainingSkill >= 61) {
            return 5;
        }

        if (trainingSkill >= 41) {
            return 4;
        }

        if (trainingSkill >= 25) {
            return 3;
        }

        if (trainingSkill >= 19) {
            return 2;
        }

        if (trainingSkill >= 13) {
            return 1;
        }


        return 0;
    }

    private int getNextLevelExperience(int level) {
        return switch (level) {
            case 1, 2 -> 10;
            case 3 -> 20;
            case 4, 5 -> 40;
            case 6 -> 60;
            case 7, 8 -> 70;
            case 9 -> 80;
            case 10, 11 -> 100;
            case 12, 13 -> 120;
            case 14, 15 -> 130;
            case 16, 17 -> 150;
            case 18, 19, 20 -> 200;
            case 21, 22, 23, 24 -> 250;
            case 25, 26, 27, 28, 29, 30 -> 400;
            default -> 500;
        };
    }

    private int getPoints() {
        return switch (level) {
            case 1, 2, 3 -> 0;
            case 4 -> 5;
            case 5 -> 6;
            case 6, 7 -> 7;
            case 8, 9 -> 8;
            case 10, 11, 12 -> 9;
            case 13, 14, 15 -> 10;
            case 16 -> 11;
            case 17 -> 12;
            case 18 -> 13;
            case 19 -> 14;
            default -> 15;
        };
    }

    public int getNPCAttributesPointsAmount(int experience) {
        if (experience <= 0) {
            return 0;
        }

        currentExperience += experience;
        NPCRanks rank = NPCRanks.getRankBasedOnExperience(currentExperience);

        return NPCRanks.getPointsBasedOnRank(rank);
    }

    public int getNPCExperienceRequired() {
        NPCRanks rank = NPCRanks.getRankBasedOnExperience(currentExperience);

        return experienceRequired = NPCRanks.getRequiredExperienceForLevelUp(currentExperience, rank);
    }
}
