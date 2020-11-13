package indi.ours.algorithm.leetcode.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author wangheng
 * @create 2018-11-06 上午1:23
 * @desc
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 *
 *
 **/
public class _20 {

    /**
     * 简单的队列实现
     * 入栈 出栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s == null || s.length() ==0) return true ;
        if(s.length()%2==1) return false ;
        LinkedList<Character> list = new LinkedList<Character>();

        for(int i = 0 ;i<s.length() ;i++){
            if(s.charAt(i) == '(' ||s.charAt(i) == '[' || s.charAt(i) == '{' )
                list.addLast(s.charAt(i));
            else if(s.charAt(i) == ')' &&list.size()>0 &&list.getLast() == '(' ){
                list.removeLast();
            }else if(s.charAt(i) == ']' && list.size()>0 &&list.getLast() == '['){
                list.removeLast();
            }else if(s.charAt(i) == '}' && list.size()>0 && list.getLast() == '{'){
                list.removeLast();
            }else {
                return false ;
            }

        }
        if(list.size() >0 ) return false ;
        return true ;

    }

}
