package com.sweetmanor.algorithm.sort;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    @RepeatedTest(10)
    void sort1() {
        Random random = new Random();
        int[] array1 = random.ints(100).toArray();
        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array1, array1.length);
        int[] array4 = Arrays.copyOf(array1, array1.length);
        int[] array5 = Arrays.copyOf(array1, array1.length);
        int[] array6 = Arrays.copyOf(array1, array1.length);

        Arrays.sort(array1);
        SelectionSort.sort(array2);
        BubbleSort.sort(array3);
        InseretionSort.sort(array4);
        QuickSort.sort(array5, 0, array5.length - 1);

        assertArrayEquals(array1, array2);
        assertArrayEquals(array1, array3);
        assertArrayEquals(array1, array4);
        assertArrayEquals(array1, array5);
        assertArrayEquals(array1, MergeSort.sort(array6));
    }

}
