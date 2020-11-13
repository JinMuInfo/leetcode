package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-27 下午3:58
 * @desc
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 *
 *
 *
 **/
public class _55 {

    /**
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        if(nums==null || nums.length ==0)return  false ;
        int i =0 ,j = 0 ;
        while(i <=j && j <nums.length) {
            //计算j 可以到达的最大位置
            //i + nums[i]  当前i的 位置 和 i 可以到达的位置  同时i++
            //这样计算了每个i  上的最大位置
            j =Math.max(j,i+nums[i++]);
        }

        return  j >nums.length-1 ;


    }


    /**
     * 我想了一下 试试 用动态规划的方法
     * 看看能不能解决问题
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if(nums==null || nums.length ==0)return  false ;
        int maxindex = nums.length-1 ;
        nums[maxindex] = -1 ;
        //不停地修改 数组 为 -1 即是可达  为 -2  即为 不可达
        for(int i = maxindex-1 ; i >=0 ;i--){
            //如果直接可达
            int tmpmax = i +nums[i];
            if(tmpmax >maxindex){
                nums[i] = -1 ;

            }else {
                for (int j = i; j <= tmpmax; j++) {
                    if (nums[j] == -1) {
                        nums[i] = -1;
                    }
                }
            }
        }
        return  nums[0] == -1 ;

    }


}
