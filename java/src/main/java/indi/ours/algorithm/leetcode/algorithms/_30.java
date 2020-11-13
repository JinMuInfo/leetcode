package indi.ours.algorithm.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangheng
 * @create 2018-11-11 下午2:30
 * @desc
 * You are given a string, s, and a list of words, words,
 * that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input:
 *   s = "wordgoodstudentgoodword",
 *   words = ["word","student"]
 * Output: []
 *
 *
 **/
public class _30 {
    /**
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
            int length = words[0].length();
            List<Integer> res = new ArrayList<>();
            if (s == null || words == null || words.length == 0 || s.length() < words[0].length() * words.length) return res;
            Map<String, Integer> map = new HashMap();
            Map<String, Integer> cur = new HashMap();
            //将 数据放入到 map  中
            for (String word: words) {
                if (!map.containsKey(word)) map.put(word, 0);
                map.put(word, map.get(word) + 1);
            }
            int m = words[0].length(), n = s.length(), num = words.length;
            for (int i = 0; i < m; i++) {
                int left = i, right = i, cnt = 0;
                cur = new HashMap();
                for (; right + m <= n; right += m) {
                    String sub = s.substring(right, right + m);
                    if (!map.containsKey(sub)){
                        cur = new HashMap();
                        cnt = 0;
                        left = right + m;
                    }
                    else {
                        if (!cur.containsKey(sub)) {
                            cur.put(sub, 0);
                        }
                        cur.put(sub, cur.get(sub) + 1);
                        cnt++;
                        while (cur.get(sub) > map.get(sub)) {
                            String leftSub = s.substring(left, left + m);
                            cur.put(leftSub, cur.get(leftSub) - 1);
                            cnt--;
                            left += m;
                        }
                        if (cnt == num) res.add(left);
                    }
                }
            }
            return res;
        }


    /**
     * I think the following code is self-explanatory enough.
     * We use an unordered_map<string, int> counts to record
     * the expected times of each word and another unordered_map<string, int> seen to record the times we have seen.
     * Then we check for every possible position of i.
     * Once we meet an unexpected word or the times of some word is larger than its expected times, we stop the check.
     * If we finish the check successfully, push i to the result indexes.
     *
     * Just build a map for the words and their relative count in L. Then we traverse through S to check whether there is a match.
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
