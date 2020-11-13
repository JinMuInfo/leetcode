package indi.ours.algorithm.leetcode.algorithms;


/**
 * @author wangheng
 * @create 2018-12-05 下午5:18
 * @desc
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 *
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 *
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * Note:
 *
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 *
 *
 *
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 子字符串为 至少一个0一个1 且 是2
 *
 * 重复出现的子串要计算它们出现的次数。
 **/

public class _696 {
    public static void main(String[] args) {
        _696  test = new _696();
        int a = test.countBinarySubstrings("00011110");
        System.out.println(a);
    }

    /**
     * 起点 中点  终点
     * 0    1   10
     * 0    2   3
     * 0    3   5
     * 1    2   2
     * 1    3   4
     * 中点 - 起点 -1  +中点  = 终点
     *
     *
     * @param s
     * @return
     */

    public int countBinarySubstrings(String s) {
        if(s==null || s.length() == 0)return  0 ;
        int starter = 0 ;
        int length = s.length();
        int counter = 0 ;
        //起点控制
        while(starter <length){
            //端点控制
            int ender = starter ;
            //如果数据重复 那就继续移位
            while (ender < length && s.charAt(ender) ==s.charAt(starter)){
                ender++ ;
            }
            int last = ender -starter -1 +ender ;
            //System.out.println(starter + "   " + ender);

            //需要长度越界 则停止
            if(last >=length ){
                ;
            }else {
                //System.out.println(s.substring(starter ,last+1));
                //长度正常就查看内容是否一致
                while(ender <last && s.charAt(ender) ==s.charAt(last)){
                    ender ++ ;
                }
                //完全相等 就计数
                if(ender==last) counter ++ ;
            }
            starter++ ;

        }
        return counter;
    }


    /**
     * 摘自讨论区
     * links  https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space
     * @param s
     * @return
     * @desc
     *
     * It takes me some time to understand this problem, after look at the top solution. I figured out how to solve it, Thanks to @compton_scatter, here is just some explaination of his solution:
     *
     * preRun count the same item happend before (let say you have 0011, preRun = 2 when you hit the first 1, means there are two zeros before first '1')
     * curRun count the current number of items (let say you have 0011, curRun = 2 when you hit the second 1, means there are two 1s so far)
     * Whenever item change (from 0 to 1 or from 1 to 0), preRun change to curRun, reset curRun to 1 (store the curRun number into PreRun, reset curRun)
     * Every time preRun >= curRun means there are more 0s before 1s, so could do count++ .
     * (This was the tricky one, ex.
     * 0011 when you hit the first '1', curRun = 1, preRun = 2, means 0s number is larger than 1s number, so we could form "01" at this time, count++ .
     * When you hit the second '1', curRun = 2, preRun = 2, means 0s' number equals to 1s' number, so we could form "0011" at this time, that is why count++)
     *
     */
    public int countBinarySubstrings2(String s) {
        int preRunLength = 0;
        int curRunLength = 1;
        //计数器
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++){
            if (arr[i] == arr[i-1]){
                curRunLength++;
            } else {
                preRunLength = curRunLength;
                curRunLength = 1;
            }

            System.out.println(i +" " +preRunLength + "  " +curRunLength);
            if (preRunLength >= curRunLength){
                res++;
            }
        }

        return res;
    }

}
