package com.sweetmanor.snippet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 数值相关的代码片段
 *
 * @author ijlhjj
 * @version 1.0 2023-09-20
 */
public class NumberSnippet {

    /**
     * 获取正整数的各个数值位
     */
    public static int[] getDigits(int num) {
        //反向取各位数值，先取个位，再取十位……
        Deque<Integer> digitStack = new LinkedList<>();
        do {
            digitStack.push(num % 10); //取余
            num /= 10;              // 取商
        } while (num > 0);

        //反转数组
        int[] ds = new int[digitStack.size()];
        for (int i = 0; i < ds.length; i++)
            ds[i] = digitStack.pop();
        return ds;
    }

}
