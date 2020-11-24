package indi.ours.algorithm.leetcode.algorithms;


import java.util.HashMap;
import java.util.Map;

/**
 * 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers
 * Medium
 *
 * 114
 *
 * 30
 *
 * Add to List
 *
 * Share
 * Given two arrays of integers nums1 and nums2, return the number of triplets formed (type 1 and type 2) under the following rules:
 *
 * Type 1: Triplet (i, j, k) if nums1[i]2 == nums2[j] * nums2[k] where 0 <= i < nums1.length and 0 <= j < k < nums2.length.
 * Type 2: Triplet (i, j, k) if nums2[i]2 == nums1[j] * nums1[k] where 0 <= i < nums2.length and 0 <= j < k < nums1.length.
 *
 *
 * Example 1:
 *
 * Input: nums1 = [7,4], nums2 = [5,2,8,9]
 * Output: 1
 * Explanation: Type 1: (1,1,2), nums1[1]^2 = nums2[1] * nums2[2]. (4^2 = 2 * 8).
 * Example 2:
 *
 * Input: nums1 = [1,1], nums2 = [1,1,1]
 * Output: 9
 * Explanation: All Triplets are valid, because 1^2 = 1 * 1.
 * Type 1: (0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2).  nums1[i]^2 = nums2[j] * nums2[k].
 * Type 2: (0,0,1), (1,0,1), (2,0,1). nums2[i]^2 = nums1[j] * nums1[k].
 * Example 3:
 *
 * Input: nums1 = [7,7,8,3], nums2 = [1,2,9,7]
 * Output: 2
 * Explanation: There are 2 valid triplets.
 * Type 1: (3,0,2).  nums1[3]^2 = nums2[0] * nums2[2].
 * Type 2: (3,0,1).  nums2[3]^2 = nums1[0] * nums1[1].
 * Example 4:
 *
 * Input: nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
 * Output: 0
 * Explanation: There are no valid triplets.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 1 <= nums1[i], nums2[i] <= 10^5
 *
 */
public class _1577 {

    public static void main(String[] args) {

        int [] nums1 = new int[]{7,4};
        int[] nums2 = new int[]{5,2,8,9};

        //System.out.println(43024*99908);
        //System.out.println(1864*1864);
        _1577 test = new _1577();

        System.out.println(test.numTriplets(nums1,nums2));

    }

    public int numTriplets(int[] nums1, int[] nums2) {
        return  dealArray(nums1,nums2)+dealArray(nums2,nums1);

    }


    int  dealArray(int[] nums1, int[] nums2){
        int result = 0 ;
        Map<Long ,Integer> map = new HashMap<>();
        for(long num :nums1){
            map.put( num*num,map.getOrDefault((Long) num*num,0)+1);
        }
        for (int j = 0 ; j<nums2.length ;j++){
            for (int k = j+1; k < nums2.length; k++) {
                result += map.getOrDefault((long)nums2[j]* (long) nums2[k],0);
            }
        }

        return result ;
    }


    /**
     *
     * @param nums1
     * @param nums2
     * @return
     *
     * @Desc
     * 此方法 为三次循环
     * 时间复杂度较高
     * 为 n 的 三次方
     * 超时不可行
     */
    public int numTriplets9(int[] nums1, int[] nums2) {

        int result = 0 ;


        for(int i = 0 ; i< nums1.length ;i++){

            for(int j = 0 ; j<nums2.length ; j++ ){

                for(int k = j+1 ;k< nums2.length ; k++){

                    if(  nums1[i] >=Math.min(nums2[j],nums2[k]) &&  nums1[i] <=Math.max(nums2[j],nums2[k]) && nums1[i] *nums1[i] -nums2[j]*nums2[k] ==0){
                        result = result +1 ;
                    }

                }

            }

        }


        for(int i = 0 ; i< nums2.length ;i++){

            for(int j = 0 ; j<nums1.length ; j++ ){

                for(int k = j+1 ;k< nums1.length ; k++){

                    if(  nums2[i] >=Math.min(nums1[j],nums1[k])&&  nums2[i] <=Math.max(nums1[j],nums1[k]) && nums2[i] *nums2[i] -nums1[j]*nums1[k] ==0 ){
                        result = result +1 ;
                    }

                }

            }

        }


        return result;

    }
}
