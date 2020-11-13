package indi.ours.algorithm.leetcode.algorithms;

import indi.ours.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangheng
 * @create 2018-12-17 下午7:40
 * @desc
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *      1            <---
 *    /   \
 *   2     3         <---
 *    \
 *     5          <---
 *
 *
 **/
public class _199 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNodes();
        _199  ee = new _199();
        System.out.println(ee.rightSideView(treeNode));
    }


    /**
     * 方案一  将 这个树封装的一个 list<list>中
     * 获取 每一个的最后一个元素
     * @param root
     * @return
     */
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        if(root==null)  return result;

        collectdata(root,0);

        return result;
    }


    /**
     * 深度优先算法
     * 广度优先算法
     * @param root
     * @param deep
     * @DESC
     * 先加入本身
     * 右不为空 先 加入右边
     * 左边不为空  后加入 但是如果右边已经加入了左边是无法加入的
     *
     */
    public  void collectdata(TreeNode root,int deep){

            //防止越界的异常
            if(deep >=result.size()){
                result.add(root.val);

            } else {
                //数组 的替换方法
               // result.set(deep,root.val);
            }


            //先左先右的顺序 与 是否替换有关
            if(root.right!=null){
                collectdata(root.right ,deep+1);
            }

            if(root.left !=null){
                    collectdata(root.left,deep+1);
                }



        }

}
