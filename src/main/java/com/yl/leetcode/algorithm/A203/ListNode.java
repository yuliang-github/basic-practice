package com.yl.leetcode.algorithm.A203;

/**
 * @author yu.alex
 * @date 2019/7/1 12:50
 * @des
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr){
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        ListNode tmp = this;
        while (tmp != null){
            sb.append(tmp.val).append(",");
            tmp = tmp.next;
        }

        return sb.deleteCharAt(sb.length()-1).append("]").toString();
    }
}