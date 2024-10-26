package com.sweetmanor.algorithm.search;

import java.util.List;

/**
 * 通用查找 —— 《算法精粹》
 *
 * @author ijlhjj
 * @version 1.0 2023-12-11
 */
public class GenericSearch {

    /**
     * 线性查找
     */
    public static <T extends Comparable<T>> boolean linearContains(List<T> list, T key) {
        for (T item : list) {
            if (item.compareTo(key) == 0)
                return true;
        }
        return false;
    }

    /**
     * 二分查找
     */
    public static <T extends Comparable<T>> boolean binaryContains(List<T> list, T key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int c = list.get(mid).compareTo(key);

            if (c < 0)
                low = mid + 1;
            else if (c > 0)
                high = mid - 1;
            else
                return true;
        }

        return false;
    }

}
