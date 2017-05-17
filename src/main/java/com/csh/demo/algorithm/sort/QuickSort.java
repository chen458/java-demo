package com.csh.demo.algorithm.sort;

/**
 * 快速排序
 * @author: shenghong.chen
 * Date: 2016/11/10
 * time: 下午11:03
 */
public class QuickSort {

    public static void sort(int[] nums, int start, int end) {
        if (null == nums || nums.length < 2)
            return ;
        int length = nums.length;
        if (start < 0 || end > length-1 || start >= end)
            return;
        int middle = getMiddle(nums, start, end);
        sort(nums, start, middle-1);
        sort(nums, middle + 1, end);
    }

    /**
     * 中轴位置
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int  getMiddle(int[] nums, int start, int end) {
        int index = nums[start];
        int ta = start;
        int tb = end;
        while (tb > ta) {
            while (tb > ta && nums[tb] >= index) {
                tb --;
            }
            nums[ta] = nums[tb];
            while (ta < tb && nums[ta] < index) {
                ta ++;
            }
            nums[tb] = nums[ta];
        }
        nums[ta] = index;
        return ta;
    }
}
