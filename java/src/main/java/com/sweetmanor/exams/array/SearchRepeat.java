package com.sweetmanor.exams.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例1-2：删除数组中的重复元素
 *
 * <p>
 * 编写一个函数purge()，删除整数数组中的重复元素。
 * 例如，数组为{1，1，3，5，2，3，1，5，6，8}，删除重复元素后数组变为{1，3，5，2，6，8}。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-16
 */
public class SearchRepeat {

    public int[] purge(int[] nums) {
        List<Integer> resultList = new ArrayList<>(); //使用List存储结果，因为不能确定结果集大小
        Set<Integer> values = new HashSet<>(); //使用集合判断元素是否重复，元素第一次出现时加入集合
        //遍历数组进行处理
        for (int n : nums) {
            //元素第一次出现，必然不包含在集合中
            if (!values.contains(n)) {
                resultList.add(n); //加入结果列表
                values.add(n); //加入重复集
            }
        }

        //列表转数组
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

}
