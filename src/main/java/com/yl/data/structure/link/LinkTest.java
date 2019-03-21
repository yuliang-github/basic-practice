package com.yl.data.structure.link;

import org.junit.Test;

/**
 * @author Alex
 * @since 2019/3/21 10:33
 */
public class LinkTest {


    @Test
    public void singleTest(){

        SingleLink<Integer> singleLink = new SingleLink<Integer>();

        singleLink.put(1);
        singleLink.put(2);
        singleLink.put(3);
        singleLink.put(4);
        singleLink.put(5);

        System.err.println(singleLink);

        System.err.println("------------");
        System.err.println(singleLink.del(4));
        System.err.println(singleLink);


    }

    @Test
    public void doubleTest(){
        DoubleLink<Integer> doubleLink = new DoubleLink<>();
//        doubleLink.put(1);
//        doubleLink.put(2);
//        doubleLink.put(3);
//        doubleLink.put(4);
        System.err.println(doubleLink);

        doubleLink.addTail(5);
        doubleLink.addTail(6);
        doubleLink.addTail(7);
        System.err.println(doubleLink);

        System.err.println(doubleLink.get(0));

        System.err.println(doubleLink.get(2));
    }

    @Test
    public void bothWayTest(){
        BothWayLink<Integer> bothWayLink = new BothWayLink<>();

        bothWayLink.put(1);
        bothWayLink.put(2);
        bothWayLink.put(3);
        bothWayLink.put(4);
        bothWayLink.put(5);
        bothWayLink.put(6);
        bothWayLink.put(7);
        bothWayLink.put(8);
        System.err.println(bothWayLink);

//        bothWayLink.addTail(5);
//        bothWayLink.addTail(7);
//        System.err.println(bothWayLink);

        System.err.println(bothWayLink.get(6));
    }


}