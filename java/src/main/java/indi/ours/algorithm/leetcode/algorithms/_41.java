package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-27 下午1:17
 * @desc
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 *
 *
 *
 **/
public class _41 {


    /**
     * 要求 O（n）
     * 第一时间 hash
     * 然后想到的分桶
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        //创建长度 +1 是因为 多了一个0 的位置
        int [] copynums = new int[nums.length+1];

        if(nums == null || nums.length ==0)  return 1 ;
        //if(nums.length==1)  return nums[0]==1 ?2:1 ;

        for(int  value : nums){
            //1 。避免越界
            //2 。 超出 此 长度 肯定是 有 空挡  那么缺失的值 就已经包含在里面了

            if(value<=0 || value >=copynums.length){
                continue;
            }else {
                copynums[value]++;
            }
        }
        for(int i = 1 ;i<copynums.length ;i++){
            if(copynums[i]==0){
                return i ;
            }
        }
        return copynums.length ;
    }

}
