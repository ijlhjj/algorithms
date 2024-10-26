package com.sweetmanor.exams.twopointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayIntersectionTest {

    @Test
    void getIntersection() {
        ArrayIntersection exam = new ArrayIntersection();
        assertArrayEquals(new int[]{5, 6, 8}, exam.getIntersection(new int[]{2, 5, 6, 8, 9}, new int[]{1, 5, 6, 7, 8}));
    }

}
