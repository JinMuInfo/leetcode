package indi.ours.algorithm.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangheng
 * @create 2018-10-11 下午5:51
 * @desc
 *
 * Given two strings A and B of lowercase letters,
 * return true if and only if we can swap two letters in A so that the result equals B.
 **/
public class _859 {


    public static void main(String[] args) {
        _859 test = new _859();
       boolean flag =  test.buddyStrings("aba" ,"baa");
        System.out.println(flag);
    }

    /**
     * 有且仅有一次的数据调换
     *
     * 1 如果数据 有重复元素  那么即使 a b 相等 也成立
     *      调用重复的元素  调用不重复的元素
     * 2 没有重复的元素  ，只能调换一次
     *
     *
     * @param A
     * @param B
     * @return
     */
    public boolean buddyStrings(String A, String B) {
        if(A==null && B==null) return true ;
        if(A ==null || B == null) return false ;
        if(A.length() != B.length()) return false ;
        int length = B.length();
        int sum = 0 ;
        char[] tmp = new char[2];
        Set  set = new HashSet<Character>();
        for(int i = 0 ; i<length ;i++){
            set.add(A.charAt(i));
            if(A.charAt(i)==B.charAt(i)){
                continue;
            }else if(sum ==0){
                tmp[0] = A.charAt(i);
                tmp[1] = B.charAt(i);
                sum ++ ;
                continue;

            }else if(sum ==1 &&A.charAt(i) == tmp[1] && B.charAt(i) == tmp[0])  {
                sum ++ ;
                continue;

            }else {
                return false ;
            }

        }
        //有重复元素且 A B数据相等
       if(set.size() <length){

           if(sum == 0){
               return true ;
           }else if(sum ==2){
               return true ;
           }else {
               return false ;
           }
           //没有重复元素
       }else if(sum == 2){
           return true ;
       }else {
           return false ;
       }



    }
}
