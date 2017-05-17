package com.csh.demo.algorithm.sort;

/**
 * 选择排序
 * @author: shenghong.chen
 * Date: 2016/11/10
 * time: 下午11:43
 */
public class SelectSort {

    public static void sort(int[] nums) {
        if (null == nums || nums.length < 2)
            return;
        int length = nums.length;
        int temp = 0;
        for(int i = 0; i < length; i ++) {
            int index = i;
            for (int j = length-1; j > i; j --) {
                if (nums [j] < nums[index]) {
                    index = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

    }
}
