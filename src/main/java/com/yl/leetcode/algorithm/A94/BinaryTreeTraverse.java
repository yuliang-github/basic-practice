package com.yl.leetcode.algorithm.A94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Alex
 * @since 2019/6/20 14:02
 */
public class BinaryTreeTraverse {

    /**
     * 给定一个二叉树，返回它的中序遍历。
     *
     * 中序遍历:左子树->根节点->右子树
     * 前序遍历:根节点->左子树->右子树
     * 后序遍历:左子树->右子树->根节点
     *
     */
    public static void main(String[] args) {

        BinaryTree<String> root = new BinaryTree<>("A");
        root.left(new BinaryTree<>("B").right(new BinaryTree<>("C").left(new BinaryTree<>("D"))));
        root.right(new BinaryTree<>("E").right(new BinaryTree<>("F")
        .left(new BinaryTree<>("G").left(new BinaryTree<>("H")).right(new BinaryTree<>("K")))));

        System.err.println(traverse_recursive(root,new ArrayList<>()));
        System.err.println(traverse_stack(root,new ArrayList<>()));
    }

    /**
     * 递归方式
     */
    public static <T> List<T> traverse_recursive(BinaryTree<T> root,List<T> list){
        if(root != null){
            // 先遍历左子树
            traverse_recursive(root.left(), list);
            // 根节点
            list.add(root.getData());
            // 最后遍历右子树
            traverse_recursive(root.right(),list);
        }
        return list;
    }

    /**
     * 使用栈存储左子树法
     */
    public static <T> List<T> traverse_stack(BinaryTree<T> root,List<T> list){
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree<T> tmp = root;
        while (tmp != null || !stack.isEmpty()){
           while (tmp != null){
               stack.push(tmp);
               tmp = tmp.left();
           }

           tmp = stack.pop();
           list.add(tmp.getData());
           tmp = tmp.right();

        }
        return list;
    }


}
