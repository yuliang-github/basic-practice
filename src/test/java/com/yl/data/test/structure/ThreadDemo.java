package com.yl.data.test.structure;

/**
 * @author Alex
 * @since 2019/5/31 16:20
 */
public class ThreadDemo {

    public static void main(String[] args) throws Exception{

        TheadClass theadClass = new TheadClass();

        new Thread(theadClass).start();

        while (true){
            //Thread.currentThread().sleep(5);
            if(theadClass.isFlag())
            System.err.println("------------");
        }
    }

    public static class TheadClass implements Runnable {

        private volatile boolean flag = false;

        @Override
        public void run() {

            try {
                Thread.currentThread().sleep(1000);
                flag = true;
                System.err.println("set true");
            }catch (Exception e){

            }

        }

        public boolean isFlag(){
            return flag;
        }
    }

}
