package indi.ours.algorithm.leetcode.algorithms;


/**
 *
 * @author wh
 * @desc
 * 593. Valid Square
 * Medium
 *
 * 411
 *
 * 566
 *
 * Add to List
 *
 * Share
 * Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.
 *
 * The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
 *
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 *
 *
 *
 * Example 1:
 *
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: true
 * Example 2:
 *
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * Output: false
 * Example 3:
 *
 * Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * Output: true
 *
 *
 * Constraints:
 *
 * p1.length == p2.length == p3.length == p4.length == 2
 * -104 <= xi, yi <= 104
 */
public class _593 {

    public static void main(String[] args) {

    }

    /**
     *
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     *
     *
     * @Date 2020-11-25
     * @desc
     * 题目理解
     * 求给的 是不是个正方形 ，而且给的点不是有序的
     * 根据情况看是 如下情况
     * ①
     * 相邻的边是相等的 ，
     * 且两组的斜边是相等的
     * 基本上有一下情况
     * 1234
     * 1324
     * 1342
     * 本质就是1 节点的 对角不同
     *
     * 先求出与1  节点最远 最近距离
     * 如果最远等于最近 则 为三角形
     *
     *
     *
     *
     *
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //  计算 1节点到各个节点距离
        Long    l12 = getDistance(p1,p2);
        Long    l13 = getDistance(p1,p3);
        Long    l14 = getDistance(p1,p4);

        Long  max = Math.max(Math.max(l12,l13),l14);
        Long  min = Math.min(Math.min(l12,l13),l14);
        //  等边三角形   直接退出

        if(max.equals(min)){
            return false ;
        }


        //  2节点为对边的情况
        if(max.equals(l12)){
            Long l23 = getDistance(p2,p3);
            Long l34 = getDistance(p3,p4);
            if(l12.equals(l34)){
                //查看23  是否为直角
                Long l24 = getDistance(p2,p4);
                // 求 两个相邻 角均为 直角
                if((l12.equals(l13+l23)) && l34.equals(l23+l24)){
                    if(l14.equals(l23) && l14.equals(l24)){
                        return true ;
                    }else {
                        return false ;
                    }

                }else {
                    return false ;
                }

            }else {
                return false ;
            }


        }else if(max.equals(l13)){
            Long l23 = getDistance(p2,p3);
            Long l24 = getDistance(p2,p4);

            if(l13.equals(l24)){
                //查看23  是否为直角
                Long l34 = getDistance(p3,p4);

                // 求 两个相邻 角均为 直角
                if((l13.equals(l12+l23)) && l24.equals(l23+l34)){

                    //  对边相等 且 邻边相等  本质是三个边相等
                    if(l14.equals(l23)  && l14.equals(l12) ){
                        return true ;
                    }else {
                        return false ;
                    }

                }else {
                    return false ;
                }

            }else {
                return false ;
            }

        }else if(max.equals(l14)){
            Long l23 = getDistance(p2,p3);
            Long l24 = getDistance(p2,p4);

            if(l14.equals(l23)){
                //查看34  是否为直角
                Long l34 = getDistance(p3,p4);

                //   // 求 两个相邻 角均为 直角
                if((l14.equals(l13+l34)) && l23.equals(l24+l34)){

                    if(l12.equals(l34) && l12.equals(l13)){
                        return true ;
                    }else {
                        return false ;
                    }

                }else {
                    return false ;
                }

            }else {
                return false ;
            }

        }


        return false ;






    }

    public  Long  getDistance(int[] p1, int[] p2){
        long x = p2[0]-p1[0];
        long y = p2[1]-p1[1];
        return  x*x +y*y ;

    }


}
