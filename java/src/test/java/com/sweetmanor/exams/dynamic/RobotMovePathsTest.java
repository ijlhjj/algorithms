package com.sweetmanor.exams.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotMovePathsTest {

    RobotMovePaths exam = new RobotMovePaths();

    @Test
    void getPathsNumber1() {
        assertEquals(252, exam.getPathsNumber1(0, 0, 5, 5));
    }

    @Test
    void getPathsNumber2() {
        assertEquals(252, exam.getPathsNumber2(5, 5));
    }

}
