package com.yl.data.structure.stack;

import com.yl.data.structure.array.Array;

/**
 * @author yu.alex
 * @date 2019/6/27 15:12
 * @des 基于动态数组实现栈
 */
public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        this(16);
    }


    @Override
    public void push(E e) {
        this.array.addFirst(e);
    }

    @Override
    public E pop() {
        return this.array.delete(0);
    }

    @Override
    public E peek() {
        return this.array.get(0);
    }

    @Override
    public int size() {
        return array == null ? 0 : array.size();
    }

    @Override
    public String toString() {
        return this.array.toString();
    }
}
