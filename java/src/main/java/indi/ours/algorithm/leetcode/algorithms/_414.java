package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-19 下午6:05
 * @desc  Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number.
 * The time complexity must be in O(n).
 *
 **/
public class _414 {

    public static void main(String[] args) {
        _414 test = new _414();
        System.out.println(test.thirdMax(new int[]{2,1,1,1,1,1,1,1,}));
    }

    public int thirdMax(int[] nums) {
        int i,first,second,third;
        first=second=third=Integer.MIN_VALUE;
        boolean b=false;


        for(i=0;i<nums.length;i++) {
            if(nums[i]==Integer.MIN_VALUE) {
                b = true;
            }
            if(nums[i]>first) {
                third=second;
                second=first;
                first=nums[i];
            }
            else if(nums[i]>second  &&   nums[i]!=first) {
                third=second;
                second=nums[i];
            }
            else if(nums[i]>third &&  nums[i]!=second &&  nums[i]!=first) {
                third=nums[i];
            }
        }
        //数组包含 Integer.MIN_VALUE  且独立元素 大于三
        if(third==Integer.MIN_VALUE && b==true && third!=second)
            return third;
        else if(third==Integer.MIN_VALUE) //长度不够
            return first;
        else
            return third;
    }
}
