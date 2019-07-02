package com.yl.leetcode.algorithm.Other;

/**
 * @author yu.alex
 * @date 2019/7/1 13:24
 * @des
 */
public class ArrSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    public static int sum(int[] arr,int left){
        if(left == arr.length){
            return 0;
        }else {
            return arr[left] + sum(arr,left+1);
        }
    }
}
