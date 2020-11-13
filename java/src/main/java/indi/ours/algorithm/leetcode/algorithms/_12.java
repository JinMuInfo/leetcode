package indi.ours.algorithm.leetcode.algorithms;


/**
 * @author wangheng
 * @create 2018-11-01 下午12:49
 * @desc Integer to Roman
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * 将输入的金额 转为 罗马文 输出
 * 可以看看第十三题
 *
 *
 **/
public class _12 {
    public static void main(String[] args) {
        _12 TEST = new _12();
        System.out.println(TEST.intToRoman(3000));

    }

    /**
     * 一般穷举法
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        if(num <1) return "";
        String result = "" ;
        int location = 1 ;
        while(num >0){
            int hasmore = num%10 ;
            result = getcase(hasmore ,location)+result;
            location = location*10 ;

            num = num/10 ;
        }
        return result ;

    }

    String getcase(int value ,int location ){

        if(value*location >=1000 ){

            return "M"+getcase(--value,location);

        }else if(value*location>=100){
            if(value==9){
                return getcase(1 ,location)+getcase(1,location*10);
            }else if(value>5){
                return getcase(5,location)+getcase(value-5,location);
            }else if(value ==5){
                return "D";
            }else if(value ==1){
                return "C";
            }else if(value==4){
                return "C"+getcase(5,location);

            }else {
                return "C"+getcase(value-1,location);
            }

        }else if(value*location>=10){
            if(value==9){
                return getcase(1 ,location)+getcase(1,location*10);
            }else if(value>5){
                return getcase(5,location)+getcase(value-5,location);
            }else if(value ==5){
                return "L";
            }else if(value ==1){
                return "X";
            }else if(value==4){
                return "X"+getcase(5,location);

            }else {
                return "X"+getcase(value-1,location);
            }

        }else if(value*location>=1){
            /**
             * I             1
             * V             5
             * X             10
             */
            if(value==9){
                return getcase(1 ,location)+getcase(1,location*10);
            }else if(value>5){
                return getcase(5,location)+getcase(value-5,location);

            }else if(value ==5){
                return "V";
            }else if(value ==1){
                return "I";
            }else if(value ==4){
                return "I"+getcase(5,location);

            }else {
                return "I"+getcase(value-1,location);
            }

        }else {
            return "";
        }


       // return "";

    }


}
