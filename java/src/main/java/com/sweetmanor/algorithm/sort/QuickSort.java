package com.sweetmanor.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public class QuickSort {

    private static final Random random = new Random();

    /**
     * 快速排序：
     *
     * <ul>
     *      <li>选择一个基准元素，通常选择第一个元素或者最后一个元素；</li>
     *      <li>通过一趟排序将待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小，另一部分记录的元素值比基准值大；</li>
     *      <li>此时基准元素在其排好序后的正确位置；</li>
     *      <li>然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。</li>
     * </ul>
     *
     * @param array 待排序数组
     * @param left  左边界
     * @param right 右边界
     */
    public static void sort(int[] array, int left, int right) {
        // 左边界小于右边界说明还有未排序元素
        if (left < right) {
            int pivot = partition(array, left, right); // 调用实际排序函数
            sort(array, left, pivot - 1); // 递归排序左半部分
            sort(array, pivot + 1, right); // 递归排序右半部分
        }
    }

    /**
     * 实际排序函数，为保证任何情况下效率都不会最差，采用随机选取
     */
    private static int partition(int[] array, int left, int right) {
        int index = left + random.nextInt(right - left + 1); // 随机选取一个索引
        int pivot = array[index];

        ArrayUtils.swap(array, index, right);// 把基准元素放到数组的最右边
        for (int i = index = left; i < right; i++)// 循环判断所有元素，index存放比基准元素小的索引位置
            if (array[i] <= pivot) // 如果当前元素比基准元素小，交换到左边，索引值加1
                ArrayUtils.swap(array, index++, i);
        ArrayUtils.swap(array, index, right);// 最后把基准元素交换到正确的位置，返回索引值

        return index;
    }

}
