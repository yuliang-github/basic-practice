package com.yl.leetcode.algorithm.A1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author yu.alex
 * @Create 2019/5/29 20:59
 */
public class TwoSum {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15};

        System.err.println(Arrays.toString(twoSum_1(nums, 9)));
        System.err.println(Arrays.toString(twoSum_2(nums, 9)));
        System.err.println(Arrays.toString(twoSum_3(nums, 9)));

    }

    /**
     * 最简单的方法,两层循环
     */
    public static int[] twoSum_1(int[] nums,int sum){
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == sum){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 两次hash循环
     */
    public static int[] twoSum_2(int[] nums,int sum){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sub = sum - nums[i];
            if(map.containsKey(sub)){
                return new int[]{i,map.get(sub)};
            }
        }
        return new int[]{};
    }

    /**
     * 一次hash循环
     */
    public static int[] twoSum_3(int[] nums,int sum){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = sum - nums[i];
            if(map.containsKey(sub)){
                return new int[]{i,map.get(sub)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
