package indi.ours.algorithm.leetcode.common;

/**
 * @author wangheng
 * @create 2018-10-09 下午12:17
 * @desc
 **/
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }

      public static TreeNode getTreeNodes(){
            TreeNode  node = new TreeNode(1);
            node.left = new TreeNode(2);
            node.right = new TreeNode(3);
            node.left.right = new TreeNode(5);
            node.right.right = new TreeNode(4);
            node.right.right.right = new TreeNode(6);


            return node;
      }
}
