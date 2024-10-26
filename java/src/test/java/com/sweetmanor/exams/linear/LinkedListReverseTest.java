package com.sweetmanor.exams.linear;

import com.sweetmanor.datastructure.linear.ListNode;
import com.sweetmanor.util.CreateUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListReverseTest {

    @Test
    void reverse() {
        ListNode head = CreateUtil.createListNode(null, new int[]{1, 2, 3, 4, 5});
        ListNode ans = CreateUtil.createListNode(new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2, 1}); //使用自定义ID

        LinkedListReverse exam = new LinkedListReverse();
        assertEquals(ans, exam.reverse(head));
    }

}
