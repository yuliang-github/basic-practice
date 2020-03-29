package com.yl.data.structure.tree;

import com.yl.data.structure.Queue.ArrayQueue;
import com.yl.data.structure.Queue.Queue;
import com.yl.data.structure.stack.ArrayStack;
import com.yl.data.structure.stack.Stack;

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

        @Override
        public String toString() {
            return e.toString();
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

    /**
     * 添加元素
     * @param e
     */
    public void add(E e) {

       root = add(root, e);

    }

    private Node add(Node root, E e) {

        if (root == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(root.e) < 0) {
            root.left = add(root.left, e);
        } else if (e.compareTo(root.e) > 0){
            root.right = add(root.right, e);
        }
        return root;
    }

    /**
     * 是否包含某元素
     * @param e
     * @return
     */
    public boolean contains(E e) {

        return contains(root, e);

    }

    private boolean contains(Node root, E e) {

        if (root == null) {
            return false;
        }

        if (e.compareTo(root.e) == 0) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            // 查询左子树
            return contains(root.left, e);
        } else if (e.compareTo(root.e) > 0) {
            // 查询右子树
            return contains(root.right, e);
        }
        return false;
    }

    /**
     * 前序遍历-递归
     * 根节点 - 左子树 - 右子树
     */
    public void preTraverse(){
        preTraverse(root);
    }

    private void preTraverse(Node root) {

        if (root == null) {
            return;
        }

        System.out.println(root);

        preTraverse(root.left);

        preTraverse(root.right);

    }

    /**
     * 前序遍历-非递归
     * 根节点 - 左子树 - 右子树
     */
    public void preTraverseNR(){

        if (root == null) {
            return;
        }

        Stack<Node> stack = new ArrayStack<>();

        stack.push(root);

        while (!(stack.size() == 0)) {

            Node cur = stack.pop();

            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }


    }


    /**
     * 中序遍历
     * 左子树 - 根节点 - 右子树
     */
    public void inTraverse() {

        inTraverse(root);

    }

    private void inTraverse(Node root) {

        if (root == null) {
            return;
        }

        inTraverse(root.left);

        System.out.println(root);

        inTraverse(root.right);

    }

    /**
     * 中序遍历-非递归
     * 左子树 - 根节点 - 右子树
     */
    public void inTraverseNR(){

        Stack<Node> stack = new ArrayStack<>();

        Node tmp = root;

        while ((tmp != null) || stack.size() > 0 ) {

            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }

            tmp = stack.pop();

            System.out.println(tmp.e);

            tmp = tmp.right;
        }

    }

    /**
     * 后序遍历
     * 左子树 - 右子树 - 根节点
     */
    public void postTraverse() {
        postTranverse(root);
    }

    private void postTranverse(Node root) {

        if (root == null) {
            return;
        }

        postTranverse(root.left);

        postTranverse(root.right);

        System.out.println(root);

    }

    /**
     * 后序遍历-非递归
     * 左子树 - 右子树 - 根节点
     */
    public void postTraverseNR() {

        if (root == null) {
            return;
        }

        Stack<Node> src = new ArrayStack<>();
        src.push(root);

        Stack<Node> res = new ArrayStack<>();

        while (src.size() > 0) {

            Node node = src.pop();

            res.push(node);

            if (node.left != null) {
                src.push(node.left);
            }

            if (node.right != null) {
                src.push(node.right);
            }

        }

        while (res.size() > 0) {
            System.out.println(res.pop());
        }

    }

    /**
     * 层序遍历
     */
    public void levelTraverse() {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayQueue<>();

        queue.enqueue(root);

        while (!queue.isEmpty()) {

            Node node = queue.dequeue();

            System.out.println(node);

            if (node.left != null) {
                queue.enqueue(node.left);
            }

            if (node.right != null) {
                queue.enqueue(node.right);
            }

        }

    }

}
