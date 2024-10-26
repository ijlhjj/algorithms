package com.sweetmanor.exams.linear;

import com.sweetmanor.datastructure.linear.ListNode;

/**
 * 算法大爆炸：面试通关步步为营
 * 11.3 判断链表中是否存在循环结构
 *
 * <p>
 * 给定一个链表，可能是以null结尾的非循环链表，也可能是带有循环结构的循环链表。
 * 这里的循环结构指链表中某个节点的next域指向它之前的某个节点，并不一定是第1个节点。
 * 已知这个链表的头指针，请编写一个函数来判断该链表是否存在循环结构。要求函数不得修改链表本身。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-09-17
 */
public class LoopLinkedList {

    /**
     * 一个经典而巧妙的算法（快慢指针法），该算法不需要占用额外的内存空间，时间复杂度为O(n)。
     * 采用指针fast和slow分别指向链表的两个节点，在初始条件下，slow指向链表的第1个节点，fast指向其下一个节点。
     * 然后两个指针顺序向后遍历链表，在遍历过程中指针slow一次只访问一个链表节点，而指针fast一次访问两个链表节点。
     * 每完成一次访问都要判断slow是否等于fast，或者fast是否为null。如果slow等于fast，则说明该链表是循环链表；如果fast等于null，则说明该链表不是循环链表。
     * <p>
     * 我们可以形象地将该算法的比较过程想象成在环形跑道上赛跑，fast指针相当于跑得快的运动员，slow指针相当于跑得慢的运动员。
     * 如果两名运动员保持各自的速度不变（即fast一次访问两个节点，slow一次访问一个节点），那么跑得快的运动员一定能超过跑得慢的运动员一圈，也就是算法中slow等于fast的情形。
     * 如果跑道是直的，那么跑得快的运动员一定会先到达终点，也就是fast等于null的情形。
     */
    public boolean isLoopLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.getNext();

        while (true) {
            if (fast == null || fast.getNext() == null) {
                return false;
            } else if (fast == slow || fast.getNext() == slow) {
                return true;
            } else {
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }
        }
    }

}
