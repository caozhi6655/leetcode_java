package com.github.caozhi6655.offer;

import com.github.caozhi6655.base.ListNode;

/**
 * @Description
 * @Author ht
 * @Date 2019/8/1 16:34
 */
public class 链表中倒数第k个节点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode front = head;
        ListNode back = head;
        int i = 0;
        while (i < k && front != null) {
            i++;
            front = front.next;
        }

        if (i < k) {
            return null;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }
}
