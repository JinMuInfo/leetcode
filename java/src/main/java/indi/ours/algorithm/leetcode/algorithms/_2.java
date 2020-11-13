package indi.ours.algorithm.leetcode.algorithms;

import indi.ours.algorithm.leetcode.common.ListNode;

/**
 * @author hbn.king
 * @create 2018-09-17 下午4:56
 * @desc
 **/



public class _2 {


    /**
     * 简单的方法   每两个相加 求出 余数  超过十 就 保留 并 为下一次加一
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2 ;
        if(l2 == null) return l1 ;
        boolean flag = true ;
        ListNode result = null ;
        ListNode tmp = null ;
        int carry  = 0;
        while(l1 != null || l2 != null || carry !=0){
            int add = (l1==null? 0 :l1.val ) + ( (l2==null)?0:l2.val) + carry;
            int sum = add >9? add%10 : add;


            /**
             * 创建生成新的ListNode
             */

            if(flag){
                result = new ListNode(sum) ;
                tmp = result ;
                flag = false ;

            }else{
                tmp.next = new ListNode(sum);
                tmp = tmp.next ;
            }

            carry = add >9? (add/10) : 0;

            l1 = (l1==null)?null:l1.next ;
            l2 = (l2==null)?null:l2.next ;

        }
        return  result ;

    }



}
