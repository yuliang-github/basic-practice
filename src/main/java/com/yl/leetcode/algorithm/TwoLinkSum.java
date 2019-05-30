package com.yl.leetcode.algorithm;

import com.yl.data.structure.link.SingleLink;

/**
 * @author Alex
 * @since 2019/5/30 10:23
 */
public class TwoLinkSum {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static void main(String[] args) {
        SingleLink<Integer> l1 = new SingleLink<>();
        l1.put(9);l1.put(3);l1.put(4);l1.put(2);
        SingleLink<Integer> l2 = new SingleLink<>();
        l2.put(1);l2.put(4);l2.put(6);l2.put(5);

        SingleLink<Integer> link = twoLinkSum(l1, l2);
        System.err.println(link.toString());
    }


    public static SingleLink<Integer> twoLinkSum(SingleLink<Integer> l1,SingleLink<Integer> l2){
        SingleLink<Integer> link = new SingleLink<>();

        SingleLink.Node<Integer> next_1 = l1.getHeadNode();
        SingleLink.Node<Integer> next_2 = l2.getHeadNode();
        int next_add = 0;
        do {
            int data_1 = next_1 == null?0:next_1.getData();
            int data_2 = next_2 == null?0:next_2.getData();
            int sum = data_1 + data_2 + next_add;
            int current = sum % 10;
            link.put(current);
            next_add = (sum - current)/10;
            next_1 = next_1 == null?null:next_1.getNext();
            next_2 = next_2 == null?null:next_2.getNext();
        }while (next_1 != null || next_2 != null || next_add > 0);
        return link;
    }

}
