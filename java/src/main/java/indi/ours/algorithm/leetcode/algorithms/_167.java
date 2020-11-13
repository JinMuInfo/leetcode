package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-28 上午10:55
 * @desc
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 *
 **/
public class _167 {

    public int[] twoSum(int[] numbers, int target) {

        int  starter = 0 ;
        int ender = numbers.length-1;
        while(starter<ender){
            int sum = numbers[starter] +numbers[ender];
            while (sum<target){
                starter++ ;
                sum = numbers[starter] +numbers[ender];
            }

            while (sum >target){
                ender--;
                sum = numbers[starter] +numbers[ender];
            }

            if(sum == target){
                return new int[]{starter+1 ,ender+1};
            }
        }

        return null;
    }
}
