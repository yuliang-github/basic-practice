package com.yl.data.test.structure;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alex
 * @since 2019/5/20 14:04
 */
public class MapTest {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("2", 1);

        String key = "2";
        int  h = 0;
        int hashcode = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        System.err.println(hashcode);

        Map<String,Integer> cmap = new ConcurrentHashMap<>();

    }

    @Test
    public void demo_1(){
        System.err.println(0x7fffffff);
        System.err.println(Integer.MAX_VALUE);

        int steps = countWays(3);
        System.err.println(steps);

    }



    int countWays (int n)
    {if (n<0)
        return 0;
        if (n==0)
            return 1;
        else
        {
            return countWays(n-1)+countWays(n-2)+countWays(n-3);
        }
    }

}
