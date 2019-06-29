package com.yl.data.structure.Queue;

/**
 * @author yu.alex
 * @date 2019/6/28 14:54
 * @des
 */
public class QueueDemo {

    public static void main(String[] args) {

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);

        System.out.println(arrayQueue);

        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue);

        System.out.println("---------------------");

        LoopQueue<Integer> loopQueue = new LoopQueue<>(3);
        loopQueue.enqueue(1);
        loopQueue.enqueue(2);
        loopQueue.enqueue(3);
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println(loopQueue);
        loopQueue.enqueue(1);
        System.out.println(loopQueue);
        loopQueue.enqueue(4);
        System.out.println(loopQueue);


    }

}
