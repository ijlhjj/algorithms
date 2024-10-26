package com.sweetmanor.exams.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountRepeatNumberTest {

    @Test
    void getRepeatNumberCount() {
        CountRepeatNumber exam = new CountRepeatNumber();
        assertEquals(12, exam.getRepeatNumberCount(new int[]{0, 1, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 9, 12}, 5));
    }

}
