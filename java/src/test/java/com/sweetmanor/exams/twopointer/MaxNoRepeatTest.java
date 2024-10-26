package com.sweetmanor.exams.twopointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxNoRepeatTest {

    @Test
    void getSubStringLength() {
        MaxNoRepeat exam = new MaxNoRepeat();
        assertEquals(10, exam.getSubStringLength("abcdefgfabcdertqa"));
    }

}
