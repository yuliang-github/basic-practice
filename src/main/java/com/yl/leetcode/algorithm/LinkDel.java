package com.yl.leetcode.algorithm;

import com.yl.data.structure.link.SingleLink;

/**
 * @author Alex
 * @since 2019/5/30 15:02
 */
public class LinkDel {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */

    public static void main(String[] args) {
        SingleLink<Integer> l1 = new SingleLink<>();
        l1.put(1);l1.put(2);l1.put(3);l1.put(4);l1.put(5);l1.put(6);
        System.err.println(l1);
        System.err.println(delOne(l1, 4));

    }

    /**
     * 方法一 : 两次循环
     *  1.遍历到链表尾部,得到链表长度size
     *  2.再从链表头部向后移动size - index - 1位
     */
    public static Integer delOne(SingleLink<Integer> link,int index){
        SingleLink.Node<Integer> node = link.getHeadNode();
        int size = 0;
        while (node != null){
            size++;
            node = node.getNext();
        }
        int num = size - index;
        SingleLink.Node<Integer> pre = link.getHeadNode();
        while(num-- > 0){
            pre = pre.getNext();
        }
        return pre.getData();
    }



    /**
     * 方法二 : 一次循环
     *  1.使用两个指针
     *  2.指针X、指针Y,先将X从头部移动到n为,则X = Y + n
     *  3.将指针X、Y一起向尾部移动,知道X到达链表尾节点
     *  4.此时Y指针指向的节点则为倒数第n个节点Y = X - n
     */


}
