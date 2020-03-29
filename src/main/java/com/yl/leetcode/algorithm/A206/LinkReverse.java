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

        ListNode listNode = new ListNode(new int[]{1,2,3,4});
        System.out.println(listNode);

        ListNode reverseList = reverseList(listNode);

        System.out.println(reverseList);


    }

    /**
     * 链表反转
     * 1->2->3->4
     * 将链表拆分成小链表 1,2,(3->4)
     * 1.反转小链表 1->2->(3<-4)
     * 2.继续反转 1->(2<-3<-4)
     * 3.继续反转 (1<-2<-3<-4)
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){

        if(head == null || head.next == null){
            return head;
        }

        // 将链表拆分成长度为2的小链表
        if(head.next.next == null){

            // 指针反转
            head.next.next = head;
            ListNode node = head.next;
            head.next = null;
            return node;

        }else {

            // 反转后的链表
            ListNode node = reverseList(head.next);

            // 此处的head应该为倒数第三个节点
            // head.next为倒数第二个节点,反转指针
            head.next.next = head;
            head.next = null;

            return node;
        }
    }


}
