package com.sweetmanor.exams.search;

import com.sweetmanor.algorithm.search.BinarySearch;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例4-2：重复数字出现的次数
 *
 * <p>
 * 已知有一个从小到大排列的有序整型数组，请编写程序，找出某个数字出现的次数。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-21
 */
public class CountRepeatNumber {

    public int getRepeatNumberCount(int[] nums, int key) {
        int left = BinarySearch.binarySearchLeft0(nums, key);
        int right = BinarySearch.binarySearchRight0(nums, key);
        return right - left;
    }

}
