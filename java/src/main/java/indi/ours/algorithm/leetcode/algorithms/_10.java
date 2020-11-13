package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-29 上午12:05
 * @desc
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * 设计一套 正则匹配的模板
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 *
 *
 **/
public class _10 {


    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        _10 test = new _10();
        String s = "ab";
        String p = ".*";
        System.out.println( test.isMatch(s,p) );



    }

    /**
     * 摘自 讨论区
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return _isMatch(0, 0, s, p);
    }

    private boolean _isMatch(int tPos, int rPos, String s, String p) {
        //boundary checking
        // 有任何一个已经到头的情况
        if (tPos == s.length() || rPos == p.length()) {
            //当都到达端头的时候
            if (tPos == s.length() && rPos == p.length())
                return true;
            //The following is used to check "aaaa", "aaaaa*a*"
            //一个 s 到达端头 但是 p 后面还有
            if (tPos == s.length() && rPos < p.length() - 1 && p.charAt(rPos + 1) == '*')
                return _isMatch(tPos, rPos + 2, s, p);
            //match failed
            return false;
        }
        //not match at current position, if no *, then match failed
        //Otherwise we can skip the current * in the regex and continue
        //to next match.
        //逐个比较字符  如果不相等
        if (s.charAt(tPos) != p.charAt(rPos) && p.charAt(rPos) != '.') {
            //no *, match failed
            // 一个已经到头   另外一个 是*  长度可控
            if (rPos == p.length() - 1 || p.charAt(rPos + 1) != '*')
                return false;
            //skip the *
            return _isMatch(tPos, rPos + 2, s, p);
        }
        //match at current position, if no *, then continue to match the next
        //position both in text and regex.
        //Otherwise try to match one more chars and provide states for backtrack

        if (rPos == p.length() - 1 || p.charAt(rPos + 1) != '*')
            return _isMatch(tPos + 1, rPos + 1, s, p);

        return _isMatch(tPos + 1, rPos, s, p) || _isMatch(tPos, rPos + 2, s, p);
    }



    public boolean isMatch2(String s, String p) {
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int idx1, String p, int idx2) {
        //  s 和 p 都到达端头
        if (s.length() == idx1 && p.length() == idx2) return true;
        //匹配的 p 到达端头  就有问题了
        if (p.length() == idx2) return false;
        //原始数据到达端头 我们就看看p剩下的数据 是否可以归0
        if (s.length() == idx1) {

            // p已经到头 （只有一个元素了，是有问题的） 或者 p 剩下的不是*
            if (idx2 + 1 >= p.length() || p.charAt(idx2 + 1) != '*') {
                return false;
            }
            return isMatch(s, idx1, p, idx2 + 2);
        }

        /**
         * 下一位有个*
         */
        if (idx2 + 1 <= p.length() - 1 && p.charAt(idx2 + 1) == '*') {
            //本位相等 或者为'.'
            if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.') {
                //".*" 可以匹配所有
                // s 继续 前进 或者 p 直接忽略
                return isMatch(s, idx1 + 1, p, idx2) || isMatch(s, idx1, p, idx2 + 2);
            }
            return isMatch(s, idx1, p, idx2 + 2);
            //为 '.' 匹配
        } else if (p.charAt(idx2) == '.') {
            return isMatch(s, idx1 + 1, p, idx2 + 1);
        } else {
            //最后硬匹配
            return p.charAt(idx2) == s.charAt(idx1) && isMatch(s, idx1 + 1, p, idx2 + 1);
        }
    }
}
