package indi.ours.algorithm.leetcode.algorithms;

import indi.ours.algorithm.leetcode.common.TreeNode;

import java.util.HashSet;

/**
 * @author wangheng
 * @create 2018-12-28 上午11:11
 * @desc
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 * Seen this question in a real interview before?
 *
 **/
public class _653 {

    /**
     * 将数据 放在 hasset  中
     * 判断 需要的补集是否在集合中
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }


}
