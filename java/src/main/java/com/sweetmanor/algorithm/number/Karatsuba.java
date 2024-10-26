package com.sweetmanor.algorithm.number;

import com.sweetmanor.util.MathUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;

/**
 * 大整数乘法：RecIntMult算法 和 Karatsuba 算法
 * 本示例使用int值，只为演示算法，实际不支持超过int上限的计算
 *
 * @author ijlhjj
 * @version 1.0 2023-5-3
 */
public class Karatsuba {

    /**
     * Karatsuba 算法
     * 为截取数值的前、后半部分，这里处理后转为char数组
     */
    public static int karatsuba(int x, int y) {
        //调用函数进行入参预处理
        Pair<String, String> pair = intToStr(x, y);

        //处理后调用实际计算函数
        return karatsuba(pair.getLeft().toCharArray(), pair.getRight().toCharArray());
    }

    /**
     * 先决条件：n是2的整数次方
     * Karatsuba 算法 比 RecIntMult 算法 少一次递归调用
     * x*y = 10^n * (a*c) + 10^(n/2) * (a*d+b*c) + b*d
     * a*d + b*c = (a+b)*(c+d) - a*c - b*d
     */
    private static int karatsuba(char[] xChars, char[] yChars) {
        //输入2个数组长度一致都为 n ，且 n 是2的整数次方
        int n = xChars.length;

        //基准条件，数值只剩 1 位，直接计算返回
        if (n == 1)
            return (xChars[0] - '0') * (yChars[0] - '0');

        //取索引中值，将数组分割为前、后半部分
        int mid = n / 2;
        char[] a = Arrays.copyOfRange(xChars, 0, mid);
        char[] b = Arrays.copyOfRange(xChars, mid, n);
        char[] c = Arrays.copyOfRange(yChars, 0, mid);
        char[] d = Arrays.copyOfRange(yChars, mid, n);

        //递归计算各部分乘积
        int ac = karatsuba(a, c);
        int bd = karatsuba(b, d);
        Pair<String, String> pair = addChars(a, b, c, d);
        int abcd = karatsuba(pair.getLeft().toCharArray(), pair.getRight().toCharArray());

        //按公式相加后返回结果
        return MathUtil.pow(10, n) * ac + MathUtil.pow(10, mid) * (abcd - ac - bd) + bd;
    }

    /**
     * RecIntMult 算法：
     * 为截取数值的前、后半部分，这里处理后转为char数组
     */
    public static int recintmult(int x, int y) {
        //调用函数进行入参预处理
        Pair<String, String> pair = intToStr(x, y);

        //处理后调用实际计算函数
        return recintmult(pair.getLeft().toCharArray(), pair.getRight().toCharArray());
    }

    /**
     * 先决条件：n是2的整数次方
     * x*y = 10^n * (a*c) + 10^(n/2) * (a*d+b*c) + b*d
     */
    private static int recintmult(char[] xChars, char[] yChars) {
        //输入2个数组长度一致都为 n ，且 n 是2的整数次方
        int n = xChars.length;

        //基准条件，数值只剩 1 位，直接计算返回
        if (n == 1)
            return (xChars[0] - '0') * (yChars[0] - '0');

        //取索引中值，将数组分割为前、后半部分
        int mid = n / 2;
        char[] a = Arrays.copyOfRange(xChars, 0, mid);
        char[] b = Arrays.copyOfRange(xChars, mid, n);
        char[] c = Arrays.copyOfRange(yChars, 0, mid);
        char[] d = Arrays.copyOfRange(yChars, mid, n);

        //递归计算各部分乘积
        int ac = recintmult(a, c);
        int ad = recintmult(a, d);
        int bc = recintmult(b, c);
        int bd = recintmult(b, d);

        //按公式相加后返回结果
        return MathUtil.pow(10, n) * ac + MathUtil.pow(10, mid) * (ad + bc) + bd;
    }

    // 递归实现
    public static int recintmult2(int a, int b) {
        if (b == 0)
            return 0;

        if (b % 2 == 0) {
            return recintmult2(a << 1, b >> 1);
        } else {
            return a + recintmult2(a << 1, b >> 1);
        }
    }

    /**
     * 将数值处理为 2^n 长度的字符串，长度不足前补 0
     */
    private static Pair<String, String> intToStr(int x, int y) {
        //先转为字符串
        String xStr = x + "";
        String yStr = y + "";

        //为方便处理，这里长度拼装成一致的 2^n ，前面加 0
        int n = Math.max(xStr.length(), yStr.length());
        int p = 1;
        while (p < n)
            p *= 2;
        n = p;

        //拼装字符长度
        String xs = StringUtils.leftPad(xStr, n, '0');
        String ys = StringUtils.leftPad(yStr, n, '0');

        return ImmutablePair.of(xs, ys);
    }

    /**
     * @return a+b 和 c+d 的结果字符串对
     */
    private static Pair<String, String> addChars(char[] a, char[] b, char[] c, char[] d) {
        int an = Integer.parseInt(new String(a));
        int bn = Integer.parseInt(new String(b));
        int cn = Integer.parseInt(new String(c));
        int dn = Integer.parseInt(new String(d));

        int x = an + bn;
        int y = cn + dn;

        return intToStr(x, y);
    }

}
