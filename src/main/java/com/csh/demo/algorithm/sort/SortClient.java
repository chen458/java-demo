package com.csh.demo.algorithm.sort;

/**
 *
 * @author: shenghong.chen
 * Date: 2016/11/10
 * time: 下午10:29
 */
public class SortClient {

    public static void main(String[] args) {
        int[] nums = {10,89,23,56,9,4,7,9,45,24};
//        BubbleSort.sort(nums);
//        QuickSort.sort(nums, 0, 9);
//        SelectSort.sort(nums);
        InsertSort.sort(nums);
        for (int n : nums) {
            System.out.println(n + ", ");
        }
    }

}
