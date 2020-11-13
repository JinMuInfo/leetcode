package indi.ours.algorithm.leetcode.algorithms;

import indi.ours.algorithm.leetcode.common.VersionControl;

/**
 * @author wangheng
 * @create 2018-11-15 下午1:25
 * @desc
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 **/
public class _278 extends VersionControl {
    public int firstBadVersion(int n) {

        return firstBadVersion(0 ,n);


    }


    public int firstBadVersion(int starter , int ender ){
        //这样写 主要是 为了避免数据的越界 问题
        // starter  必然小于 ender
        // starter  直接加 ender  会越界
        int middle = starter + (ender-starter )/2 ;


        if(!isBadVersion(middle) && isBadVersion(middle+1)){
            return middle+1 ;
        }else if(isBadVersion(middle) && isBadVersion(middle+1)){
            return firstBadVersion( starter ,middle);
        }else if(!isBadVersion(middle) && !isBadVersion(middle+1)){
           // System.out.println(middle  +"    " + ender);
            return firstBadVersion(middle ,ender);
        }

        return  0 ;
    }


    /**
     * 摘自讨论区
     * @param n
     * @return
     */
    public int firstBadVersion2(int n) {
        int lo = 1, hi = n, mid;
        int first = n;
        while (lo <= hi) {
            mid = lo + (hi-lo) / 2;
            boolean bad = isBadVersion(mid);
            if (bad) {
                first = Math.min(first, mid);
                hi = mid-1;
            }
            else lo = mid+1;
        }

        return first;
    }

}
