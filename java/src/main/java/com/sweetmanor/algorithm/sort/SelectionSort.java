package com.sweetmanor.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

public class SelectionSort {

    /**
     * 选择排序：
     * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++)// 每次找到最小的数进行排序
                if (array[j] < array[index])
                    index = j;
            ArrayUtils.swap(array, i, index);
        }
    }

}
