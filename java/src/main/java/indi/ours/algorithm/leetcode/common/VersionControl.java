package indi.ours.algorithm.leetcode.common;

/**
 * @author wangheng
 * @create 2018-11-15 下午1:27
 * @desc
 **/
public class VersionControl {

    public boolean isBadVersion(int version){
        int target = 1773234239;
        if(version >target){
            return true ;
        }else {
            return false ;
        }

    }
}
