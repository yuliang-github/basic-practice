package com.yl.data.test.structure;

import com.yl.encrypt.ByteUtils;
import org.junit.Test;

/**
 * @author Alex
 * @since 2019/4/9 10:10
 */
public class ByteTest {

    public static void main(String[] args) {

        int i = 127;

        byte b = (byte) i;

        System.err.println(ByteUtils.getByteStr(b));

    }

    @Test
    public void demo_1(){

        int i = 127;

        byte b_24 = (byte)(i & 0xFF);

        System.err.println(ByteUtils.getByteStr(b_24));
    }

    @Test
    public void demo_2(){

        int i = Integer.parseInt("0000000101111111", 2);

        System.err.println(i);

        int v = 127 | 256;

        System.out.println(v);
    }

    @Test
    public void demo_3(){

        boolean b = true;

        System.err.println(b);

    }

}
