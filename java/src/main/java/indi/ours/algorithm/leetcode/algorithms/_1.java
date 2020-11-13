package indi.ours.algorithm.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hbn.king
 * @create 2018-09-17 下午4:19
 * @desc  从一个数组中找到 两个数 让他们的和 等于 目标值
 *
 **/
public class _1 {


    /**
     *  Runtime - O(N^2)
     * Space - O(1)
     * @param nums
     * @param target
     * @return
     */

       /* public int[] twoSum(int[] nums, int target) {
            int [] result = null ;

            for(int i = 0;i<nums.length ;i++){
                for(int j=i+1; j<nums.length ;j++){
                    if(nums[i] + nums[j] ==target){
                        result = new int[]{i,j};
                    }
                }

            }
            return result;

        }*/

    /**
     *使用hashMap
     *
     * Runtime - O(N)
     * Space - O(N)
     * @param nums
     * @param target
     * @return
     */



    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap();
        int[] arr = new int[2];
        for(int i=nums.length-1; i>=0; i--){
            if(map.get(target - nums[i]) !=null){
                arr[0] = i;
                arr[1] = map.get(target -nums[i]);
                return arr;
            }else{
                map.put(nums[i],i);
            }
        }

        return null;
    }



}
