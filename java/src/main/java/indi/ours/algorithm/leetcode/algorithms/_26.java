package indi.ours.algorithm.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author wangheng
 * @create 2019-01-02 下午2:43
 * @desc
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 移除 数组 中的重复 元素
 * 并 放回 该数组 中 前N 个 数字（有序的排列着）
 *
 **/
public class _26 {

    public static void main(String[] args) {
        _26  test = new _26();
       int data =  test.removeDuplicates(new int[]{0,0,0,1,1,2,2,2,4,4,5,7,7,9});
        System.out.println(data);
    }
    public int removeDuplicates(int[] nums) {
        /**
         * 一个starter 来修改 前面的数字
         * 一个ender 来 往后迭代 得到新的数
         */
        int starter = 0 ;
        int ender = 0 ;

        for( ; ender <nums.length ;ender ++){
            while (  ender <nums.length-1 && nums[ender+1] ==nums[ender]){
                ender++;
            }
            //每次遇到一个新的元素 就 自增 一次
            //并且对 数组 重新赋值

            if(ender <nums.length){

                nums[starter] =nums[ender] ;
                starter ++ ;
            }
        }
        /**
        nums = Arrays.copyOf(nums,starter);
        for (int num :nums){
            System.out.println(num);
        }
         */

        return starter ;
    }
}
