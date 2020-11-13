package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-10 下午11:36
 * @desc
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 **/
public class _38 {

    public static void main(String[] args) {
        _38  test = new _38();
        System.out.println(test.say("21"));
        System.out.println(test.countAndSay(6));
    }

    //迭代计算 直到达到N为止
    public String countAndSay(int n) {
        if(n<=0) return  null ;
        if(n==1) return "1";
        String result ="1" ;
        while(n>1){
        result = say(result);
        n-- ;
        }
        return  result ;
    }
    //处理逻辑
    public  String say(String s){
        int i=0 , j = 0 ;
        StringBuilder sb = new StringBuilder();
        while(j<s.length()){
            if(s.charAt(j) == s.charAt(i)){
                j++ ;
            }else {
                sb.append(j-i );
                sb.append(s.charAt(i));
                i = j ;
            }
        }
        sb.append(j-i) ;
        sb.append(s.charAt(i));
        return sb.toString() ;

    }
}
