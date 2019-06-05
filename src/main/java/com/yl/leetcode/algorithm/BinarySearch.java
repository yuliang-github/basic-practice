package com.yl.leetcode.algorithm;

/**
 * @author Alex
 * @since 2019/6/5 15:17
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8};

        System.err.println(search(arr, 1));

        int s = 1;

        int s1 = (s << 31);

        System.err.println(s1);

        int a = 0x7fffffff;

        int b = 1;

        int i = a + b;

        System.err.println(i);

    }

    /**
     * 位移算法:
     *  << 将所有二进制位向左移,高位移出则舍弃,低位补零
     *  >> 带符号右移,将所有二进制位向右移,低位移出则舍弃,高位补符号位,即正数补0,负数补1
     *  >>> 无符号右移,将所有二进制位向右移,低位移出则舍弃,高位补0
     */

    public static int search(int[] arr,int num){
        int max = arr.length;
        int min = 0;
        while (min <= max){
            // int mid = (max+min)/2 有bug,假设min和max很大,相加会超出int范围,导致高位被舍弃,而变成负数,超出数组范围
            int mid = min + ((max - min) >> 1);
            if (num > arr[mid]){
                min = mid + 1;
            }else if (num < arr[mid]){
                max = mid - 1;
            }else {
                return mid;
            }
        }

        return -1;
    }

}
