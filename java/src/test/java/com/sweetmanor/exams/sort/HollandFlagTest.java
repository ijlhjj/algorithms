package com.sweetmanor.exams.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HollandFlagTest {

    @Test
    void arrangeHollandFlag() {
        HollandFlag exam = new HollandFlag();
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, exam.arrangeHollandFlag(new int[]{1, 2, 1, 0, 2, 1, 0, 1, 2, 2, 0, 0, 0, 1, 2}));
    }

}
