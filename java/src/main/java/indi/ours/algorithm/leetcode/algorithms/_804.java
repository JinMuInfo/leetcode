package indi.ours.algorithm.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangheng
 * @create 2018-10-16 下午1:50
 * @desc 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合
 * 返回 
 **/
public class _804 {


    String[]  secret = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    /**
     * 5 ms
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set set = new HashSet<String>();
        StringBuilder sb = null ;
        for(String data : words){
            sb = new StringBuilder();
            for(char c :data.toCharArray()){
                sb.append(secret[c-'a']);
            }
            set.add(sb.toString());
        }

        return set.size() ;
    }
}
