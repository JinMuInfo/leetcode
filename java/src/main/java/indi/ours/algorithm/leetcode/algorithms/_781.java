package indi.ours.algorithm.leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangheng
 * @create 2018-12-26 下午3:14
 * @desc
 * n a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.
 *
 * Return the minimum number of rabbits that could be in the forest.
 *
 * Examples:
 * Input: answers = [1, 1, 2]
 * Output: 5
 * Explanation:
 * The two rabbits that answered "1" could both be the same color, say red.
 * The rabbit than answered "2" can't be red or the answers would be inconsistent.
 * Say the rabbit that answered "2" was blue.
 * Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
 * The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
 *
 * Input: answers = [10, 10, 10]
 * Output: 11
 *
 * Input: answers = []
 * Output: 0
 * Note:
 *
 * answers will have length at most 1000.
 * Each answers[i] will be an integer in the range [0, 999].
 *
 *
 * 森林中，每个兔子都有颜色。
 * 其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。
 * 我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * 说明:
 *
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 *
 * 1 如果不同兔子 答案不同 那么肯定是不同颜色的兔子
 * 2 如果 兔子的答案 为 0  那么只有他自己一种颜色,且 只有一只
 * 3 如果答案相同 且 不为0  那么有可能为一种颜色的兔子
 * 4 当 有 n只  兔子 的答案 都为 M 时
 *  如果 n <=m+1 没问题  计算 n+1 只
 *  如果 n>=m+1 则 应该 计算的的兔子个数为 (n/(m+1)+1)(m+1)
 *
 *
 *
 **/
public class _781 {
    public int numRabbits(int[] answers) {
        int result = 0 ;
        Map<Integer,Integer> ColorRabbit = new HashMap<Integer,Integer>();

        if(answers == null || answers.length ==0){
            return result ;
        }

        for(int i = 0 ; i <answers.length ;i++){
            if(answers[i]==0 ){
                result++ ;
            }else if(!ColorRabbit.keySet().contains(answers[i])){
                ColorRabbit.put(answers[i],1);
                //result = result + answers[i] +1 ;
            }else {
                ColorRabbit.put(answers[i],ColorRabbit.get(answers[i])+1);

            }

        }
        for(Integer key :ColorRabbit.keySet()){
            //n>=m+1   n>m
            if(ColorRabbit.get(key) >key){

                //  如果 没有余数  先假设   这样是满算的 兔子个数
                    result = result + ColorRabbit.get(key)/(key+1)*(key+1) ;
                //有 余数 就 加上余数  对应一个key 的整体
                if(ColorRabbit.get(key)%(key+1)!=0)
                    result = result +  (key + 1);

            }else {
                result = result+key+1;
            }
        }
        return result ;
    }


    /**
     * 分桶法
     * @param answers
     * @return
     */
    public int numRabbits2(int[] answers) {
        int[] count = new int[1000];
        for (int x: answers) count[x]++;
        int rabbits = 0;
        for (int i = 0; i < 1000; i++) {
            if (count[i] > 0) {
                rabbits += ((count[i] - 1) / (i + 1) + 1) * (i + 1);
            }
        }
        return rabbits;
    }
}
