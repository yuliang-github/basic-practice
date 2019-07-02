package com.yl.data.structure.stack;

import org.junit.Test;
import sun.applet.Main;

import javax.sound.midi.SysexMessage;

/**
 * @author yu.alex
 * @date 2019/6/27 15:21
 * @des
 */
public class StackDemo {

    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.err.print(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    @Test
    public void demo_1(){

        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        System.out.println(linkedStack);

        System.out.println(linkedStack.pop());
        System.out.println(linkedStack);

    }
}
