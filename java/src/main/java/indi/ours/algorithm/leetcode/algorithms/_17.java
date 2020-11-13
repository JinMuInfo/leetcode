package indi.ours.algorithm.leetcode.algorithms;

import java.util.*;

/**
 * @author wangheng
 * @create 2018-11-08 下午3:54
 * @desc
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 图片是原始 座机 的号码图
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * * 0 #
 *
 * 从 2开始一直到 9  遍布的26个英文字母
 * 9 有四个
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Example2:
 * input "29"
 * output: ["aw","ax","ay","az","bw","bx","by","bz","cw","cx","cy","cz"]
 *
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 **/
public class _17 {
    public static void main(String[] args) {
        _17  test = new _17();
        System.out.println(test.letterCombinations("0349"));
    }



    String [][] numbers = {
            {" "},
            {"*"},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r","s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };



    public List<String> letterCombinations(String digits) {
        LinkedList<String>  result = new LinkedList<>();
        //LinkedList<String>  tmp  = new LinkedList<>();
        if(digits == null || digits.length() ==0) return result ;

        for(int i = 0 ; i<digits.length() ;i++){
            //第一次输入的时候 就是号码本所带的额自己个字母
            if(i ==0){
                for(String str :numbers[digits.charAt(i) -'0']){
                    result.addLast(str);
                }
                //随后每次都会增加 下一个数的笛卡尔积 并移除 第一个数组
            }else {
                //拿到每条数据 ，加入新的元素 ，再放回原来的集合里
                int length = result.size() ;
                for(int j = 0 ; j<length ; j++){
                    String data  = result.getFirst();
                    for( String str :numbers[digits.charAt(i) -'0']){
                        result.add(new String(data+str));
                    }
                    result.removeFirst();
                }
            }
        }
        return  result ;
    }

}


