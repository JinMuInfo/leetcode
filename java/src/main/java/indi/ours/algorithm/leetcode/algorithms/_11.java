package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-11-01 下午6:28
 * @desc
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 *
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * 高度 * 宽度  7*(8-1)
 **/
public class _11 {

    public int maxArea(int[] height) {
        int left =0;
        int right = height.length -1 ;
        int container = 0 ;
        while(left <right){
            //计算值
            int result = Math.min(height[left],height[right] ) *(right-left) ;
            container = container >result ?container:result;

            if(height[left] <height[right]){
                left++;
            }else{
                right--;
            }

        }
        return  container;

    }


}
