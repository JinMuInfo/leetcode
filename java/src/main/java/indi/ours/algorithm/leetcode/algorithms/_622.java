package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-12-24 下午5:11
 * @desc
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 *
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 *
 * Your implementation should support following operations:
 *
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * Front: Get the front item from the queue. If the queue is empty, return -1.
 * Rear: Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * isEmpty(): Checks whether the circular queue is empty or not.
 * isFull(): Checks whether the circular queue is full or not.
 *
 *
 * Example:
 *
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
 * circularQueue.enQueue(1);  // return true
 * circularQueue.enQueue(2);  // return true
 * circularQueue.enQueue(3);  // return true
 * circularQueue.enQueue(4);  // return false, the queue is full
 * circularQueue.Rear();  // return 3
 * circularQueue.isFull();  // return true
 * circularQueue.deQueue();  // return true
 * circularQueue.enQueue(4);  // return true
 * circularQueue.Rear();  // return 4
 *
 * Note:
 *
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Queue library.
 *
 *
 *
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 *
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * 示例：
 *
 * MyCircularQueue circularQueue = new MycircularQueue(3); // 设置长度为3
 *
 * circularQueue.enQueue(1);  // 返回true
 *
 * circularQueue.enQueue(2);  // 返回true
 *
 * circularQueue.enQueue(3);  // 返回true
 *
 * circularQueue.enQueue(4);  // 返回false,队列已满
 *
 * circularQueue.Rear();  // 返回3
 *
 * circularQueue.isFull();  // 返回true
 *
 * circularQueue.deQueue();  // 返回true
 *
 * circularQueue.enQueue(4);  // 返回true
 *
 * circularQueue.Rear();  // 返回4
 *
 *
 *
 * 提示：
 *
 * 所有的值都在 1 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 *
 *
 *
 * 自定义一个循环队列
 *
 * 一个指定的大小
 * 一个 header
 *
 * 要点 ： 一定要注意保持内部数据的 一致性  不仅仅是 starter 和 ender 的一致性
 *
 **/
public class _622 {

    int [] data  ;
    int size = 0 ;
    int starter = 0 ;
    int ender = 0 ;
    int maxsize = 0 ;



    /** Initialize your data structure here. Set the size of the queue to be k. */
    public _622(int k) {

        maxsize = k ;
        data = new int[k];

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        //插入数据
        /*if(isFull()) return false ;
        if(isEmpty()){
            data[starter] = value ;
            size++ ;
            return true ;

        }else {
            if(ender+1 <maxsize){
                data[++ender] = value ;
                size ++ ;
                return true ;
            }else {
                data[0]= value ;
                //覆盖
                //size++;
                ender = 0 ;
                if(starter ==ender){
                    starter++ ;
                }
                return true;
            }
            */


        if(isFull() )return false ;
        if(isEmpty()){
            data[ender] = value;
            size=size+1<=maxsize?size+1:size ;

        }else {
            ender = ender+1 <maxsize ? ender+1 :0;
            data[ender] = value ;
            starter = (starter==ender)?(starter+1<maxsize?starter+1 : 0):starter;
            size=size+1<=maxsize?size+1:size ;


        }
        return  true ;

    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())return false;

        data[starter] = 0;

        starter = starter+1 <maxsize ? starter+1 : 0 ;
        size = size-1 >-1 ?size-1:0;
        if(size==0)ender =starter ;

        return true ;



    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return  -1 ;
        return data[starter];

    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())return -1 ;
           return data[ender];

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(size >0)return false ;
        else return true ;


    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(size <maxsize)return false ;
        else return true ;

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */