package com.sweetmanor.exams.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SearchRepeatTest {

    @Test
    void purge() {
        SearchRepeat exam = new SearchRepeat();
        assertArrayEquals(new int[]{1, 3, 5, 2, 6, 8}, exam.purge(new int[]{1, 1, 3, 5, 2, 3, 1, 5, 6, 8}));
    }

}
