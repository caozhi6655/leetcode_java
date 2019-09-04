package com.github.caozhi6655.offer;

import com.github.caozhi6655.base.ListNode;

/**
 * @Description
 * @Author ht
 * @Date 2019/8/1 17:13
 */
public class 两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1, len2;
        ListNode tmp1 = pHead1;
        ListNode tmp2 = pHead2;
        len1 = len2 = 0;
        while (tmp1 != null) {
            len1++;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            len2++;
            tmp2 = tmp2.next;
        }

        if (len1 > len2) {
            int n = len1 - len2;
            while (n != 0) {
                pHead1 = pHead1.next;
                n--;
            }
        } else if (len1 < len2) {
            int n = len2 - len1;
            while (n != 0) {
                pHead2 = pHead2.next;
                n--;
            }
        }

        while (pHead1 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            } else {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return null;
    }

    public int JumpFloor(int target) {
        if (target == 1){
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 2) + 2;
        }
    }
}
