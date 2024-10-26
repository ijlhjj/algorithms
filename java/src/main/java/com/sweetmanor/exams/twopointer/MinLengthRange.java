package com.sweetmanor.exams.twopointer;

/**
 * 算法大爆炸：面试通关步步为营
 * 10.8 长度最小的连续子数组
 *
 * <p>
 * 给定一个含有n个正整数的数组和一个正整数k，找出该数组中满足其和大于或等于(≥)k的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，则返回null。
 * 例如，输入为s=7，nums={2，3，1，2，4，3}，则输出应为{4，3}，因为子数组{4，3}是该条件下的长度最小的连续子数组。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-09-01
 */
public class MinLengthRange {

    /**
     * 滑动窗口：使用双指针，如果区间和小于k，则推进尾指针；如果区间和满足要求，则推进首指针。长度更短时更新区间值。
     */
    public int[] getMinSubArray(int[] nums, int k) {
        int minLen = nums.length; //最小长度
        int s = 0; //结果首指针
        int e = 0; //结果尾指针

        int i = 0; //推进首指针
        int j = 0; //推进尾指针
        int sum = 0; //区间和

        //尾指针超过数组长度时终止
        while (j <= nums.length) {
            if (sum < k) {
                //区间和不达要求，推进尾指针
                if (j < nums.length)
                    sum += nums[j];
                j++;
            } else {
                //满足要求，推进首指针
                sum -= nums[i];
                i++;
            }

            //当前区间满足要求
            if (sum >= k) {
                int l = j - i; //计算区间长度
                //长度更短时更新区间值
                if (l < minLen) {
                    minLen = l;
                    s = i;
                    e = j;
                }
            }
        }

        //找到符合要求的区间，返回结果，否则返回 null
        if (minLen == nums.length)
            return new int[0];
        else
            return new int[]{s, e};
    }

}
