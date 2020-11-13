package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-15 上午11:40
 * @desc
 * realted topic Binary Search
 *
 *
 *
 **/
public class _852 {


    public int peakIndexInMountainArray(int[] A) {
        int max = 0 ;
        int index  = 0 ;

        for(int i = 0 ; i<A.length ; i++){
            if(A[i] >max){
                max = A[i] ;
                index = i ;
            }
        }
        return  index ;
    }


    /**
     * 左指针  右指针
     * @param A
     * @return
     */
    public int peakIndexInMountainArray2(int[] A) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else if (A[mid] < A[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
