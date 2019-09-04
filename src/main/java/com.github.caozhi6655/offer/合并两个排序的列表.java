package com.github.caozhi6655.offer;


import com.github.caozhi6655.base.ListNode;

/**
 * @Description
 * @Author ht
 * @Date 2019/8/1 16:20
 */
public class 合并两个排序的列表 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = null;
        if (list1.val > list2.val) {
            res = list1;
            res.next = Merge(list1.next, list2);
        } else {
            res = list2;
            res.next = Merge(list1, list2.next);
        }
        return res;
    }
}
