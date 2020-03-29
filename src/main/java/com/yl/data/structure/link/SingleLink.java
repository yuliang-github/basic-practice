package com.yl.data.structure.link;

/**
 * @author Alex
 * @since 2019/3/21 10:04
 * 单向链表
 */
public class SingleLink<T> {

    /**
     * 1.单链表是链表中结构最简单的。一个单链表的节点(Node)分为两个部分,
     *      第一个部分(data)保存或者显示关于节点的信息，另一个部分存储下一个节点的地址。最后一个节点存储地址的部分指向空值。
     *
     * 2.单向链表只可向一个方向遍历，一般查找一个节点的时候需要从第一个
     *      节点开始每次访问下一个节点，一直访问到需要的位置。而插入一个节点，对于单向链表，我们只提供在链表头插入，
     *      只需要将当前插入的节点设置为头节点，next指向原头节点即可。删除一个节点，我们将该节点的上一个节点的next
     *      指向该节点的下一个节点。
     */


    private Node<T> head;

    private volatile int size;

    public SingleLink(){
        this.size = 0;
        this.head = null;
    }

    /**
     * 存入数据
     *  1.每次数据加入到头部
     *  2.将头部的next置为上一个头部
     * @param e
     * @return
     */
    public boolean put(T e){
        if(e == null){
            throw new NullPointerException("element can't be null");
        }
        Node<T> node = new Node<T>(e);
        if(size == 0){
            head = node;
        }else{
            node.next(head);
            head = node;
        }
        size++;
        return true;
    }

    /**
     * 根据下标获取数据,从0开始
     * @param index
     * @return
     */
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("size is " + size);
        }
        int i= 0;
        Node<T> current = head;
        while(i < index){
            current = current.getNext();
            i++;
        }
        return current.getData();
    }

    public Node<T> getHeadNode(){
        return this.head;
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
        int i = 0;
        Node<T> current = head;
        Node<T> delPre = null;
        while (i++ < index){
            delPre = current;
            current = current.getNext();
        }
        if (delPre != null){
            delPre.next(current.getNext());
        }else{
            // 说明删除的头
            head = current.getNext();
        }
        size--;
        return current.getData();
    }

    /**
     * 递归添加
     * @param e
     */
    public void addTail(T e) {

        head = add(head, e);

    }

    private Node add(Node head, T e) {

        if (head == null) {
            head = new Node(e);
            size++;
            return head;
        }

        head.next = add(head.next, e);

        return head;
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

    public static class Node<T> {
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
