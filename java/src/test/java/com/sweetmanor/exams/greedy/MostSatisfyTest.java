package com.sweetmanor.exams.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MostSatisfyTest {

    @Test
    void getContentedChildren() {
        MostSatisfy exam = new MostSatisfy();
        assertEquals(2, exam.getContentedChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

}
