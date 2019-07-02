package com.yl.data.structure.link;

/**
 * @author yu.alex
 * @date 2019/6/30 11:44
 * @des
 */
public class LinkedList<E> {

    private class Node {
         private E data;
         private Node next;

         public Node(){

         }
         public Node(E e,Node next){
             this.data = e;
             this.next = next;
         }
         public Node(E e){
             this(e,null);
         }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data == null?"":data.toString();
        }
    }


   // private Node head;
    private int size;

    // 虚拟头结点
    private Node dummyHead;
    // 可以添加尾指针指向最后一个节点,使向尾部添加元素添加成为O(1)复杂度
    // 使用tail实现FIFO的队列,此处不进行实现
    //private Node tail;

    public LinkedList(){
        //head = null;
        size = 0;
        dummyHead = this.new Node();
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在尾部添加元素
     * @param e
     */
    public void add(E e){
//        Node node = this.new Node(e);
//        if(this.isEmpty()){
//            head = node;
//        }else {
//            Node tmp = head;
//            for(int i=0; i<size-1;i++){
//                tmp = tmp.next;
//            }
//            tmp.next = node;
//        }
        this.add(e, size);
    }

    /**
     * 在头部添加元素
     * @param e
     */
    public void addFirst(E e){
        //Node node = this.new Node(e);
        //node.next = head;
        //head = node;
        //head = this.new Node(e, head);
        dummyHead.next = this.new Node(e, dummyHead.next);
        size++;
    }

    /**
     * 在指定索引处添加元素
     * @param e
     * @param index
     */
    public void add(E e,int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node pre = dummyHead;
        for(int i=0; i < index; i++){
            pre = pre.next;
        }
        //Node node = this.new Node(e,pre.next);
        pre.next = this.new Node(e,pre.next);
        size++;
    }

    /**
     * 根据索引获取元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node cur = dummyHead;
        while (index-- >= 0){
            cur = cur.next;
        }
        return cur.getData();
    }

    /**
     *  删除index位置的元素
     * @param index
     * @return
     */
    public E del(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node pre = dummyHead;
        for (int i=0; i<index; i++){
            pre = pre.next;
        }
        Node del = pre.next;
        pre.next = del.next;
        size--;
        return del.getData();
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.getData().toString())
                    .append(",");
            cur = cur.next;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.append("]").toString();
    }
}
