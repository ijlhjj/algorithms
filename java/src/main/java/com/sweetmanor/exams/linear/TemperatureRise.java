package com.sweetmanor.exams.linear;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 算法大爆炸：面试通关步步为营
 * 11.7 每日温度
 *
 * <p>
 * 请根据每日气温列表重新生成一个列表，新列表的内容是观测更高气温需要等待的天数。如果气温在某天之后不再升高，则在对应位置填0。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-09-25
 */
public class TemperatureRise {

    /**
     * 使用 单调递减栈
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length]; //定义结果数组

        //定义栈辅助计算，使用 单调递减栈，只有更小（或相等）的元素才入栈。
        Deque<Integer> stack = new LinkedList<>();

        //循环处理数组元素
        int i = 0;
        while (i < temperatures.length) {
            //栈空 或 气温非升高，则入栈
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //气温升高，弹出栈顶，计算天数差
                int j = stack.pop();
                days[j] = i - j;
            }
        }

        return days;
    }

}
