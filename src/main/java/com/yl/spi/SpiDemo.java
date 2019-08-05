package com.yl.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author YU.11104989
 * @date 2019/8/5 15:34
 */
public class SpiDemo {

    public static void main(String[] args) {

        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);

        Iterator<Animal> iterator = animals.iterator();

        while (iterator.hasNext()){
            Animal animal = iterator.next();
            animal.say();
        }


    }

}
