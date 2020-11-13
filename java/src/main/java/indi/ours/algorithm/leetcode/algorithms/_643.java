package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-19 下午2:42
 * @desc  给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 **/
public class _643 {

    public static void main(String[] args) {
        _643  test = new _643();

        test.findMaxAverage(new int[]{1,0,4,0,3},1);
    }




    public double findMaxAverage(int[] nums, int k){

        int sum = 0 ;
        int now = 0 ;

        for(int index = 0 ;index <nums.length; index++){
            if(index <k){
                sum = sum + nums[index];
                now = sum ;
            }else {
                now = now -nums[index -k] +nums[index] ;

                sum = Math.max(sum ,now);
            }

        }

        return (0.0+sum) /k ;


    }
}
