package indi.ours.algorithm.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hbn.king
 * @create 2018-09-19 下午1:19
 * @desc
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * 求最长子字符串
 **/
public class _3 {
    /**
     * I 指向起始位置 J 指向 尾部  j-i 为长度
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }
}
