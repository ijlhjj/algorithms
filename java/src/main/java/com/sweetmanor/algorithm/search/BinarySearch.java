package com.sweetmanor.algorithm.search;

/**
 * 二分查找
 *
 * @author wenz
 * @version 1.0 2023-08-08
 */
public class BinarySearch {

    public static int binarySearch(int[] ints, int key) {
        return binarySearch0(ints, 0, ints.length, key);
    }

    public static int binarySearch(int[] ints, int key, boolean reverse) {
        return binarySearch1(ints, 0, ints.length, key, reverse);
    }

    /**
     * JDK 内部实现的二分查找算法
     * <p>
     * 不论找到与否，返回的都是相对于整个数组的索引，而非相对于 fromIndex 的增量
     *
     * @return index of the search key, if it is contained in the array; otherwise, <code>(-(<i>insertion point</i>) - 1)</code>.
     */
    public static int binarySearch0(int[] ints, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = ints[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    /**
     * 支持逆序数组的二分查找方法
     * <p>
     * 其他逻辑和参数含义跟 binarySearch0 保持一致
     */
    public static int binarySearch1(int[] ints, int fromIndex, int toIndex, int key, boolean reverse) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = ints[mid];

            if (reverse ? midVal > key : midVal < key)
                low = mid + 1;
            else if (reverse ? midVal < key : midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    /**
     * Python 内部实现的二分查找算法
     * <p>
     * 查找元素在列表中存在多个相同元素时返回最左侧的索引
     */
    public static int binarySearchLeft0(int[] ints, int key) {
        int low = 0;
        int high = ints.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = ints[mid];

            if (midVal < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    /**
     * 参考 Python 内部实现的二分查找算法
     * <p>
     * 查找元素在列表中存在多个相同元素时返回最左侧的索引
     */
    public static int binarySearchLeft1(int[] ints, int key) {
        int low = 0;
        int high = ints.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = ints[mid];

            if (midVal < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if (ints[low] == key)
            return low; // key found
        else
            return -(low + 1); // key not found.
    }

    /**
     * Python 内部实现的二分查找算法
     * <p>
     * 查找元素在列表中存在多个相同元素时返回最右侧的 索引 + 1
     * 在当前索引插入可保证插在相同元素的右侧
     */
    public static int binarySearchRight0(int[] ints, int key) {
        int low = 0;
        int high = ints.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = ints[mid];

            if (key < midVal)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    /**
     * 参考 Python 内部实现的二分查找算法
     * <p>
     * 查找元素在列表中存在多个相同元素时返回最右侧的索引
     */
    public static int binarySearchRight1(int[] ints, int key) {
        int low = 0;
        int high = ints.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = ints[mid];

            if (key < midVal)
                high = mid - 1;
            else
                low = mid + 1;
        }

        if (low > 0 && ints[low - 1] == key)
            return low - 1; // key found
        else
            return -(low + 1); // key not found.
    }

}
