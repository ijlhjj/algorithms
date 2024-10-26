package com.sweetmanor.algorithm.text;

/**
 * 最长公共部分求解
 *
 * @author wenz
 * @version 1.0 2024-05-03
 */
public class LongestCommonSub {

    /**
     * 最长公共前缀
     */
    public static String longestCommonPrefix(String str1, String str2) {
        // 公共前缀不会超过短字符串长度
        int minLen = Math.min(str1.length(), str2.length());

        int index = 0;
        while (index < minLen && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }

        // 返回公共前缀部分
        return str1.substring(0, index);
    }

}
