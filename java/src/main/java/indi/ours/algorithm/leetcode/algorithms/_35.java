package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-11-11 下午11:31
 * @desc
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * 找到目标应该 插入的位置
 *
 **/
public class _35 {

    /**
     * O(N)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        for(int i = 0 ;i<nums.length ;i++){
            if(nums[i] >=target){
                return i ;
            }
        }
        //如果便利完成后，还没有返回 ，说明数组 的内容都比 target 小
        //应该放在最后面

        return nums.length ;
    }
}
