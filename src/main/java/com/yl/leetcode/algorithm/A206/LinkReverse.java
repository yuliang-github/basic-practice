package com.yl.leetcode.algorithm.A206;

import com.yl.leetcode.algorithm.A203.ListNode;

/**
 * @author Alex
 * @since 2019/6/21 10:16
 */
public class LinkReverse {

    /**
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */


    public static void main(String[] args) {

        ListNode listNode = new ListNode(new int[]{1,2,3,4,5,6});
        System.out.println(listNode);

        System.out.println(reverseList(listNode));


    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // 找到倒数第二个节点
        if(head.next.next == null){
            // 指针反转
            head.next.next = head;
            return head.next;
        }else {
            // 最终返回的是倒数第一个节点,也就是反转后的头结点
            ListNode node = reverseList(head.next);
            // 此处的head应该为倒数第三个节点
            // head.next为倒数第二个节点,反转指针
            head.next.next = head;
            head.next = null;
            return node;
        }
    }


}
