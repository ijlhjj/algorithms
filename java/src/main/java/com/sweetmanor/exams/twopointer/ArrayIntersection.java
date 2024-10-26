package com.sweetmanor.exams.twopointer;

import java.util.Arrays;

/**
 * 算法大爆炸：面试通关步步为营
 * 10.5 两个有序数组的交集
 *
 * <p>
 * 给定两个有序整型数组array_1和array_2，数组元素递增且不重复，计算array_1和array_2的交集。
 * 例如array_1={2，5，6，8，9}，array_2={1，5，6，7，8}，它们的交集为{5，6，8}。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-31
 */
public class ArrayIntersection {

    /**
     * 利用“数组元素递增且没有重复元素”的条件，通过双指针法，只需扫描一遍便可以找到两个数组的交集元素。该算法的时间复杂度为O(n) 。
     */
    public int[] getIntersection(int[] arr1, int[] arr2) {
        int i = 0; //arr1下标
        int j = 0; //arr2下标
        int k = 0; //结果数组下标
        int len = Math.min(arr1.length, arr2.length); //交集不会大于较短数组的大小

        int[] result = new int[len]; //结果数组

        //遍历完一个数组即可
        while (i < arr1.length && j < arr2.length) {
            //元素相等，加入交集结果数组，下标推进
            if (arr1[i] == arr2[j]) {
                result[k] = arr1[i];
                i++;
                j++;
                k++;
            } else if (arr1[i] > arr2[j]) {
                j++; //第一个数组元素大，推进第二个数组下标
            } else {
                i++; //第一个数组元素小，推进第一个数组下标
            }
        }

        return Arrays.copyOf(result, k); //结果数组截断
    }

}
