package com.yl.data.structure.link;

/**
 * @author yu.alex
 * @date 2019/6/30 15:14
 * @des
 */
public class LinkDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);

        System.out.println(linkedList.get(2));

        System.out.println(linkedList.del(1));
        System.out.println(linkedList);

    }

}
