package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-03 下午10:56
 * @desc  Reverse Integer  将一个 数字 顺序翻转 并 保持原有的正负符号
 * 当反转时超出 整数范围时  范围0
 **/
public class _7 {

    public int reverse(int x) {
        //直接将 要返回的数值 定义为Long  避免越界
        long answer = 0;
        while(x != 0) {
            answer = 10 * answer + x % 10;
            x /= 10;
        }
        //当结果越界时 返回0
        return (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) ? 0 : (int) answer;
    }
}
