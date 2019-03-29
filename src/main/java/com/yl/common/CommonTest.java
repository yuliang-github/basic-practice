package com.yl.common;

import org.junit.Test;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author Alex
 * @since 2019/3/21 16:57
 */
public class CommonTest {

    private static final LongAdder longAdder = new LongAdder();

    private static StringBuilder sb = new StringBuilder("init");
    /**
     * ThreadLocal并不能解决变量共享的问题
     */
    private static ThreadLocal<StringBuilder> threadLocal = new ThreadLocal<StringBuilder>(){
        @Override
        protected StringBuilder initialValue() {
            return new StringBuilder("init");
        }
    };
    
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder append = threadLocal.get().append("1");
                System.err.println("线程1：" + append);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder append = threadLocal.get().append("2");
                System.err.println("线程2：" + append);
            }
        }).start();
    }

    @Test
    public void test(){

        print();

    }

    public void print(){
        longAdder.increment();
        System.err.println(longAdder.longValue());
        print();
    }

}
