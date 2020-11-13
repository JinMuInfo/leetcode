package indi.ours.algorithm.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author wangheng
 * @create 2018-11-15 下午2:22
 * @desc
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Note:
 *
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 *
 **/
public class _704 {


    public int search(int[] nums, int target) {

        for(int i = 0 ; i<nums.length ;i++){
            if(nums[i] ==target){
                return i ;
            }
        }
        return -1 ;
    }


    /**
     * 二分查找法
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left<=right){

            int middle = left + (right - left)/ 2;

            if(nums[middle] == target)
                return middle;
            else if(nums[middle] > target){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }

        return -1;

    }


}
