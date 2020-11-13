package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-19 下午7:01
 * @desc Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 *
 * 矩阵 翻转
 **/
public class _867 {

    public int[][] transpose(int[][] A) {
        int r = A.length, c = A[0].length;
        int[][] matrix = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                matrix[i][j] = A[j][i];
            }
        }
        return matrix;


    }
}
