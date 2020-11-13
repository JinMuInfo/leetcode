package indi.ours.algorithm.leetcode.algorithms;

import indi.ours.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author wangheng
 * @create 2018-11-25 下午11:38
 * @desc
 *
 *   Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
    Example 1:
    Input:
    3
    / \
    9  20
    /  \
    15   7
    Output: [3, 14.5, 11]
    Explanation:
    The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
    Note:
    The range of node's value is in the range of 32-bit signed integer.

 *
 **/
public class _637 {

    public static void main(String[] args) {
        TreeNode  root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        _637  test = new _637();
        test.averageOfLevels2(root);
    }

    /**
     * 记录各行的  总和 ？ 在记录一下各行的  总个数？
     * 最后在求一个平均值
     * @param root
     * @return
     */
    List<List<Long> >list = new ArrayList<List<Long> >();
    public List<Double> averageOfLevels(TreeNode root) {
        getSumOfLevels(root ,0);
        System.out.println(list);

        List<Double>  result = new ArrayList<Double>();

        for(List tmp : list){
            double  div = ((long)tmp.get(1) +0.0)/(long)tmp.get(0);
            System.out.println(div);
            result.add(div);
        }



        return  result ;



    }
    public void getSumOfLevels(TreeNode root ,int level) {
        if(root == null) {
            ;
        }else {
            if (list.size() <=level ){
                list.add(level, Arrays.asList(new Long[]{1L,(long) root.val}));
            } else {
                list.set(level, Arrays.asList(list.get(level).get(0)+1, list.get(level).get(1) + root.val));
            }
            getSumOfLevels(root.left, level + 1);
            getSumOfLevels(root.right, level + 1);

        }

    }


    /**
     * BFS
     * 每行的个数 ，每行的值的和 。
     * @param root
     * @return
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        //q.add(root);
        q.offer(root);

        while(!q.isEmpty()) {
            //当前大小
            int size = q.size();
            double avg = 0.0;
            int count = 0;
            //把 queue 里的所有元素遍历一遍
            //并取出
            // 如果他们有子集  就加入到queue中
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                count++;
                avg += (double)cur.val;
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(avg/(double) count);

        }
        return res;
    }


}
