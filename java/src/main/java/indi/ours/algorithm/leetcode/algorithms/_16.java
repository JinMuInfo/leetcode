package indi.ours.algorithm.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author wangheng
 * @create 2018-11-05 下午11:35
 * @desc
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * 求出与目标值target 最近的值
 *
 **/
public class _16 {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums==null || nums.length <3) return 0 ;

        int differ = Integer.MAX_VALUE ;

        //外层循环
        for(int first = 0 ;first <nums.length-2 ;first++){
            int secondary = first +1 ;
            int third = nums.length -1 ;
            //内层循环 比较与 目标值 之间的差异 ，与0 的关系
            while(secondary <third){
                int sum = nums[first] +nums[secondary] +nums[third];
                if(sum == target){
                    return target ;
                }else if(sum <target){
                    secondary++ ;
                    differ = Math.abs(differ) <Math.abs(sum -target) ? differ :(sum -target) ;
                }else if(sum> target) {
                    third--;
                    differ =Math.abs(differ) <Math.abs(sum -target) ? differ :(sum -target) ;
                }
            }
        }
        return  differ +target;
    }
}
