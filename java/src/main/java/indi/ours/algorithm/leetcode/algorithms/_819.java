package indi.ours.algorithm.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangheng
 * @create 2018-10-16 上午11:16
 * @desc  找到一个字符串中   单词最多的一个单词
 * 特殊字符 !?',;.
 **/
public class _819 {

    public static void main(String[] args) {
        _819 test = new _819();
       String result =  test.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"});
        System.out.println(result);
    }

    /**
     * 分解为数组 遍历两次
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] strings = paragraph.replace(',',' ')
                .replace('?',' ')
                .replace(',',' ')
                .replace('\'',' ')
                .replace(';',' ')
                .replace('.',' ')
                .trim().toLowerCase().split(" ");
        HashMap<String,Integer> map = new HashMap();
        System.out.println(strings.length);
        for(String data :strings){

            if(map.containsKey(data)){
               map.put(data , map.get(data)+1);
            }else {
                map.put(data,1);
            }
        }

        System.out.println(map.size());

        for(String data : banned){
            map.remove(data);
        }
        map.remove("");

        int max = 0 ;
        String result = "1";
        for(String data :map.keySet()){
            System.out.println(data);
            int tmp = map.get(data);
            System.out.println(tmp);
            if(tmp >max ){
                max = tmp ;
                result = data ;
            }else  {
                continue;
            }

        }

        return result ;

    }
}
