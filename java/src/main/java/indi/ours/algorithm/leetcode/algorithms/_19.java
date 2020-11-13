package indi.ours.algorithm.leetcode.algorithms;

import indi.ours.algorithm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangheng
 * @create 2018-11-08 下午3:54
 * @desc
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 * 移除 链表中的 第 倒数 第 N位元素
 *
 * */
public class _19 {
    public static void main(String[] args) {
        _19  test = new _19() ;
        ListNode listNode = new ListNode(1) ;
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode RE = test.removeNthFromEnd(listNode ,2) ;
        while (RE!= null){
            System.out.println(RE.val);
            RE = RE.next ;
        }
    }


    /**
     * 摘自讨论区 O(n)
     * 设置 一个起点 一个 终点 ，终点和起点 相差 N 个 单位
     * 当 终点 到头时  起点 为需要替换的的值
     * @param head
     * @param n
     * @return
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, back = head;
        while(n-- > 0) front = front.next;
        if(front == null) return head.next;
        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }



}

