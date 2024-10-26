package com.sweetmanor.exams.twopointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinLengthRangeTest {

    @Test
    void getMinSubArray() {
        MinLengthRange exam = new MinLengthRange();
        assertArrayEquals(new int[]{4, 6}, exam.getMinSubArray(new int[]{2, 3, 1, 2, 4, 3}, 7));
    }

}
