package com.sweetmanor.exams.dynamic;

import java.util.Arrays;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例8-2：国王的金矿
 *
 * <p>
 * 有一个国家发现了5座金矿，国王希望挖出尽可能多的黄金。
 * 但是人力有限，要求每座金矿要么全挖，要么不挖，不能只挖一半就停工。
 * 同时每名工人只能在一座金矿上挖金，不能在一座金矿上挖完后再去另外一座金矿。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-27
 */
public class DigGoldMines {

    /**
     * 将问题拆分成是否要开采1～n号金矿的两个子问题
     *
     * @param p 每个金矿开采需要的工人
     * @param g 每个金矿的储量
     * @param n 剩余金矿数
     * @param w 剩余工人数
     * @return 最多可采金矿
     */
    public int getMostGold1(int[] p, int[] g, int n, int w) {
        //只剩1个金矿，如果工人数量不够返回0，工人足够开采则返回金矿储量
        if (n == 1) {
            if (w < p[0])
                return 0;
            else
                return g[0];
        }

        //金矿大于1时
        if (n > 1 && w < p[n - 1]) {
            //如果工人数量不够采集最后1座金矿
            return getMostGold1(p, g, n - 1, w);
        } else {
            //如果工人数量可以采集最后1座金矿，则计算不采集最后1座金矿和采集最后1座金矿可获得的较大值
            int gold1 = getMostGold1(p, g, n - 1, w); //不采集最后1座矿
            int gold2 = getMostGold1(p, g, n - 1, w - p[n - 1]) + g[n - 1]; //采集最后1座矿，工人数减少，采金量增加

            return Math.max(gold1, gold2); //可得两者较大者
        }
    }

    /**
     * w < p[n-1] : f(n，w) = f(n-1，w)
     * w >= p[n-1] : f(n，w) = max[f(n-1，w)，f(n-1，w-p[n-1])+g[n-1]
     */
    public int getMostGold2(int[] p, int[] g, int n, int w) {
        int[] preResult = new int[w + 1]; //舍弃下标0的位置
        int[] result = new int[w + 1];

        //初始化第1行
        for (int j = 1; j <= w; j++) {
            if (j < p[0])
                preResult[j] = 0;
            else
                preResult[j] = g[0];
        }

        //循环生成剩余行
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i])
                    result[j] = preResult[j];
                else
                    result[j] = Math.max(preResult[j], preResult[j - p[i]] + g[i]);
            }

            preResult = Arrays.copyOf(result, w + 1);
        }

        return result[w];
    }

}
