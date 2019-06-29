package com.yl.data.structure.stack;

/**
 * @author yu.alex
 * @date 2019/6/27 15:06
 * @des 实现栈结构
 */
public interface Stack<E> {

    default public void push(E e){

    }

    default public E pop(){

        return null;
    }

    default public E peek(){

        return null;
    }

    default int size(){

        return 0;
    }
}
