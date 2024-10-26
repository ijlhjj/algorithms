package com.sweetmanor.exams.twopointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 算法大爆炸：面试通关步步为营
 * 10.9 最长无重复子串
 *
 * <p>
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 例如，给定字符串"abcabcbb"，没有重复字符的最长子串是"abc"或者"bca"或者"cab"，所以长度为3。
 * 给定字符串"bbbbb"，没有重复字符的最长的子串是"b"，长度是1。
 * 给定字符串"pwwkew"，没有重复字符的最长子串是"wke"，长度是3。
 * 请注意答案必须是一个子串，"pwke"是子序列而不是子串。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-09-07
 */
public class MaxNoRepeat {

    public int getSubStringLength(String s) {
        int maxLen = 0; //最长长度

        //使用集合存放不重复的字符
        Set<Character> charSet = new HashSet<>();
        char[] chars = s.toCharArray();

        //使用双指针计算不重复的滑动区间
        int i = 0;
        int j = 0;

        //尾指针超出字符长度
        while (j < chars.length) {
            if (charSet.contains(chars[j])) {
                //字符重复，删除首指针字符并推进
                charSet.remove(chars[i]);
                i++;
            } else {
                //字符不重复，增加并推进尾指针
                charSet.add(chars[j]);
                j++;
            }

            //区间长度更长时更新
            if (j - i > maxLen) {
                maxLen = j - i;
            }
        }

        return maxLen;
    }

}
