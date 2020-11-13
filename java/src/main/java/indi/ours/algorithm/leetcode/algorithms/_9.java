package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-28 下午11:44
 * @desc
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 *
 *
 * palindrome  回文 （回文字符串问题）
 **/
public class _9 {

    /**
     * 通过一个指针 来判断前后的字符 是否一样 只需遍历到数组的一般长度即可
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x <0) return false ;
        String data = x +"" ;
        int length = data.length();
        if(length <2) return true ;
        for(int i = 0 ; i<length/2 +1 ;i++){
            if(data.charAt(i) == data.charAt(length-1-i)){
                continue;
            }else{
                return false ;
            }
        }
        return true ;
    }


    /**
     * 负数肯定是不符合条件的
     * 正数的话 就翻转一下看看结果是否一样吧
     * 个人觉得 会有一个超出整数范围的问题
     * 但是超出范围 肯定不是原来的数的 结果也能做对吧
     *
     * @param x
     * @return
     */

    public boolean isPalindrome2(int x) {

        if(x<0){
            return false;
        }
        int temp =x;
        int sum=0;

        while(x>0){
            sum = sum*10 + x%10;
            x=x/10;
        }

        return (sum ==temp);

    }
}
