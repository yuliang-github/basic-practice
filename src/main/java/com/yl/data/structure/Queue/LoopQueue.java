package com.yl.data.structure.Queue;

/**
 * @author yu.alex
 * @date 2019/6/28 15:00
 * @des
 */
public class LoopQueue<E> implements Queue<E>{

    /**
     * head = tail说明队列为空
     * (tail+1)%C == head说明队列已满
     */
    private int head;
    private int tail;
    private int size;
    private E[] data;

    public LoopQueue(int capacity){
        this.head = 0;
        this.tail = 0;
        // 会浪费一个空间
        this.data = (E[])new Object[capacity+1];
    }

    public LoopQueue(){
        this(16);
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length == head){
            this.resize(data.length+1);
        }
        // 缩容操作先不实现
        data[tail] = e;
        size++;
        tail = (tail+1) % data.length;
    }

    private void resize(int minCapacity){
        int newCapacity = data.length + (data.length >> 1);
        if(newCapacity < minCapacity){
            newCapacity = minCapacity;
        }
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+head)%data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if(this.isEmpty()){
            return null;
        }
        E ret = data[head];
        data[head] = null;
        size--;
        head = (head+1)%data.length;
        return ret;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for(int i=head; i != tail; i = (i+1)%data.length){
            sb.append(data[i]);
            if((i+1) % data.length != tail){
                sb.append(",");
            }
        }
        return sb.append("]").toString();
    }
}
