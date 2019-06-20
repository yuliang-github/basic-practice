package com.yl.leetcode.algorithm.Other;

/**
 * @author Alex
 * @since 2019/6/3 14:27
 */
public class UpStaris {

    /**
     * 假设有一段N阶的楼梯，小明每次可以上1阶、2阶或3阶，请问走完这段楼梯，一共有多少种方式
     * 假设n级:f(0) = 0;f(1) = 1;f(2) = 2;f(3) = 4;
     * 最后一步有三种走法:走1级,则前面有f(n-1)种走法,走2级,则前面🈶f(n-2)种走法,走3级,则前面有f(n-3)中走法
     * 推论出:f(n) = f(n-1) + f(n-2) + f(n-3)
     */

    public static void main(String[] args) {

        System.err.println(upStaris(10));

    }

    public static int upStaris(int n){
        if(n < 0){
            return 0;
        }
        // 注意事项,n == 0返回1疑问？因为包含一种方式,最后一步走完了所有
        if(n == 0){
            return 1;
        }
        return upStaris(n-1)+upStaris(n-2)+upStaris(n-3);
    }
}
