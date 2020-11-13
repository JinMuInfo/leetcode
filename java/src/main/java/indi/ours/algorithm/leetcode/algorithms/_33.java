package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2019-01-08 下午4:02
 * @desc
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 *
 * 要求 logn
 *
 * 使用 二分查找法
 *
 * 输入时有序 的  但 再某处 不是有序的
 **/
public class _33 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid])
                return mid;
            //左边少 右边多
            if (nums[mid] < nums[lo]) {
                // 6,7,0,1,2,3,4,5
                if (target < nums[mid] || target >= nums[lo])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                // 2,3,4,5,6,7,0,1
                if (target > nums[mid] || target < nums[lo])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }

}
