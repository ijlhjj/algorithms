package com.sweetmanor.exams.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例6-1：数组的全排列
 *
 * <p>
 * 编写一个程序，将数组中的元素进行全排列，并输出每一种排列方式。
 * 例如数组中的元素为{1，3，5}，程序可输出该数组元素的6种排列方式，
 * 分别为{1，3，5}{1，5，3}{3，1，5}{3，5，1}{5，1，3}{5，3，1}。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-23
 */
public class Permutations {

    /**
     * 从数组删除指定下标元素
     *
     * @param nums  原数组
     * @param index 待删除元素下标
     * @return 返回删除指定下标后的新数组
     */
    private int[] deleteArrayEle(int[] nums, int index) {
        int[] arr = new int[nums.length - 1]; //定义结果数组比输入数组小 1

        int j = 0; //结果数组下标，在删除下标后要比 i 小 1
        for (int i = 0; i < nums.length; i++) {
            if (i == index) //删除下标不赋值，直接跳过
                continue;

            //赋值并递进下标
            arr[j] = nums[i];
            j++;
        }

        return arr;
    }

    private void perm(int[] nums, List<Integer> permList) {
        //基准条件
        if (nums == null || nums.length < 1)
            return;

        //最后一个元素时处理打印
        if (nums.length == 1) {
            permList.add(nums[0]);
            System.out.println(permList);
        }

        //循环递归每次减少一个元素的数组
        for (int i = 0; i < nums.length; i++) {
            //拷贝临时数组，加入当前处理元素
            List<Integer> temList = new ArrayList<>(permList);
            temList.add(nums[i]);

            //删除当前元素作为剩余处理数组
            int[] temArr = deleteArrayEle(nums, i);

            //递归处理剩余数组元素
            perm(temArr, temList);
        }
    }

    public void permutation(int[] nums) {
        perm(nums, new ArrayList<>());
    }

    public static void main(String[] args) {
        Permutations exam = new Permutations();
        exam.permutation(new int[]{1, 3, 5});
    }

}
