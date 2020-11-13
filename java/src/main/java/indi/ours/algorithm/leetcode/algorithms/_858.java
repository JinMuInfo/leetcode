package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-12 上午11:19
 * @desc  方形  镜子 反射
 *
 *         2    1
 *         s    0
 *
 *
 *         p为宽度  q为射出的高度
 *     左侧的是2  右侧的是 0、1
 *     当最小公倍数 是 q的偶数倍 的时候 返回的必然是 2号位置
 *     当最小公倍数  是 q的奇数倍 的时候 如果同时是 p 的奇数倍 返回为1
 *                                  如果是P的偶数倍 范围0
 **/
public class _858 {

    public int mirrorReflection(int p, int q) {
        if(q == 0)return 0 ;
        int summary = get_lcm( p , q) ;
        if((summary/q)%2 ==0){
            return 2 ;
        }else if((summary/p)%2==0) {
            return 0 ;
        }else {
            return 1 ;
        }
    }
    // 最大公约数
    public static int get_gcd(int a, int b) {
        int max, min;
        max = (a > b) ? a : b;
        min = (a < b) ? a : b;
        if (max % min != 0) {
            return get_gcd(min, max % min);
        } else
            return min;
    }
    // 最小公倍数
    public static int get_lcm(int a, int b) {
        return a * b / get_gcd(a, b);
    }

}
