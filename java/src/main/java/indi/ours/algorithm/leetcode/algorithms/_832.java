package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-19 下午7:06
 * @desc
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 * Example 1:
 *
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 先左右的翻转  再  内容上的翻转
 **/
public class _832 {
    /**
     * O(n)
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int len = A[i].length - 1;
            for (int j = 0; j < (len + 2) / 2; j++) {
                int temp = A[i][j] ^ 1;
                A[i][j] = A[i][len - j] ^ 1;
                A[i][len - j] = temp;
            }
        }
        return A;
    }
}
