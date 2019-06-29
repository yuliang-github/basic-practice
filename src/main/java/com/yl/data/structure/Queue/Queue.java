package com.yl.data.structure.Queue;

/**
 * @author yu.alex
 * @date 2019/6/28 14:33
 * @des
 */
public interface Queue<E> {

    public void enqueue(E e);

    public E dequeue();

    public int size();

    public boolean isEmpty();

}
