package com.sweetmanor.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

public class BubbleSort {

    /**
     * 冒泡排序：
     * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     */
    public static void sort(int[] array) {
        int last = array.length - 1;
        // 外层控制循环次数，内层控制比较的元素个数。采用浮起策略，每次把最小的数浮起
        for (int i = 0; i < last; i++)
            for (int j = last; j > i; j--)
                if (array[j] < array[j - 1]) // 如果后面的元素小，则交换位置
                    ArrayUtils.swap(array, j, j - 1);
    }

}
