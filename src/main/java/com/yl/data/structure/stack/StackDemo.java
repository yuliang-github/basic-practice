package com.yl.data.structure.stack;

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

    }

}
