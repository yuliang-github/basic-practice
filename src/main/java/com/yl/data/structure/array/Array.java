package com.yl.data.structure.array;

import com.google.common.base.Joiner;

import java.util.Arrays;

/**
 * @author Alex
 * @since 2019/6/21 11:07
 * 自定义数组
 */
public class Array<E> {

    private Object[] data;

    private int size;

    /**
     * 构造函数 自定义初始容量
     * @param capacity
     */
    public Array(int capacity){
        this.data = new Object[capacity];
        this.size = 0;
    }

    /**
     * 构造函数 默认初始容量16
     */
    public Array(){
        this(16);
    }

    /**
     * 获取数组大小
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){
        if(size == data.length){
            // 扩容
            resize(data.length + 1);
        }
        data[size++] = e;
    }

    private void resize(int minsize){
        int newCapacity = data.length + (data.length >> 1);
        if(newCapacity < minsize){
            newCapacity = minsize;
        }
        if(newCapacity > Integer.MAX_VALUE){
            newCapacity = Integer.MAX_VALUE;
        }
        data = Arrays.copyOf(data, newCapacity);
    }


    /**
     * 根据下标获取元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return (E)data[index];
    }

    /**
     * 是否包含元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (Object datum : data) {
            if(e.equals(datum)){
                return true;
            }
        }
        return false;
    }

    /**
     * 根据下标删除元素
     * @param index
     */
    public E delete(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E e = (E)data[index];
        for(int i = index + 1; i < size; i++){
               data[i-1] = data[i];
        }
        size--;
        return e;
    }

    @Override
    public String toString() {

        String join = "[" + Joiner.on(",").skipNulls().join(data).concat("]");

        return join;
    }
}
