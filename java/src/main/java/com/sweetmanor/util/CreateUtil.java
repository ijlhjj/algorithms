package com.sweetmanor.util;

import com.sweetmanor.datastructure.linear.ListNode;

/**
 * 数据结构创建工具类
 *
 * @author ijlhjj
 * @version 1.0 2024-09-13
 */
public class CreateUtil {

    public static ListNode createListNode(int[] ids, int[] vals) {
        if (ids != null && ids.length != vals.length)
            throw new IllegalArgumentException("参数数组长度不匹配");

        //创建节点数组
        ListNode[] nodes = new ListNode[vals.length];

        //循环创建每个节点：id为下标加1，val为数组元素值
        for (int i = 0; i < vals.length; i++)
            //判断是否自定义 ID
            if (ids != null)
                nodes[i] = new ListNode(ids[i], vals[i]);
            else
                nodes[i] = new ListNode(i + 1, vals[i]);

        //循环设置链表节点引用，直至倒数第2个节点
        for (int i = 0; i < nodes.length - 1; i++)
            nodes[i].setNext(nodes[i + 1]);

        //返回首节点
        return nodes[0];
    }

}
