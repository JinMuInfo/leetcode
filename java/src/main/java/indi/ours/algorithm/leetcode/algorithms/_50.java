package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-27 下午1:31
 * @desc
 *
 *Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 *
 *
 * 求 x 的 n 次方
 * 注意x 的范围 和 最终结果
 *
 **/
public class _50 {


    /**
     * 超时 了
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(Math.abs(x -0) <0.00001 ) return x;
        if(n == 0) return 1.00000 ;
        double sum = x;
        for(int i = 1 ;i<Math.abs(n) ;i++){
            sum = sum *x ;
        }
        if(n>0) return sum ;
        else return 1.0/sum ;

    }

    /**
     * 先看看源码怎么写的吧
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        return Math.pow(x, n);
        /**
         * 底层使用native  方法 
         */
    }

    /**
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow3(double x, int n) {

        if(n < 0) {

            if(x==-1){
                return n%2==0?1:-1;
            }
            if(n==Integer.MIN_VALUE){
                n= -Integer.MAX_VALUE;
            }
            x = 1/x;
            n =-n;
        }

        if(n == 0) {
            return 1;
        }

        else if(n %2 == 0) {
            double y = myPow(x, n/2);
            return y*y;
        }
        else {
            return x*myPow(x, n-1);
        }
    }





}
