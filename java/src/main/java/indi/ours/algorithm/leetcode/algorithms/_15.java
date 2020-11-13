package indi.ours.algorithm.leetcode.algorithms;

import java.util.*;

/**
 * @author wangheng
 * @create 2018-11-04 下午6:10
 * @desc
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 找出三个数 让他们的和 等于  目标值 0
 * 结果集排序后的不重复结果
 * topic  Math Array
 **/
public class _15 {

    public static void main(String[] args) {
        _15  test = new _15();
        System.out.println(test.threeSum2(new int[]{-1,0,1,2,-1,-4}));
    }

    /**
     * 方法一 穷举法  超时是必然的
     * 数组长度  n^3
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>  list = new ArrayList<List<Integer>>();
        for(int i = 0 ; i<nums.length ;i++){
            for(int j = i+1 ; j<nums.length ;j++){

                for(int k = j+1 ;k<nums.length ; k++){
                    if(nums[i] +nums[j] +nums[k] ==0){
                        List<Integer>  tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        Collections.sort(tmp);
                        if(list.contains(tmp)){
                            continue;
                        }else {
                            list.add(tmp);
                        }


                    }
                }
            }
        }

        return list ;
    }


    /**
     * O(n^2)
     * @param num
     * @return
     */
    public List<List<Integer>> threeSum2(int[] num) {

        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            //跳过第一个数本身的重复
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                //定义一个第二位数字  和 尾数
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    //和为0时
                    if (num[lo] + num[hi] == sum) {
                        //记录结果
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //去除本身 第二位和第三位的元素
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                        //总和小于0 第二位自增
                    } else if (num[lo] + num[hi] < sum) lo++;
                    //总和大于 0 最后一位自减
                    else hi--;
                }
            }
        }
        return res;

    }


}
