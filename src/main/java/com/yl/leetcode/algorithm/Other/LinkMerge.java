package com.yl.leetcode.algorithm.Other;

import com.yl.leetcode.algorithm.A203.ListNode;

/**
 * 链表合并
 * @author yu.alex
 * @date 2020/3/30 11:23
 * @des
 */
public class LinkMerge {


    public static void main(String[] args) {

        ListNode link_1 = new ListNode(new int[]{1,3,5,7,9});

        ListNode link_2 = new ListNode(new int[]{2,4,6});

        //System.out.println(linkMerge(link_1, link_2));

        System.out.println(linkMergeRecursive(link_1, link_2));
    }

    /**
     * 链表合并
     * 例如 ： 1->3->5->7->9 & 2->4->6
     * 合并成  1->2->3->4->5->6->7->9
     * @param link_1
     * @param link_2
     * @return
     */
    private static ListNode linkMerge(ListNode link_1, ListNode link_2) {

        // 虚拟头结点
        ListNode res = new ListNode(0);

        ListNode tmp = res;

        while (link_1 != null && link_2 != null) {

            if (link_1.val <= link_2.val) {

                tmp.next = link_1;
                link_1 = link_1.next;

            } else {

                tmp.next = link_2;
                link_2 = link_2.next;

            }

            tmp = tmp.next;

        }

        if (link_1 != null) {
            tmp.next = link_1;
        }

        if (link_2 != null) {
            tmp.next = link_2;
        }

        return res.next;
    }


    /**
     * 链表合并-递归方式
     * 例如 ： 1->3->5->7->9 & 2->4->6
     * 合并成  1->2->3->4->5->6->7->9
     * @param link_1
     * @param link_2
     * @return
     */
    private static ListNode linkMergeRecursive(ListNode link_1, ListNode link_2) {

        if (link_1 == null) {
            return link_2;
        } else if (link_2 == null) {
            return link_1;
        } else {

            ListNode head;

            if (link_1.val < link_2.val) {
                head = link_1;
                head.next = linkMergeRecursive(link_1.next, link_2);
            } else {
                head = link_2;
                head.next = linkMergeRecursive(link_1, link_2.next);
            }

            return head;
        }

    }

}
