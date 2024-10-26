package com.sweetmanor.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayUtilTest {

    @Test
    void toArray() {
        int[] expected = {1, 2, 3, 4, 5};
        ArrayList<Integer> nums = new ArrayList<>();
        for (int n : expected)
            nums.add(n);

        int[] actual = ArrayUtil.toArray(nums);
        assertArrayEquals(expected, actual);
    }

    @Test
    void merge() {
        assertArrayEquals(new int[]{1, 2, 2, 3, 4, 5, 6, 7}, ArrayUtil.merge(new int[]{2, 4, 5, 7}, new int[]{1, 2, 3, 6}));
    }

}
