package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-11 上午9:54
 * @desc 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 **/
public class _53 {

    public static void main(String[] args) {
        _53  test = new _53();
        test.maxSubArray2(new int[]{1,1,1,1,1,-5,4,1,1});
    }

    /**
     *
     * @param nums
     * @return
     * @desc 求最大值 定义header  和 tail  取其中间数据的值
     */
    public int maxSubArray(int[] nums) {

        int result = nums[0] ;
        for(int head = 0 ; head<nums.length ; head++){
            int tmp = 0 ;
            for(int tail = head ; tail < nums.length ; tail ++){
                tmp = tmp +nums[tail];
                result = Math.max(result ,tmp ) ;
            }
        }

        return result ;
    }



    public int maxSubArray2(int[] nums){
        int currMax = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            /**
             * 前面的值为负   currMax  则抛弃
             */
            currMax = Math.max(nums[i], currMax+nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

}
