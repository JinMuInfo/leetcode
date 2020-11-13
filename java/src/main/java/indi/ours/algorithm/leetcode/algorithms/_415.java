package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-19 下午5:24
 * @desc  给你两个string 数字    返回他们的和
 *
 *
 *   The length of both num1 and num2 is < 5100.
 *   Both num1 and num2 contains only digits 0-9.
 *   Both num1 and num2 does not contain any leading zero.
 *   You must not use any built-in BigInteger library or convert the inputs to integer directly.
 **/
public class _415 {
    public static void main(String[] args) {
        _415  test = new _415();

        test.addStrings("1","9") ;
    }

    public String addStrings(String num1, String num2) {
        if(num1 ==null && num2 ==null )return null ;
        if(num1 ==null || num2 ==null )return num1==null ?num2:num1 ;

        int index1 = num1.length() -1 ;
        int index2 = num2.length() -1 ;
        int tenth = 0 ;
        StringBuilder result = new StringBuilder();
        while(index1 >=0 ||index2 >=0 ||tenth >0){
            int sum = (index1 >=0 ? num1.charAt(index1)-'0' :0)  + (index2 >=0? num2.charAt(index2)-'0':0) +tenth ;
            tenth = sum /10 ;
            sum = sum %10 ;
            result.append(sum) ;

            index1 --;
            index2 --;
        }

        System.out.println(result);
        return result.reverse().toString() ;
    }
}
