package com.yl.data.structure.link;

import java.util.Comparator;

/**
 * @author Alex
 * @since 2019/3/22 10:07
 * 双端有序链表
 */
public class SortedBothWayLink<T> {

    private Node<T> head;
    private Node<T> tail;
    private volatile int size;
    private Comparator<T> comparator;

    public SortedBothWayLink(Comparator<T> comparator) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.comparator = comparator;
    }

    /**
     * 添加元素,默认从小到大排序
     * @param e
     * @return
     */
    public boolean put(T e){
        return this.put(e, comparator);
    }

    /**
     * 添加元素,自定义排序规则
     * @param e
     * @param comparator
     * @return
     */
    public boolean put(T e, Comparator<T> comparator){
        if(e == null){
            throw new NullPointerException("element can't be null");
        }
        Node<T> node = new Node<>(e);
        if(size++ == 0){
            // size==0,说明链表为空
            head = node;
            tail = node;
            return true;
        }
        Node<T> current = head;
        Node<T> pre = null;
        Node<T> next = null;
        while (current != null && comparator.compare(e, current.getData())<0){
            pre = current;
            next = current.getNext();
            current = current.getNext();
        }
        if(pre == null){
            // pre为空,说明是插入到首位
            node.next(head);
            head.pre(node);
            head = node;
            return true;
        }
        if(next == null){
            // next为空,说明是插入到尾部
            node.pre(tail);
            tail.next(node);
            tail = node;
            return true;
        }
        // 插入到中间
        pre.next(node);
        next.pre(node);
        node.pre(pre);
        node.next(next);
        return true;
    }


    private class Node<T>{
        private T data;

        private Node<T> next;

        private Node<T> pre;

        private Node(){

        }
        public Node(T e){
            this.data = e;
        }

        public void next(Node<T> next){
            this.next = next;
        }

        public Node<T> getNext(){
            return this.next;
        }

        public void pre(Node<T> pre){
            this.pre = pre;
        }

        public Node<T> getPre(){
            return this.pre;
        }

        public T getData(){
            return this.data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        for(int i=0;i<size;i++){
            sb.append(current.getData().toString());
            if(i < size - 1){
                sb.append(",");
            }
            current = current.getNext();
        }
        return sb.append("]").toString();
    }
}
