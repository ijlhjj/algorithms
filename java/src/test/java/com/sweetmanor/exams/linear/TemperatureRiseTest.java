package com.sweetmanor.exams.linear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TemperatureRiseTest {

    TemperatureRise exam = new TemperatureRise();

    @Test
    void dailyTemperatures1() {
        int[] temperatures = new int[]{23, 24, 25, 21, 19, 22, 26, 23};
        int[] ans = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(ans, exam.dailyTemperatures(temperatures));
    }

    @Test
    void dailyTemperatures2() {
        int[] temperatures = new int[]{18, 19, 10, 21, 27, 18, 26, 31};
        int[] ans = new int[]{1, 2, 1, 1, 3, 1, 1, 0};
        assertArrayEquals(ans, exam.dailyTemperatures(temperatures));
    }

}
