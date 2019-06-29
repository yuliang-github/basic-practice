package com.yl.data.structure.Queue;

import com.yl.data.structure.array.Array;

/**
 * @author yu.alex
 * @date 2019/6/28 14:35
 * @des
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capactity){
        this.array = new Array<>(capactity);
    }

    public ArrayQueue(){
        this(16);
    }

    /**
     * 从尾部部添加元素
     * @param e
     */
    @Override
    public void enqueue(E e) {
        this.array.addLast(e);
    }

    @Override
    public E dequeue() {
        return this.array.delete(0);
    }

    @Override
    public int size() {
        return this.array.size();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public String toString() {
        return this.array.toString();
    }
}
