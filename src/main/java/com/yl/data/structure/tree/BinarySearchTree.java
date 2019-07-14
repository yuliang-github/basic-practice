package com.yl.data.structure.tree;

/**
 * @author yu.alex
 * @date 2019/7/14 12:38
 * @des
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
