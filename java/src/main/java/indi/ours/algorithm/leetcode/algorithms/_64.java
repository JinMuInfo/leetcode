package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-17 下午6:59
 * @desc
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 **/
public class _64 {


    /**
     * 类示于一个图 之间最小距离的关系
     * 不停地修改图的值
     * 直到他稳定为止
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int min = Integer.MAX_VALUE;

        int heigh= grid.length;
        int wide = grid[0].length;



        for(int i =0 ; i<heigh;i++){
            for(int j=0;j<wide;j++){
                //起点 不做修改
                if(i == 0 && j == 0){
                    continue;

                }else if(i == 0 && j!= 0){
                    //到达该点需要的长度  该点的值 加上 上一个点的值
                    grid[i][j] += grid[i][j-1];
                }else if(i !=0 && j==0){
                    grid[i][j] += grid[i-1][j];
                }else {
                    //否则比比 左侧 和 上侧的 值 谁更小

                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }

            }
        }

        return  grid[heigh-1][wide-1];

    }





}
