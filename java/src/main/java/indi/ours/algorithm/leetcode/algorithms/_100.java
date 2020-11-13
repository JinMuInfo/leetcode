package indi.ours.algorithm.leetcode.algorithms;


import indi.ours.algorithm.leetcode.common.TreeNode;

/**
 * @author wangheng
 * @create 2018-10-09 下午12:15
 * @desc
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * 给两个 二叉树   判断他们俩是否相等
 **/
class _100 {

    public static void main(String[] args) {


    }


    public boolean isSameTree(TreeNode p, TreeNode q) {



        if(p == null && q == null ) return true ;
        if(p ==null  || q ==null ) return  false ;

        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right) ;

        }else return false ;

    }







}
