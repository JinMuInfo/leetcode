package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-26 下午5:00
 * @desc
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 *
 *
 **/
public class _387 {

    public int firstUniqChar(String s) {
        if(s == null || s.length() ==0) return -1 ;

        int [] datacollect = new int[24];

        for(int i =0 ; i<s.length() ;i++){
          //
            char  tmp = s.charAt(i);
            if(s.indexOf(tmp) != s.lastIndexOf(tmp)){
                continue;
            }else {
                return i;
            }


        }

        return  -1 ;


    }


    /**
     * 这个解法与数据量无关
     * @param s
     * @return
     */
    //This will do just 26 loops to find first unique char...
    public int another_Amazing_solution(String s){
        if(s==null || s.length()==0) return -1;
        int index=Integer.MAX_VALUE;

        for(char ch='a';ch<='z';ch++){
            if(s.indexOf(ch)!=-1 && s.indexOf(ch)==s.lastIndexOf(ch)){ //if char in string...and first and last indexOf same means unique
                index=Math.min(index,s.indexOf(ch));
            }
        }

        if(index!=Integer.MAX_VALUE) return index;
        return -1;
    }


}
