package com.sweetmanor.util;

/**
 * 数学工具类
 *
 * @author ijlhjj
 * @version 1.0 2024-05-03
 */
public class MathUtil {

    /**
     * 乘方函数：
     * 本函数不做任何限制和校验，入参合法性和结果溢出由调用方保证
     *
     * @param base 底数
     * @param exp  指数
     */
    public static int pow(int base, int exp) {
        int power = 1;
        for (int i = 0; i < exp; i++)
            power *= base;
        return power;
    }

}
