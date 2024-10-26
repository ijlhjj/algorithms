package com.sweetmanor.exams.linear;

import com.sweetmanor.datastructure.linear.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法大爆炸：面试通关步步为营
 * 11.1 约瑟夫环
 *
 * <p>
 * 编号为1～N的N个人顺时针围成一个圈，每人都持有一个密码（正整数）。
 * 开始时任选一个正整数作为报数上限值M，从编号为1的人开始沿顺时针方向从1报数，报到M时停止。
 * 报M的人出列，并将他手中的密码作为新的报数上限，从他顺时针方向的下一个人开始从1报数，如此下去，直至所有人都出列。
 * 编写一个程序，求这些人的出列顺序。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-09-10
 */
public class JosephCircle {

    private ListNode head;

    /**
     * 创建约瑟夫环：id为下标加1，val为数组元素值
     */
    public void createJosephCircle(int[] vals) {
        //创建节点数组
        ListNode[] nodes = new ListNode[vals.length];

        //循环创建每个节点：id为下标加1，val为数组元素值
        for (int i = 0; i < vals.length; i++)
            nodes[i] = new ListNode(i + 1, vals[i]);

        //循环设置链表节点引用，直至倒数第2个节点
        for (int i = 0; i < nodes.length - 1; i++)
            nodes[i].setNext(nodes[i + 1]);

        //首位节点引用赋值
        head = nodes[0];
        nodes[nodes.length - 1].setNext(head);
    }

    public List<Integer> solve(int m) {
        ListNode curr = head; //当前访问节点
        ListNode pre = head; //前一个节点

        //推进pre到前一个节点（这里是尾节点）
        while (pre.getNext() != curr)
            pre = pre.getNext();

        List<Integer> ans = new ArrayList<>(); //结果列表

        //最后只剩一个节点时两个引用指向同一节点
        while (pre != curr) {
            //报数M
            for (int i = 1; i < m; i++) {
                pre = curr;
                curr = curr.getNext();
            }

            m = curr.getVal(); //赋值M以准备下次循环

            ans.add(curr.getId()); //添加弹出节点 ID
            pre.setNext(curr.getNext()); //修改前一节点链接，达到弹出当前节点目的
            curr = curr.getNext(); //更新当前节点为下一节点
        }

        ans.add(curr.getId()); //添加最后一个节点

        return ans;
    }

}
