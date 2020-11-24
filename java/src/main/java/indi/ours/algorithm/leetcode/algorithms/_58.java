package indi.ours.algorithm.leetcode.algorithms;


/**
 * @author wh
 *
 * @desc
 * 58. Length of Last Word
 * Easy
 *
 * 848
 *
 * 2844
 *
 * Add to List
 *
 * Share
 * Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Example 2:
 *
 * Input: s = " "
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 *
 */
public class _58 {
    public static void main(String[] args) {
        //String ss = "Hello World";
        String ss = "q ";
        _58 test = new _58();
        int i = test.lengthOfLastWord(ss);
        System.out.println(i);

    }

    /**
     * @author  wh
     * @param s
     * @return
     *
     */
    public int lengthOfLastWord(String s) {

        if(s ==null || s.equals("") || s.equals(" ")){
            return  0 ;
        }

        char[] chars = s.toCharArray();
        // 从后往前迭代 。一遍ok  遇到 第一个非 空符号 时初始化
        //
        int tail =-1 ;
        int head = -1 ;

        for(int i = chars.length-1 ;i>=0;i--){
            if(chars[i] != ' ' && tail <0){
                tail =i ;
                head = tail ;

            }

            // 可能没有数据了
            if(chars[i] == ' ' && tail >=0){

                head = i ;
                break;

            }



        }

        if(tail ==head){
            return tail+1 ;
        }
        return  tail - head ;


    }
}
