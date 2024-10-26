package com.sweetmanor.exams.greedy;

import java.util.Arrays;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例7-1：分薄饼问题
 *
 * <p>
 * 幼儿园的老师给小朋友们分薄饼。
 * 已知每个小朋友最多只能分到一块薄饼，对于每个小朋友i，都有一个需求值gi，即能让小朋友i满足需求的薄饼的最小尺寸。
 * 同时每块薄饼j都有一个尺寸sj，如果sj≥gi，就可以将薄饼j分给小朋友i。
 * 请输出最多能满足几位小朋友。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-24
 */
public class MostSatisfy {

    public int getContentedChildren(int[] g, int[] s) {
        int c = 0;

        Arrays.sort(g); //数组排序
        Arrays.sort(s);

        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            if (g[j] <= s[i]) { //可满足需求，统计增加，递进 j
                c++;
                j++;
            }
        }

        return c;
    }

}
