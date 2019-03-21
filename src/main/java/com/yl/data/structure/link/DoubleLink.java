package com.yl.data.structure.link;

/**
 * @author Alex
 * @since 2019/3/21 15:20
 * 双端链表
 */
public class DoubleLink<T> {


    /**
     * 1.对于单项链表，我们如果想在尾部添加一个节点，那么必须从头部一直遍历到尾部，找到尾节点，
     *      然后在尾节点后面插入一个节点。这样操作很麻烦，如果我们在设计链表的时候多个对尾节点的引用，那么会简单很多。
     */

    private Node<T> head;

    private Node<T> tail;

    private volatile int size;

    public DoubleLink(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 添加元素,默认从头部添加
     * @param e
     * @return
     */
    public boolean put(T e){
        if(e == null){
            throw new NullPointerException("element can't be null");
        }
        Node<T> node = new Node<>(e);
        if(size == 0){
            head = node;
            tail = node;
        }else {
            node.next(head);
            head = node;
        }
        size++;
        return true;
    }

    /**
     * 添加元素,从尾部添加
     * @param e
     * @return
     */
    public boolean addTail(T e){
        if(e == null){
            throw new NullPointerException("element can't be null");
        }
        if(size == 0){
            return put(e);
        }
        Node<T> node = new Node<>(e);
        tail.next(node);
        tail = node;
        size++;
        return true;
    }

    /**
     * 根据下标获取数据
     * @param index
     * @return
     */
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("size is " + size);
        }
        int i = 0;
        Node<T> current = head;
        while (i < index){
            current = current.getNext();
            i++;
        }
        return current.getData();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        int i = 0;
        while (i < size){
            sb.append(current.toString());
            if(++i < size){
                sb.append(",");
            }
            current = current.getNext();
        }
        return sb.append("]").toString();
    }


    private class Node<T> {
        private T data;

        private Node<T> next;

        public Node(){

        }
        public Node(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void next(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }


}
