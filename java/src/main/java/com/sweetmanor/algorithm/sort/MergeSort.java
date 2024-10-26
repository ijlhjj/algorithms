package com.sweetmanor.algorithm.sort;

import com.sweetmanor.util.ArrayUtil;

/**
 * 归并排序
 *
 * @author ijlhjj
 * @version 1.0 2024-05-04
 */
public class MergeSort {

    public static int[] sort(int[] array) {
        return mergeSort(array, 0, array.length);
    }

    /**
     * 归并排序
     *
     * @param array 待排序数组
     * @param left  左边界下标，包含
     * @param right 右边界下标，不包含
     */
    public static int[] mergeSort(int[] array, int left, int right) {
        int len = right - left;

        //基准条件
        if (len < 1)
            return new int[0];
        else if (len == 1)
            return new int[]{array[left]};

        //如果只有2个元素，直接排序
        if (len == 2) {
            if (array[left] > array[left + 1])
                return new int[]{array[left + 1], array[left]};
            else
                return new int[]{array[left], array[left + 1]};
        }

        //分治处理
        int mid = (left + right) / 2;
        int[] firstPart = mergeSort(array, left, mid); //递归排序前半部分
        int[] secondPart = mergeSort(array, mid, right); //递归排序后半部分

        //合并两个已排序数组并返回
        return ArrayUtil.merge(firstPart, secondPart);
    }

}
