package com.yl.data.structure.link;

/**
 * @author Alex
 * @since 2019/3/21 15:54
 * 双向链表
 */
public class BothWayLink<T> {

    private Node<T> head;

    private Node<T> tail;

    private volatile int size;

    public BothWayLink(){
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
        }else{
            node.next(head);
            head.pre(node);
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
            return this.put(e);
        }
        Node<T> node = new Node<>(e);
        tail.next(node);
        node.pre(tail);
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
        Node<T> current = null;
        if(index<<1 > size){
            // 从尾部开始遍历
            current = tail;
            for(int i=size-1;i > index;i--){
                current = current.getPre();
            }
        }else{
            // 从头部开始遍历
            current = head;
            for(int i=0;i < index;i++){
                current = current.getNext();
            }
        }
        return current.getData();
    }

    /**
     * 根据下标删除元素
     * @param index
     * @return
     */
    public T del(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("size is " + size);
        }
        Node<T> current = null;
        if(index<<1 > size){
            // 从尾部遍历删除元素
            current = tail;
            for(int i=size-1;i>index;i--){
                current = current.getPre();
            }
        }else {
            // 从头部遍历删除元素
            current = head;
            for(int i=0;i<index;i++){
                current = current.getNext();
            }
        }
        Node<T> pre = current.getPre();
        Node<T> next = current.getNext();
        if(pre == null && next == null){
            // pre、next都为空说明只有一个元素
            head = null;tail = null;
        }else {
            if(next == null){
                /**
                 * 删除元素的next为空,说明删除的是尾部
                 *  1.将删除元素的Pre置为tail
                 *  2.将新tail的next置为空
                 */
                tail = pre;
                tail.next(null);
            }else if(pre == null){
                /**
                 * 删除元素的pre为空,说明删除的是头部
                 *  1.将删除元素的next置为head
                 *  2.将新head的pre置为空
                 */
                head = next;
                head.pre(null);
            }else {
                /**
                 * 删除元素的next、pre都不为空,说明删除的是中间元素
                 *  1.将删除元素的pre及next连接起来
                 */
                pre.next(next);
                next.pre(pre);
            }
        }
        size--;
        return current.getData();
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
        for(int i=0;i < size;i++){
            sb.append(current.toString());
            if (i < size - 1){
                sb.append(",");
            }
            current = current.getNext();
        }
        return sb.append("]").toString();
    }
}
