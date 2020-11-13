package indi.ours.algorithm.leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author wangheng
 * @create 2018-11-23 下午2:25
 * @desc
 * Alice has a hand of cards, given as an array of integers.
 *
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 *
 * Return true if and only if she can.
 *
 *
 *
 * Example 1:
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * Example 2:
 *
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 *
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 * 提示：
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 *
 * 思路一 桶排序法 （以为hand个数 和范围都已经限定）
 *
 **/
public class _846 {

    /**
     *
     * @param hand
     * @param W
     * @return
     */
    public boolean isNStraightHand(int[] hand, int W) {
        //牌本身个数 凑不上的情况
        if(hand.length %W != 0) return false ;
        //数量够 看看牌大小连续否

        TreeMap<Integer ,Integer>  dataMap = new TreeMap<>();
        for(int card : hand){
            dataMap.put(card ,dataMap.getOrDefault(card ,0)+1);
        }

        for(int card:dataMap.keySet()){
            if(dataMap.get(card) <0) return false ;
            if(dataMap.get(card )==0) continue;
            int high = dataMap.get(card);
            for(int i = card ;i<card+W ;i++){
                //后面的数量比起始牌的个数 小  肯定不行
                if(dataMap.getOrDefault(i,0) <high){return false;}
                //比起始位置大  就 减去 该位置的值
                dataMap.put(i ,dataMap.getOrDefault(i ,0)-high);
            }
        }
        return true ;
    }
}
