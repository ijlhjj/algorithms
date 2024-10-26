package com.sweetmanor.algorithm.sort;

public class InseretionSort {

    /**
     * 插入排序：
     * 将一个记录插入到已排序好的有序表中，从而得到一个新记录数增1的有序表。即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
     */
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i]; // 缓存当前待插入元素

            int j = i - 1;
            for (; j >= 0 && array[j] > temp; j--)
                array[j + 1] = array[j];

            array[j + 1] = temp; // 插入当前元素
        }
    }

}
