package indi.ours.algorithm.leetcode.algorithms;

import indi.ours.algorithm.leetcode.common.TreeNode;

/**
 * @author wangheng
 * @create 2018-10-09 下午12:51
 * @desc  symmetric
 *
 * 给定一个 二叉树 判断其 是否是对称的
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 **/
public class _101 {
    public static void main(String[] args) {
        //[1,2,2,3,4,4,3]
        TreeNode  treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = null ;
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = null ;

        _101 tret = new _101();
       boolean f =  tret.isSymmetric(treeNode);
        System.out.println(f);

    }


    public boolean isSymmetric(TreeNode root) {
        if(root ==null) return true ;
        return checkIsSymmetric(root.left ,root.right) ;
    }

     boolean checkIsSymmetric(TreeNode left ,TreeNode right){
        if(left ==null && right ==null) return true ;
        if(left ==null || right ==null) return false ;
        if(left.val !=right.val)return  false ;
        return checkIsSymmetric(left.left ,right.right) && checkIsSymmetric(left.right ,right.left);
    }


}
