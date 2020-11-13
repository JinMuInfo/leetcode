package indi.ours.algorithm.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangheng
 * @create 2018-11-08 下午3:53
 * @desc
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 求出四个数字 相加 等于目标值的 组合 target 目标值
 *
 **/
public class _18 {

    public static void main(String[] args) {
        _18 test = new _18() ;
        System.out.println( test.fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>>  result = new ArrayList<>();
        for(int starter = 0 ;starter <nums.length-3 ;starter++){
            int middle =  starter+1 ;

               // while (middle<end && nums[middle]==nums[middle+1]) middle++ ;
            // 三个数的和
            for(;middle < nums.length -2 ;middle++){
                int index = middle + 1 ;
                int end  =nums.length-1  ;

                //while (index<end && nums[index]==nums[index+1]) index++ ;

                while (index<end){
                    int sum = nums[starter]+nums[middle]+nums[index]+nums[end];
                    if(sum ==target){
                        Integer [] tmp = {nums[starter],nums[middle],nums[index],nums[end]} ;
                        List list = Arrays.asList(tmp);
                        if(result.contains(list)){
                            ;
                        }else {
                            result.add(list);
                        }
                        index++;
                       // end-- ;
                    }else if(sum >target){
                        end -- ;
                    }else if(sum <target ){
                        index++ ;
                    }
                }
            }
        }
    return  result ;
    }

}
