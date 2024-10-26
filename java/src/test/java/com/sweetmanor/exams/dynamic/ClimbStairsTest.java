package com.sweetmanor.exams.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbStairsTest {

    @Test
    void getClimbWays() {
        ClimbStairs exam = new ClimbStairs();
        assertEquals(89, exam.getClimbWays(10));
    }

}
