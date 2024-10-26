package com.sweetmanor.exams.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigGoldMinesTest {

    DigGoldMines exam = new DigGoldMines();

    @Test
    void getMostGold1() {
        assertEquals(900, exam.getMostGold1(new int[]{5, 5, 3, 4, 3}, new int[]{400, 500, 200, 300, 350}, 5, 10));
    }

    @Test
    void getMostGold2() {
        assertEquals(900, exam.getMostGold2(new int[]{5, 5, 3, 4, 3}, new int[]{400, 500, 200, 300, 350}, 5, 10));
    }

}
