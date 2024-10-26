package com.sweetmanor.exams.dynamic;

/**
 * 算法大爆炸：面试通关步步为营
 * 8.1
 *
 * <p>
 * 走楼梯问题：一个楼梯共有10级台阶，一个人从下往上走，可以一次走1级台阶，也可以一次走2级台阶。请问有多少种方法走完这10级台阶？
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-16
 */
public class ClimbStairs {

    public int getClimbWays(int n) {
        if (n == 1)
            //1级台阶有1种走法
            return 1;
        else if (n == 2)
            //2级台阶有2种走法
            return 2;
        else
            //大于2时， f(n) = f(n-1) + f(n-2)
            return getClimbWays(n - 1) + getClimbWays(n - 2);
    }

}
