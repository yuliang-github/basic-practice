package com.yl.data.structure.stack;

import com.yl.data.structure.link.LinkedList;

/**
 * @author yu.alex
 * @date 2019/6/30 21:58
 * @des
 */
public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> link;

    public LinkedStack(){
        this.link = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        this.link.addFirst(e);
    }

    @Override
    public E pop() {
        return this.link.del(0);
    }

    @Override
    public E peek() {
        return this.link.get(0);
    }

    @Override
    public int size() {
        return this.link.size();
    }

    @Override
    public String toString() {
        return this.link.toString();
    }
}
