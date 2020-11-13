package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-18 下午12:34
 * @desc
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
 *
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the largest.
 *
 * 找出 构成三角形的最大面积
 *
 **/
public class _812 {

    /**
     * 穷举法
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for(int i= 0 ; i<points.length ;i++){
            for(int j = i+1 ; j<points.length;j++){
                for(int k = j+1; k<points.length ;k++){
                    max = Math.max(max,getArea( i, j, k,points));
                }
            }
        }
        return max;
    }

    public  double  getArea(int i ,int j ,int k,int[][] points){
        //获取这三个点的坐标
        int [] p1 = points[i];
        int [] p2 = points[j];
        int [] p3 = points[k];

        double area = 0;
        area += area(p1, p2);
        area += area(p2, p3);
        area += area(p3, p1);

        return Math.abs(area);

    }
    double area(int[] p1, int[] p2) {
        int w = p2[0] - p1[0];
        double h = (p1[1] + p2[1]) / 2.0;
        return w * h;
    }




}
