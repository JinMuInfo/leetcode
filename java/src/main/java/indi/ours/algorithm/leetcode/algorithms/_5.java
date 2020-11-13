package indi.ours.algorithm.leetcode.algorithms;

import java.util.Vector;

/**
 * @author wangheng
 * @create 2018-10-04 下午5:20
 * @desc
 **/
public class _5 {
    public static void main(String[] args) {
        _5  test = new _5();
        String result = test.longestPalindrome("abcdadc") ;
        System.out.println(result);
    }

    //找出子字符串  且 回文子串 为长度最长的

    /**
     * 方案一 穷举法  找出所有的可能的子字符串
     * 在判断它是否为回文字符串
     * 性能主要消耗在  两层循环 及 字符串的截取上
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if(s == null || s.length() ==1) return s ;
        int maxLength = 0 ;
        String result = "";
        //使用charAt
        for(int i =0 ;i<s.length() -maxLength ;i++){
            for(int j =i+1 ;j<=s.length() ; j++){

                if(j-i <maxLength) {
                    continue;
                }else {
                    String tmp = s.substring(i ,j) ;
                    if(isPalindrome(tmp)){

                        maxLength  = j-i ;
                        result = tmp ;
                    }
                }
            }
        }

        return result ;
    }

    public  boolean isPalindrome(String s ){
        if(s.length() ==1) return  true ;

        int lastIndex  =s.length() -1 ;
        for(int i = 0 ; i<=s.length()/2 +1  ;i++){
            if(s.charAt(i) == s.charAt(lastIndex -i)){
                continue;
            }else {
                return  false ;
            }

        }
        return true ;
    }


    /**
     * 方案二  深入理解题目要义
     * 所谓回文字符串  两边数据 向中间对称
     * 可以 使用一个中间变量 往两边进行数据的拓展
     *
     * @param s
     * @return
     */


    public String longestPalindrome(String s){

        if(s ==null || s.length() ==1) return  s ;

        // 中间指针 I 由此 向两边数据扩展
        for(int i = 0 ; i<s.length() ; i++){
            checkData(s,i);
        }

        System.out.println( init + "  " + maxLength);
        //截取 第几个-第几个字符 包含头部不含尾部
        return s.substring(init , init +maxLength);
    }

    //顶一个  记录总长度 及 出事为止的参数
    int maxLength= 0 ; int init = 0 ;
    public void checkData(String s ,int i){
        int starter = i ;
        //先找出 重复一样的数据
        while( i < s.length() && s.charAt(starter) == s.charAt(i) ) i++ ;

        i--;
        //然后再找出两头相同的长度
        while(starter>=0 && i<s.length() && s.charAt(starter) == s.charAt(i) ){
            starter -- ;
            i++ ;
        }
        //得出的结果  即为总长度
        //处理完之后 这个starter 比 初始点 少1   i比 结束点大 1

        //实际长度 (i-1)-(starter +1) +1 其实不影响 ，结果是相对的
        if(i-starter -1>maxLength){
            maxLength = i-starter -1;
            init = starter+1 ;  // 开始的位置应该+1  也可以在后面截取处修改
        }


    }



}
