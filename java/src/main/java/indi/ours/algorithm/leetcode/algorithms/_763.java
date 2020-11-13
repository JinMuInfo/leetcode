package indi.ours.algorithm.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangheng
 * @create 2018-12-26 下午2:29
 * @desc
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1:
 *
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 *
 *
 **/
public class _763 {

    //ababcbacadefegdehijhklij
    public List<Integer> partitionLabels(String S) {
        List<Integer>  result = new ArrayList<>();

        if(S == null || S.length() ==0) return result ;

        int starter = 0 ;
        int ender = 0 ;
        for(int i = 0 ;i<S.length();i++){
            //获取该子字符中 字符 的最后位置
            ender = Math.max(ender ,S.lastIndexOf(S.charAt(i)));
            if(i == ender){

                ender = ender+1 ;
                result.add(ender-starter);
                starter = ender ;
            }
        }
        return result ;
    }
}
