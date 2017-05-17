package com.csh.demo.algorithm.sort;

/**
 * 插入排序
 * @author: shenghong.chen
 * Date: 2016/11/10
 * time: 下午11:58
 */
public class InsertSort {

    public static void sort(int[] nums) {
        if (null == nums || nums.length < 2)
            return;
        int length = nums.length;
        int temp = 0;
        int i = 1;
        for (int j = 1; j < length; j ++) {
            temp = nums[j];
            for (i = j; i > 0 && temp < nums[i-1]; i -- ) {
                nums[i] = nums[i-1];
            }
            nums[i] = temp;
        }
    }
}
