package com.sweetmanor.util;

import java.util.List;

/**
 * 数组工具类
 *
 * @author ijlhjj
 * @version 1.0 2023-09-17
 */
public class ArrayUtil {

    /**
     * 整型数组列表转为数组
     *
     * @param nums 整型数组列表，不为空
     * @throws IllegalArgumentException nums is null
     */
    public static int[] toArray(List<Integer> nums) {
        if (nums == null)
            throw new IllegalArgumentException();

        int[] arr = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++)
            arr[i] = nums.get(i);

        return arr;
    }

    /**
     * 列表元素交换
     *
     * @param array 不为 null 且 array.length >= 2
     * @param i     数组元素下标，0 <= i < array.length
     * @param j     数组元素下标，0 <= j < array.length
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 查找数组最大元素值
     *
     * @param array 不为 null 且 array.length > 0
     */
    public static int max(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];

        return max;
    }

    /**
     * 合并两个已排序数组：
     * 前置条件：
     * 1、两个入参数组有序，从小到大的顺序；
     *
     * @param a 已排序数组
     * @param b 已排序数组
     * @return 两个数组排序后的合并结果，从小到大的顺序。
     * 如果一个入参为null，返回另一个数组；
     * 如果两个入参都为null，返回null。
     */
    public static int[] merge(int[] a, int[] b) {
        //如果一个入参为null，返回另一个数组
        if (a == null)
            return b;
        else if (b == null)
            return a;

        int al = a.length;
        int bl = b.length;

        int[] nums = new int[al + bl]; //结果数组

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < al && j < bl) {
            //赋值较小元素值，推进相应下标
            if (a[i] < b[j]) {
                nums[k] = a[i];
                i++;
            } else {
                nums[k] = b[j];
                j++;
            }
            k++;
        }

        //处理没处理完的数组
        if (i == al) {
            while (j < bl) {
                nums[k++] = b[j++];
            }
        } else if (j == bl) {
            while (i < al) {
                nums[k++] = a[i++];
            }
        }

        return nums;
    }

    /**
     * 数组反转
     */
    public static void reverse(int[] array) {
        if (array != null) {
            for (int i = 0, j = array.length - 1; i < j; ++i, --j)
                swap(array, i, j);
        }
    }

}
