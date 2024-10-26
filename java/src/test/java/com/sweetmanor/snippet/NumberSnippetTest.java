package com.sweetmanor.snippet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumberSnippetTest {

    @Test
    void getDigits() {
        assertArrayEquals(new int[]{0}, NumberSnippet.getDigits(0));
        assertArrayEquals(new int[]{1}, NumberSnippet.getDigits(1));
        assertArrayEquals(new int[]{1, 0}, NumberSnippet.getDigits(10));
        assertArrayEquals(new int[]{1, 0, 0}, NumberSnippet.getDigits(100));
        assertArrayEquals(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 7}, NumberSnippet.getDigits(Integer.MAX_VALUE));
    }

}
