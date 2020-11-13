package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-02 下午11:43
 * @desc  传入一个字符串 获取其中的  整数
 * 正负整数
 * startwith 空格 其他非数字
 * 超出 整数的范围
 * atoi (表示 ascii to integer)
 * 字符串转整数 (atoi)
 **/
public class _8 {

    public static void main(String[] args) {
        _8 aa = new _8();
        int bb = aa.myAtoi(" +1");
        System.out.println(bb);
    }

    /**
     * 可以分为两部分求解 ， 1,找出 字符串中的整数部分 ，2 将其转为数字
     * <p>
     * 使用后发现测试用例 居然还有小数 且 返回整数
     * 该 版本不通过
     *
     * @param str
     * @return
     */
   /* public int myAtoi2(String str) {
        if (str == null || str.length() == 0) return 0;
        String[] inputdata = str.trim().split(" ");

        //for(String data :inputdata){
        if (inputdata.length <= 0) return 0;
        String data = inputdata[0];
        if (data.length() == 1 && data.contains("-")) return 0;
        int i = 0;
        for (; i < data.length(); i++) {
            if (data.charAt(i) - '0' >= 0 && data.charAt(i) - '0' < 10) {
                continue;
            } else if (i == 0 && data.charAt(i) == '-') {
                continue;
            } else {
                break;
            }

        }

        if (i == data.length()) {
            int result = 0;
            try {
                result = changeString2Long(data);
            } catch (Exception e) {
                result = 0;
            }

            return result;

        }

        //}


        return 0;
    }

    public int changeString2Long(String str) {
        System.out.println(str);
        Long result = Long.valueOf(str);
        //Long.va
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;


        } else {
            return result.intValue();

        }
    }
*/

    /**
     * 直接从前往后扫描
     * 查看每个字符的条件 不符合条件的  则 直接跳出
     * 第二版  数值 范围问题   即使是long  也会有超出异常 不过想了一下 也可以
     * try catch return
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        str =str.trim() ;
        if(str == "" || str.length()==0) return  0 ;
        int i = 0;
        int starter = 1;
        if (str.startsWith("-")  && str.length() > 1) {
            i = 1;
            starter = -1;
        } else if (str.startsWith("+") && str.length() > 1) {
            i = 1;
            starter = 1;
        }
        int flag = i;
        for (; i < str.length(); i++) {
            //先看看是正负号
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            } else break;
        }
        int result = 0;
        if (i > flag) {
            System.out.println(str.substring(flag, i));
            //System.out.println(Long.MAX_VALUE);
            //这里转换会有问题  超出 数值的最大值
            try {
                result = Integer.valueOf(str.substring(flag, i)) *starter;
                System.out.println(result + "  zhi"  + starter);
            } catch (Exception e) {
                //有异常则 获取 最大或者最小值
                if(starter <0){
                    result = Integer.MIN_VALUE ;
                }else {
                    result = Integer.MAX_VALUE ;
                }

                return result ;
            }
        }
        return  result ;
    }


    /**
     *  最终方案
     * @param str
     * @return
     */

    public static int myAtoi1(String str) {

        if (str == null || str.length() == 0)
            return 0;//
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;

    }
}
