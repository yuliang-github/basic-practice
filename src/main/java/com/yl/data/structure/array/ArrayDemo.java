package com.yl.data.structure.array;

/**
 * @author Alex
 * @since 2019/6/21 10:50
 */
public class ArrayDemo {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.err.println(arr);

        System.err.println(arr.get(3));

        System.err.println(arr.delete(3));

        System.err.println(arr);
    }

}
