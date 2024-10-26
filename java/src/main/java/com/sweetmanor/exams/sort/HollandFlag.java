package com.sweetmanor.exams.sort;

import com.sweetmanor.util.ArrayUtil;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例4-1：荷兰国旗问题
 *
 * <p>
 * 荷兰国旗由红、白、蓝三色构成。
 * 有一个由红、白、蓝三种颜色的n个条块组成的序列，请设计一个时间复杂度为O(n)的算法，将这些条块按照红、白、蓝的顺序排好，也就是构成荷兰国旗的图案。
 * 其中0表示红色条块，1表示白色条块，2表示蓝色条块。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-21
 */
public class HollandFlag {

    public int[] arrangeHollandFlag(int[] array) {
        //i 指向第一个不为0的元素
        int i = 0;
        while (array[i] == 0)
            i++;

        //j 指向最后一个不为2的元素
        int j = array.length - 1;
        while (array[j] == 2)
            j--;

        //从左到右处理到最后一个不为2的元素
        int curr = i;
        while (curr <= j) {
            if (array[curr] == 0) {
                //0交换到左边第一个不为0的位置
                ArrayUtil.swap(array, curr, i);
                i++;
                curr++;
            } else if (array[curr] == 2) {
                //2交换到右边第一个不为2的位置
                ArrayUtil.swap(array, curr, j);
                while (array[j] == 2)
                    j--;
            } else {
                curr++; //1不处理
            }
        }

        return array;
    }

}
