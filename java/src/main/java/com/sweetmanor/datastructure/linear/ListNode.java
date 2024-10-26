package com.sweetmanor.datastructure.linear;

import java.util.Objects;

/**
 * 线性链表节点类
 *
 * @author ijlhjj
 * @version 1.0 2024-09-10
 */
public class ListNode {

    private int id;
    private int val;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int id, int val) {
        this.id = id;
        this.val = val;
    }

    public ListNode(int id, int val, ListNode next) {
        this.id = id;
        this.val = val;
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) // 检测是否引用同一个对象，这是经常采用的优化形式
            return true;
        if (obj == null) // null值返回false，必须的检测
            return false;
        // 比较是否是同一个类
        if (getClass() != obj.getClass())
            return false;

        ListNode other = (ListNode) obj;

        //比较 id 、 val 和 next 是否相等
        return id == other.id && val == other.val && Objects.equals(next, other.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, val, next);
    }

    @Override
    public String toString() {
        return "ListNode{" + "id=" + id + ", val=" + val + ", next=" + next + '}';
    }

}
