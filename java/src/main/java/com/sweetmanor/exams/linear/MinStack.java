package com.sweetmanor.exams.linear;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 算法大爆炸：面试通关步步为营
 * 11.6 最小栈问题
 *
 * <p>
 * 设计一个支持push()、pop()函数的栈，同时要支持getMinValue()函数，该函数能在常数时间内检索到栈中的最小值。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-09-24
 */
public class MinStack {

    private final Deque<Integer> stack = new LinkedList<>(); //元素栈
    private final Deque<Integer> minValStack = new LinkedList<>(); //辅助最小栈

    public void push(int num) {
        stack.push(num); //元素入栈

        //如果当前元素小于等于最小栈顶，插入最小栈。相同元素重复存放
        if (minValStack.isEmpty() || num <= minValStack.peek())
            minValStack.push(num);
    }

    public int pop() {
        //空栈非法操作
        if (stack.isEmpty())
            throw new IndexOutOfBoundsException("空栈不能进行此操作");

        //弹出栈顶元素，如果栈顶元素是最小元素，弹出最小栈顶
        int val = stack.pop();
        if (val == minValStack.peek())
            minValStack.pop();

        return val;
    }

    public int getMinValue() {
        return minValStack.peek(); //返回最小栈顶元素
    }

}
