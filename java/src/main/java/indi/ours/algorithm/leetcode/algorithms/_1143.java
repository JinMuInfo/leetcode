package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wh
 *
 *
 * @desc
 * 1143. Longest Common Subsequence
 * Medium
 *
 * 2219
 *
 * 29
 *
 * Add to List
 *
 * Share
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
public class _1143 {

    public static void main(String[] args) {

    }

    /**
     *
     * @param text1
     * @param text2
     * @return
     *
     * 长度差异
     * 顺序问题
     *
     * @Date 2020-12-01
     * 这个解法超时
     * "hofubmnylkra"
     * "pqhgxgdofcvmr"
     *
     *
     */
    public int longestCommonSubsequence10(String text1, String text2) {

        return longest(text1,0,text2,0);
    }

    public int longest(String text1 ,int starter1,String text2 ,int starter2 ){

        if(starter1 >= text1.length() || starter2 >=text2.length()){
            return 0 ;
        }

        int result = 0 ;


        int max = Math.max(longest(text1, starter1 + 1, text2, starter2), longest(text1, starter1, text2, starter2 + 1));

        if(text1.charAt(starter1) == text2.charAt(starter2)){
            result = 1 ;
        }

        return Math.max(result+longest(text1, starter1 + 1, text2, starter2+1),max);


    }


    /**
     *
     * @param text1
     * @param text2
     * @return
     *
     * 思考 动态规划 的思路
     *
     * 如果相同则 递增
     * 不同则 保留 上次的最大值
     *
     * 本质是生成一个二维矩阵
     * 将每种可能执行一次
     * 然后比较 最大值的额生成
     *
     */
    public int longestCommonSubsequence(String text1, String text2) {

        int [][] stander = new int [text1.length()+1][text2.length()+1];

        for(int  i = 1 ; i <=text1.length() ; i++){
            for(int j = 1 ; j<=text2.length() ; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    stander[i][j] = stander[i-1][j-1]+1;
                }else {
                    stander[i][j] = Math.max(stander[i ][j-1] ,stander[i-1 ][j]);
                }
            }
        }

        return stander[text1.length()][text2.length()] ;

    }


}
