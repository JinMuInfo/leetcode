package indi.ours.algorithm.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author wangheng
 * @create 2018-10-19 下午7:33
 * @desc Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 *
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 *
 **/
public class _561 {
    /**
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        int direct_hash[]=new int[20001];
        for(int num:nums){
            direct_hash[num+10000]+=1;
        }
        int count=0;
        int sum=0;
        int i;
        for(i=0; i<20001; ++i){
            while(direct_hash[i]>0){
                if(count%2 == 0){
                    sum+=i-10000;
                }
                direct_hash[i]=direct_hash[i]-1;
                count++;
            }
        }
        return sum;
    }


    /**
     *
     * 简单的做法   但是时间主要花在排序上了
     *  O(n log n)
     * @param nums
     * @return
     */
    public int arrayPairSum2(int[] nums) {
        //系统的排序算法
        Arrays.sort(nums);
        int sum =0;
        for(int i=0;i<nums.length;i+=2){
            sum += nums[i] ;

        }
        return sum ;
    }

}
