package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-27 下午1:59
 * @desc
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 **/
public class _45 {

    /**
     *
     * 后来 讨论区看了一下贪心算法
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        // If nums.length < 2, means that we do not
        // need to move at all.
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // First set up current region, which is
        // from 0 to nums[0].
        int l = 0;
        int r = nums[0];
        // Since the length of nums is greater than
        // 1, we need at least 1 step.
        int step = 1;

        // We go through all elements in the region.
        while (l <= r) {

            // If the right of current region is greater
            // than nums.length - 1, that means we are done.
            if (r >= nums.length - 1) {
                return step;
            }

            // We should know how far can we reach in current
            // region.
            int max = Integer.MIN_VALUE;
            for (; l <= r; l++) {
                max = Math.max(max, l + nums[l]);
            }

            // If we can reach far more in this round, we update
            // the boundary of current region, and also add a step.
            if (max > r) {
                l = r;
                r = max;
                step++;
            }
        }

        // We can not finish the job.
        return -1;

    }


    /**
     * BFS 求解
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        //只有一个元素
        if (nums.length <= 1) return 0;
        //当前可以到达的最大元素
        int curMax = 0; // to mark the last element in a level
        //层数  和 起始点
        int level = 0, i = 0;

        while (i <= curMax) {

            int furthest = curMax; // to mark the last element in the next level
            // 求出 相对的 可以到达的最远的点
            // nums[i]+i  的问题可以算出 该点 i 可以到达的最远点
            //主要是 curMax记录的问题
            //如何让level 自增

            for (; i <= curMax; i++) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1) return level + 1;
            }
            level++;
            curMax = furthest;
        }
        return -1; // if i < curMax, i can't move forward anymore (the last element in the array can't be reached)
    }


    /**
     * 将 Q55 题目的问题 拿来 加以变化
     * @param nums
     * @return
     */

    public int jump3(int [] nums){
        //只有一个元素
        if (nums.length <= 1) return 0;
        int level = 0;

        // 设计 起点  和 终点
        int i = 0,  j= 0;

        // 当i < j 时  说明还有路可通
        //如果i>j 说明 该 数组 不可跳跃
        //比如  【3，2，1，0，0，1】
        while (i<=j){

            //每一次 j  获取最大值的过程
            //level  都要自增一次
            int max = Integer.MIN_VALUE;
            while (i<=j){
                //记录 该 层 可以到达的最远点
                max = Math.max(max,i + nums[i++]);
                if(max >=nums.length -1) return  level ++ ;
            }
            //将最大值 赋值给 j ；
            //并 将 层数 ++ ；
            j = max ;
            level++ ;

        }

        return  -1 ;
    }
}

