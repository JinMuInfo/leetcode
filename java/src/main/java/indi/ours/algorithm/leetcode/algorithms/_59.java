package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-30 下午10:54
 * @desc
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 *
 * [
 * [1,2]
 * [4,3]
 * ]
 *
 * [
 * [1,2,3,4],
 * [12,13,14,5],
 * [11,16,15,6],
 * [10,9,8,7]
 * ]
 *
 *
 *
 * 输出 一个 n*n 的矩形 二维 数组
 *
 **/
public class _59 {
    public static void main(String[] args) {
        _59  test = new _59();
        int  [][] data = test.generateMatrix(5) ;
        for(int i = 0 ; i<data.length ; i++){
            for(int j = 0 ; j<data[0].length; j++){
                System.out.print(data[i][j]);

            }
        System.out.println();
        }
    }


    public int[][] generateMatrix(int n) {
        if(n <=0) return  null ;
        if(n == 1 )  return new int[][]{{1}};
        if(n == 2 )  return new int[][]{{1,2},{4,3}};
        int [][] result = new int[n][n];
        //int max = n*n ;
        int starter = 1 ;
        //int  width = 0 ;
        //int high = 0 ;


        /**
         * 设置 四个边界
         */
        int widthleft = 0 ;
        int widthright = n -1 ;
        int heightupper = 0 ;
        int heightdown = n-1 ;


        System.out.println(heightupper + "  " +heightdown);


        //直接根绝 值 来找  他的 index
        while(widthleft<=widthright){
            //几种极端情况
            /**
             * 1 高度的最小 与 最大
             * 2 宽度的最小 与 最大
             *
             * 按照 圈 数 来 进行 计算
             * 每一圈 内 都有
             * 右  -》  下 -》  左 -》 上
             *
             */


            for(int width = widthleft ; width<=widthright ;width++){

                result[heightupper][width] =starter++ ;

            }
            heightupper++ ;


            for(int height = heightupper ;height<=heightdown ; height++){
                result[height][widthright] = starter++;
            }
            widthright--;
            for(int width = widthright ; width>=widthleft ;width--){
                result[heightdown][width]=starter++;
            }
            heightdown--;

            for(int height = heightdown ; height >=heightupper ; height--){
                result[height][widthleft] = starter++ ;
            }

            widthleft++;


        }
        return result ;
    }
}
