package com.sweetmanor.exams.linear;

import com.sweetmanor.datastructure.linear.ListNode;

/**
 * 算法大爆炸：面试通关步步为营
 * 11.2 单链表的逆置
 *
 * <p>
 * 编写一个程序，实现单链表的逆置。
 * 原链表的数据元素为(a1，a2，a3，…，an-1，an)，链表逆置后变为(an，an-1，…，a3，a2，a1)。
 * 要求不增加新的链表节点空间。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-09-13
 */
public class LinkedListReverse {

    public ListNode reverse(ListNode head) {
        //空链表直接返回
        if (head == null)
            return null;

        ListNode p = head; //当前处理节点
        ListNode q = null; //前1个节点
        ListNode r = null; //前2个节点

        while (p != null) {
            r = q; //2推1
            q = p; //1推0
            p = p.getNext(); //当前处理节点后推
            q.setNext(r); //链接反转
        }

        //处理完 q 指向当前节点
        return q;
    }

}
