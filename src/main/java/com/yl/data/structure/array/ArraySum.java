package com.yl.data.structure.array;

/**
 * @author yu.alex
 * @date 2020/3/29 10:47
 * @des
 */
public class ArraySum {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4};

        System.out.println(sum(arr));

    }


    /**
     * 递归方式数组求和
     * sum(0,n-1) = arr(0) + arr(1,n-1)
     * sum(1,n-1) = arr(1) + arr(2,n-1)
     * ...
     * sum(n-1,n-1) = arr(n-1) + 0;
     * @param arr
     * @return
     */
    public static int sum(int[] arr) {

        return sum(arr, 0);

    }

    private static int sum(int[] arr, int left){

        if (left == arr.length) {
            return 0;
        }

        return arr[left] + sum(arr, left+1);

    }

}
