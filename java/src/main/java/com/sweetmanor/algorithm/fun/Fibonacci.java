package com.sweetmanor.algorithm.fun;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * 斐波那契数列
 * <p>
 * 斐波那契数列是一组数字，除了第一个和第二个数字外，其他数字都是前两个数字之和：
 * <pre>
 *      fib(0) = 1
 *      fib(1) = 1
 *      fib(n) = fib(n − 1) + fib(n − 2)
 * </pre>
 * <p>
 * 可能超出 long 值上限，发生溢出
 *
 * @author wenz
 * @version 1.0 2023-12-09
 */
public class Fibonacci {

    /**
     * 递归实现：这是一个反例，运行时间以指数级速度增长。 (3/2)^N <= fib(N) < (5/3)^N
     */
    private static long fib1(int n) {
        if (n < 2)
            return 1;
        else
            return fib1(n - 1) + fib1(n - 2);
    }

    private static Map<Integer, Long> memo = new HashMap<>(Map.of(0, 1L, 1, 1L));

    /**
     * 递归实现：使用映射缓存避免重复计算
     */
    private static long fib2(int n) {
        //查找缓存
        if (memo.containsKey(n))
            return memo.get(n);

        long val = fib2(n - 1) + fib2(n - 2);
        memo.put(n, val); //加入缓存

        return val;
    }

    /**
     * 循环实现
     */
    private static long fib3(int n) {
        long last = 1, next = 1; // fib(0), fib(1)

        for (int i = 0; i < n; i++) {
            long oldLast = last;
            last = next;
            next = oldLast + next;
        }

        return last;
    }

    private static long last = 1, next = 1; // fib(0), fib(1)

    /**
     * 生成器模式，返回Java数值流
     */
    private static LongStream fib4() {
        return LongStream.generate(() -> {
            long oldLast = last;
            last = next;
            next = oldLast + next;
            return oldLast;
        });
    }

    /**
     * 数组实现：线性运行时间 O(N)
     */
    private static long fib5(int n) {
        if (n <= 2)
            return 1;

        long[] arr = new long[n];
        arr[0] = 1; // fib(0)
        arr[1] = 1; // fib(0)
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2]; // fib(n)
        }

        return arr[n - 1];
    }

    /**
     * 双数值计算：线性运行时间 O(N)
     */
    private static long fib6(int n) {
        if (n <= 2)
            return 1;

        long f1 = 1, f2 = 1;// 基准值
        double count = n / 2.0;// 循环次数，每次计算两个值，所以循环次数减半
        for (int i = 1; i < count; i++) {
            f1 = f1 + f2;
            f2 = f1 + f2;
        }

        return n % 2 == 1 ? f1 : f2;
    }

    public static void main(String[] args) {
        final int N = 20;// 输出斐波那契数列中的前 N 个值

        System.out.println("斐波那契数列：");

        // 递归 fib1：40以内可以秒出
        for (int i = 0; i < N; i++)
            System.out.print(fib1(i) + "  ");
        System.out.println();

        // 缓存递归 fib2
        for (int i = 0; i < N; i++)
            System.out.print(fib2(i) + "  ");
        System.out.println();

        // 循环迭代实现 fib3
        for (int i = 0; i < N; i++)
            System.out.print(fib3(i) + "  ");
        System.out.println();

        //生成器模式 fib4
        fib4().limit(N).forEach(n -> System.out.print(n + "  "));
        System.out.println();

        // 数组实现 fib5
        for (int i = 1; i <= N; i++)
            System.out.print(fib5(i) + "  ");
        System.out.println();

        // 双数值计算 fib6 ，这个不能传 0
        for (int i = 1; i <= N; i++)
            System.out.print(fib6(i) + "  ");
        System.out.println();
    }

}
