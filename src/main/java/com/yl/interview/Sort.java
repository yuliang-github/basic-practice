package com.yl.interview;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Alex
 * @since 2019/5/15 15:59
 */
public class Sort {

    /**
     * 使用java实现8中排序算法
     */
    static int[] arr = new int[]{4,2,1,3};
    public static void main(String[] args) {

        int[] insert = arr.clone();
        insertSort(insert);
        System.err.println("直接插入排序" + Arrays.toString(insert));

        int[] selection = arr.clone();
        selectionSort(selection);
        System.err.println("选择排序" + Arrays.toString(selection));

    }

    /**
     * 直接插入排序
     * 思想:将数组中的每一个元素与前面已经排好的部分进行比较
     * 步骤:
     *  1.将数组分为两部分,一部分为已经排序的,一部分为未排序的
     *  2.将未排序的部分的第一个元素A与已经排序好的部分元素进行比较
     *  3.若A小于排序好部分的元素,则交换位置
     */
    @Test
    public void insert_test(){
        int[] clone = arr.clone();
        System.err.println(Arrays.toString(clone));
        insertSort(clone);
    }
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--){
                if(arr[j] >= arr[j-1]){
                    break;
                }
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.err.println(Arrays.toString(arr));
            }
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] arr){



    }

    /**
     * 选择排序
     * 思想:依次从待排序部分选择最小的元素与已排序的部分的最后一个元素交换位置
     * 步骤:
     *  1.从0、1、2、3...元素中选择最小的元素,让其与0号元素交换位置
     *  2.从1、2、3...元素中选择最小的元素,让其与1号元素交换位置
     *  3.从2、3...元素中选择最小的元素,让其与2号元素交换位置
     *  ...
     */
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for(int j = i+1; j< arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }


    /**
     * 堆排序
     */
    public static void heapSort(int[] arr){



    }

    @Test
    public void bubble_test(){
        int[] clone = arr.clone();
        bubbleSort(clone);
    }
    /**
     * 冒泡排序
     * 思想:比较相邻的数,如果第二个比第一个小,则交换两者的位置,则最小的元素逐渐浮到前面的位置
     * 步骤:
     * 原始:[4, 2, 1, 3]
     *
     * 一轮:[4, 1, 2, 3]、[1, 4, 2, 3]、[1, 2, 4, 3]
     * 二轮:[1, 2, 4, 3]
     * 三轮:[1, 2, 3, 4]
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for(int j = arr.length-1; j > i; j--){
                if(arr[j] >= arr[j-1]){
                   continue;
                }
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr){



    }
}
