package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-26 下午5:40
 * @desc
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 **/
public class _232 {

    int []  data = new int[1024];
    int length =1024 ;
    int starter = 0 ;
    int ender = 0 ;
    int size = 0 ;
    /** Initialize your data structure here. */
    public _232() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        data[ender] = x ;
        ender = ender+1 <length ?ender+1 :0;
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!empty()){
            int index =starter ;
            starter = starter+1 <length ?starter+1 : 0;
            size--;

            return data[index];

        }
        return  -1 ;

    }

    /** Get the front element. */
    public int peek() {

        return data[starter];
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        if(size>0)return false;
        return true ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
