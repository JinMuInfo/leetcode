package indi.ours.algorithm.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author wangheng
 * @create 2019-01-02 下午1:55
 * @desc
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * 给一个数组  让他的尾数 加一
 **/
public class _66 {


    /**
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length-1;
        int  yu = 1 ;

        //有余数 且 不能越界
        while (yu >0 && length >=0){

            if(digits[length] !=9 ){
                digits[length] +=1 ;
                yu =0;
                length--;

            }else {
                digits[length] = 0 ;
                length--;
                yu = 1 ;
            }

        }


        if(yu !=0){
            int []  result = new int[digits.length+1];
            result[0] = yu ;
            //将 旧的数据 拷贝到新的数组里来
            System.arraycopy(result,1 ,digits,0,digits.length);
            return result ;
        }else {
            return digits;
        }
    }
}
