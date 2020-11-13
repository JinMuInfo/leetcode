package indi.ours.algorithm.leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangheng
 * @create 2018-10-15 下午12:42
 * @desc   比较两个字符创是否一样  他们包含 # 符号即为 退格的意思
 *
 * Can you solve it in O(N) time and O(1) space?
 **/
public class _844 {

    public static void main(String[] args) {
        _844 test = new _844() ;
        System.out.println( test.backspaceCompare("ab#c","aaaa#####ab#c"));
    }

    /**
     * 从后往前数  不一样就 over  遇到 # 就继续  结果超时
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare2(String S, String T) {
        //倒着来记录#,之前有的话就跳过，没有append
        String newS = check(S);
        System.out.println(newS);
        String newT = check(T);
        System.out.println(newT);
        return newS.equals(newT);
    }
    private String check(String s) {
        StringBuilder sbS = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    sbS.append(s.charAt(i));
                }
            }

        }
        return sbS.reverse().toString();
    }



    /**
     * 使用链表  来插入 和删除
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        for(int i = 0 ; i<S.length();i++){
            if(S.charAt(i) == '#'){
                if(list1.size()>0){
                    list1.removeLast();
                }
            }else {
                list1.addLast(S.charAt(i));
            }
        }

        for(int i = 0 ; i<T.length();i++){
            if(T.charAt(i) == '#'){
                if(list2.size()>0) {
                    list2.removeLast();
                }
            }else {
                list2.addLast(T.charAt(i));
            }
        }
        if(list1.equals(list2)){
            return true ;
        }else return false ;

    }

    //O(1) space
    public boolean backspaceCompare3(String S, String T) {
        //loop from the end
        int countS = 0, countT = 0;
        int iS = S.length() - 1, iT = T.length() - 1;
        while (iS >= 0 || iT >= 0) {
            while (iS >= 0 && (countS > 0 || S.charAt(iS) == '#')) {
                if (S.charAt(iS) == '#') {
                    countS++;
                    iS--;
                } else {
                    iS--;
                    countS--;
                }
            }
            char tempS = iS < 0 ? ' ' : S.charAt(iS);
            while (iT >= 0 && (countT > 0 || T.charAt(iT) == '#')) {
                if (T.charAt(iT) == '#') {
                    countT++;
                    iT--;
                } else {
                    iT--;
                    countT--;
                }
            }
            char tempT = iT < 0 ? ' ' : T.charAt(iT);
            if (tempT != tempS) {
                return false;
            }
            iS--;
            iT--;
        }
        return true;
    }



}
