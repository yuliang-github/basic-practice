package com.yl.data.structure.tree;

/**
 * @author Alex
 * @since 2019/6/20 14:32
 * 简单的二叉树
 */
public class BinaryTree<T> {

    private T data;

    private BinaryTree<T> left;

    private BinaryTree<T> right;

    public BinaryTree(T data){
        this.data = data;
    }

    public BinaryTree left(BinaryTree<T> left){
        this.left = left;
        return this;
    }

    public BinaryTree left(){
        return left;
    }

    public BinaryTree right(BinaryTree<T> right){
        this.right = right;
        return this;
    }

    public BinaryTree right(){
        return right;
    }

    public T getData(){
        return this.data;
    }
}
