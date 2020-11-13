package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-11-04 下午3:59
 * @desc
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 * 1是数组 内的元素
 * 2是元素的下标也要一致  且 连续的结果
 *
 **/
public class _14 {

    /**
     * 简单的迭代计算
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <=0) return "";
        if(strs.length ==1 )return strs[0];

        String fisrt = strs[0];
        //外层是index 指针 内层是数组
        int index = 0 ;
        outer:
        for(;index <fisrt.length();index++){
            for(String data : strs){
                //比较数值
                if(index >=data.length() ||data.charAt(index)!=fisrt.charAt(index)) break outer;
            }
        }
        return fisrt.substring(0,index);
    }


    /**
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        //结果 prefix  不停地修改  直到他的长度符合要求
        String prefix = strs[0];
        int pin = 0;
        //迭代该数组的所有元素
        while(pin < strs.length){
            //如果 indexof() !=0 说明没有该 prefix  子集；子集的范围 需要不停地修改（长度去掉尾部字符）
            //直到满足该子集为止
            while(strs[pin].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
            }
            if(prefix.length() == 0){
                return "";
            }
            pin++;
        }
        return prefix;
    }
}
