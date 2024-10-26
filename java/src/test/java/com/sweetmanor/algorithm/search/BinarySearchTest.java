package com.sweetmanor.algorithm.search;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    final int NUM_SIZE = 10000;
    Random random = new Random();
    int[] ints;

    @BeforeEach
    void setUp() {
        ints = random.ints(NUM_SIZE).toArray();
        Arrays.sort(ints);
    }

    @RepeatedTest(10)
    void binarySearch01() {
        int index = random.nextInt(ints.length);
        int key = ints[index];

        int expected = Arrays.binarySearch(ints, key);
        int actual = BinarySearch.binarySearch0(ints, 0, ints.length, key);
        assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    void binarySearch02() {
        int key = random.nextInt();
        int fromIndex = 5000;

        int expected = Arrays.binarySearch(ints, fromIndex, ints.length, key);
        int actual = BinarySearch.binarySearch0(ints, fromIndex, ints.length, key);
        // 查找到指定元素返回相对于整个数组的索引；
        // 查找不到插入位置大于 fromIndex 返回 -index -1 ，小于 fromIndex 返回 -fromIndex - 1
        assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    void binarySearch11() {
        ArrayUtils.reverse(ints); //逆序

        int index = random.nextInt(ints.length);
        int key = ints[index];

        int actual = BinarySearch.binarySearch1(ints, 0, ints.length, key, true);
        assertEquals(index, actual);
    }

    @RepeatedTest(10)
    void binarySearch12() {
        int key = random.nextInt();
        int fromIndex = 5000;

        int expected = Arrays.binarySearch(ints, fromIndex, ints.length, key);
        int actual = BinarySearch.binarySearch1(ints, fromIndex, ints.length, key, false);
        assertEquals(expected, actual);
    }

    @Test
    void binarySearchLeft() {
        int[] nums = {1, 2, 5, 5, 5, 5, 5, 8, 9};
        int index1 = BinarySearch.binarySearchLeft0(nums, 5);
        assertEquals(2, index1);

        int index2 = BinarySearch.binarySearchLeft1(nums, 5);
        assertEquals(2, index2);
    }

    @Test
    void binarySearchRight() {
        int[] nums = {1, 2, 5, 5, 5, 5, 5, 8, 9};
        int index1 = BinarySearch.binarySearchRight0(nums, 5);
        assertEquals(7, index1);

        int index2 = BinarySearch.binarySearchRight1(nums, 5);
        assertEquals(6, index2);
    }

}
