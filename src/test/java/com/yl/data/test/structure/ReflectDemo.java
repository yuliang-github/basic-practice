package com.yl.data.test.structure;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author YU.11104989
 * @date 2019/8/8 20:10
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception{

        Class<DemoBean> clazz = DemoBean.class;

        Field field = clazz.getDeclaredField("data");

        DemoBean instance = clazz.newInstance();
        boolean mod = Modifier.isPrivate(field.getModifiers());
        System.out.println(mod);
        //field.setAccessible(true);
        field.set(instance, "北欧");

        System.err.println(instance);
    }
    
    
    static class DemoBean {
        // private String data;
        public String data;

        @Override
        public String toString() {
            return data;
        }
    }
    
}
