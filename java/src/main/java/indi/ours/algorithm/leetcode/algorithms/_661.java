package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-24 下午2:02
 * @desc
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 * Example 1:
 * Input:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * Output:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 *
 *
 * 包含整数的二维矩阵 M 表示一个图片的灰度。
 * 你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，
 * 如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 **/
public class _661 {

    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        int count = 0;
        int sum = 0;
        for(int i = 0 ; i < M.length ; i++){

            for(int j = 0 ; j < M[0].length ; j++){
                sum =M[i][j];
                count=1;

                if(i-1>=0){
                    sum+=M[i-1][j];
                    count++;
                    if(j-1>=0){
                        sum+=M[i-1][j-1];
                        count++;
                    }
                    if(j+1<M[0].length){
                        sum+=M[i-1][j+1];
                        count++;
                    }
                }

                if(j+1<M[0].length){
                    sum+=M[i][j+1];
                    count++;
                }

                if(j-1>=0){
                    sum+=M[i][j-1];
                    count++;
                    if(i+1<M.length){
                        sum+=M[i+1][j-1];
                        count++;
                    }
                }

                if(i+1<M.length){
                    sum+=M[i+1][j];
                    count++;

                    if(j+1<M[0].length){
                        sum+=M[i+1][j+1];
                        count++;
                    }
                }
                res[i][j] = (int)Math.floor(sum/count);
            }
        }

        return res;
    }



}