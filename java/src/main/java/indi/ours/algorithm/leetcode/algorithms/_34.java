package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2019-01-08 下午3:02
 * @desc
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 **/
public class _34 {
    public int[] searchRange(int[] nums, int target) {
        int []  result = new int[]{-1 , -1 };
        //数组本身 异常 为空 或者 无数据
        if(nums == null || nums.length == 0)  return result ;

        //超出 最大 最小值 就没必要了
        if(target <nums[0] || target >nums[nums.length-1]) return result ;

        //看起来正常的话 我们就遍历
        int starter = Integer.MAX_VALUE;
        int ender = Integer.MIN_VALUE ;
        for(int i = 0 ; i<nums.length ;i++){
            if(nums[i] <target){
                continue;

            }else if(nums[i]>target){
                break;
            }else { //相等了
                starter = Math.min(i,starter);
                ender = Math.max(i,ender);
            }
        }

        if(starter !=Integer.MAX_VALUE){
            return new int[]{starter,ender};
        }else return result;


    }
}
