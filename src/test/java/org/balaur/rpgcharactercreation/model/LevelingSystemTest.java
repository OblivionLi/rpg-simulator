package org.balaur.rpgcharactercreation.model;

import org.balaur.rpgcharactercreation.model.leveling.LevelingSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelingSystemTest {

    @Test
    void InitializeLevelingSystem_Success() {
        LevelingSystem ls = new LevelingSystem();

        assertNotNull(ls);
        assertEquals(1, ls.getLevel());
        assertEquals(0, ls.getLevelPoints());
        assertEquals(0, ls.getCurrentExperience());
        assertEquals(10, ls.getExperienceRequired());
    }

    @Test
    void ShouldLevelUp_LevelUp1Level_Success() {
        LevelingSystem ls = new LevelingSystem();

        boolean shouldLevelUp = ls.shouldLevelUp(10);
        assertTrue(shouldLevelUp);

        System.out.println("\n~ShouldLevelUp_LevelUp1Level_Success~\nBefore leveling up:");
        ls.display();

        ls.levelUp(0);

        assertEquals(2, ls.getLevel());
        assertEquals(0, ls.getLevelPoints());
        assertEquals(0, ls.getCurrentExperience());
        assertEquals(20, ls.getExperienceRequired());

        System.out.println("\nAfter leveling up:");
        ls.display();
    }

    @Test
    void ShouldLevelUp_LevelUp20Level_Success() {
        LevelingSystem ls = new LevelingSystem();

        assertEquals(1, ls.getLevel());
        assertEquals(0, ls.getLevelPoints());
        assertEquals(0, ls.getCurrentExperience());
        assertEquals(10, ls.getExperienceRequired());
        assertEquals(0, ls.getAccumulatedExperience());

        boolean shouldLevelUp = ls.shouldLevelUp(150);
        assertTrue(shouldLevelUp);

        System.out.println("\n~ShouldLevelUp_LevelUp20Level_Success~\nBefore leveling up:");
        ls.display();

        ls.levelUp(0);

        assertEquals(5, ls.getLevel());
        assertEquals(11, ls.getLevelPoints());
        assertEquals(0, ls.getCurrentExperience());
        assertEquals(120, ls.getExperienceRequired());
        assertEquals(150, ls.getAccumulatedExperience());

        System.out.println("\nAfter leveling up:");
        ls.display();
    }
}