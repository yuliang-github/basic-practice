package com.yl.data.test.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yu.alex
 * @date 2019/7/1 16:10
 * @des
 */
public class JconsoleDemo {

    public static void main(String[] args) throws Exception{

        List<OOMObject> list = new ArrayList<>();

        int i=1;
        while (true){
            System.out.println(i++);
            list.add(new OOMObject());
            Thread.currentThread().sleep(500);
        }


    }

    public static class OOMObject {
        public byte[] data = new byte[64*1024];
    }
}
