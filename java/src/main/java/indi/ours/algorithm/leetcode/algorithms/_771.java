package indi.ours.algorithm.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author wangheng
 * @create 2018-10-16 下午3:16
 * @desc  一个字符串决定了哪些是宝石
 * 一个字符串决定了 手里的石头
 * 在手里的石头中找出 有多少个宝石
 * 字母区分大小写
 **/
public class _771 {

    public int numJewelsInStones(String J, String S) {
        char [] j = J.toCharArray();
        Arrays.sort(j);
        char [] s = S.toCharArray();
        Arrays.sort(s);

        int jstarter = 0 ;
        int sstarter = 0 ;
        int sum = 0 ;
        while(sstarter <s.length && jstarter <j.length){
            if(j[jstarter] == s[sstarter]){
                sstarter ++ ;
                sum ++ ;
            }else if(j[jstarter] < s[sstarter]){
                jstarter ++ ;
            }else {
                sstarter ++ ;
            }
        }

        return  sum ;


    }


    public int numJewelsInStones2(String J, String S) {
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();
        int count = 0;
        for (char stone : stones) {
            for (char jewel : jewels) {
                if (stone == jewel)
                    count++;
            }
        }
        return count;
    }


}
