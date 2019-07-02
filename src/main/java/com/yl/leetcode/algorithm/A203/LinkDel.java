package com.yl.leetcode.algorithm.A203;

/**
 * @author yu.alex
 * @date 2019/7/1 12:45
 * @des
 */
public class LinkDel {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(arr);
        System.out.println(removeElements_1(listNode, 6));
    }

    /**
     * 除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     *
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */

    /**
     * 使用虚拟头结点
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while (tmp.next != null){
            if(tmp.next.val == val){
                tmp.next = tmp.next.next;
            }else {
                tmp = tmp.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * 使用递归方法
     */
    public static ListNode removeElements_1(ListNode head, int val) {
        if(head == null){
            return null;
        }
        // head之后的链表
        ListNode ret = removeElements_1(head.next, val);
        if(head.val == val){
            //如果head删除,则返回head之后的链表
            return ret;
        }else {
            // 如果head删除,则将head与head之后的链表链接起来
            head.next = ret;
            return head;
        }
    }

}
