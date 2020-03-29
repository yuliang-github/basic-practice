package com.yl.data.structure.tree;

/**
 * @author yu.alex
 * @date 2020/3/29 19:25
 * @des
 */
public class TreeDemo {

    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(6);
        tree.add(8);
        tree.add(4);
        tree.add(2);

        tree.preTraverse();
        System.out.println("||||||||||");
        tree.preTraverseNR();
        System.out.println("---------");
        tree.inTraverse();
        System.out.println("||||||||||");
        tree.inTraverseNR();
        System.out.println("---------");
        tree.postTraverse();
        System.out.println("||||||||||");
        tree.postTraverseNR();

    }



}
