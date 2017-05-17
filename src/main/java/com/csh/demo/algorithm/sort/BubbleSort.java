package com.csh.demo.algorithm.sort;

/**
 * @author: shenghong.chen
 * Date: 2016/11/10
 * time: 下午10:39
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        if (null == nums || nums.length < 2)
            return;
        int length = nums.length;
        int temp = 0;
        for (int j = length-1; j > 1; j --) {
            for (int i = 0; i+1 <= j; i++) {
                if (nums[i] > nums[i+1]){
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }
    }
}
