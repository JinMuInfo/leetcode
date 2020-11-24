package indi.ours.algorithm.leetcode.algorithms;


import java.util.*;

/**
 *
 * @author wh
 *
 * @desc
 * 22. Generate Parentheses
 * Medium
 *
 * 6482
 *
 * 297
 *
 * Add to List
 *
 * Share
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 *
 */
public class _22 {

    public static void main(String[] args) {


        int  a =4 ;
        _22  test =new _22();

        List<String> strings = test.generateParenthesis2(a);
        System.out.println(strings);
        // 12343210
        // 01234567
        //3 ["((()))","(()())","(())()","()(())","()()()"]
        //4["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
        // [()()()(), (()(())), (()())(), ()()(()), (())()(),       (((()))), (())(()), ()((())), ()(())(), ()(()()),        (()()()), ((()())), ((()))(), ((())())]
        //  [(((()))), ((()())), ((())()),      ((()))(), (()(())), (()()()), (()())(),             (())()(),    ()((())),   ()(()()), ()(())(), ()()(()), ()()()()]
        //  [(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]
    }


    /**
     *
     * @param n
     * @return
     * 可以使用递归方式
     * 自我调用
     * 然后逐个插入 一个完整的 （）
     *
     *
     */


    public List<String> generateParenthesis(int n) {

        if(n ==1){
            return Arrays.asList(new String[]{"()"});
        }else {
            //  拿到内层的 数据 然后  在 左中右  三个位置 迭代循环 。
            Set<String>  collection = new TreeSet<>();


            for( String inner : generateParenthesis(n-1)){


                collection.add("("+inner+")");

                //collection.add(inner+"()");
                //collection.add("()"+inner);
                for(int i = 0 ; i< inner.length() ;i++){
                   collection.add(inner.substring(0,i)+"()"+inner.substring(i,inner.length()));
                }


            }



            return new ArrayList<>(collection);

        }

    }


    /**
     * @author
     * @param n
     * @return
     *
     * @desc
     * 方式二
     * 定义一个长度为两倍的数组
     *( 为 +1
     * ） 为 -1
     * 那么最后一位的值为0
     * 且 每个数 都 >=0
     *
     *
     */
    public List<String> generateParenthesis2(int n) {
        //  初始化是 所有的值默认为0 ；
        int [] chars = new int[n*2];
        chars[0] = 1 ;

        Set<int[]> ints = setData(chars, 0);


        //  将 List<int[]>  转为 List<String>  的 方法
        return new ArrayList<>(transfer(ints) );

    }







    public Set<int[]>  setData(int [] data , int n ) {
        Set<int[]>  result = new HashSet<>();


        //  当前位异常 则 直接返回
        // 几个点 ① 当前位 必须大于等于0  ② 当前位的值 必须小于等于当前位的下表+1 (这个点是一致的 因为每次只+1) ③ 当前位的值 必须小于等于  数组总长度length -下标
        if( data[n] <0){
            return result ;
        }
        // 迭代到最后一位时 查看其值  为0 则保留
        if(n == data.length-1  && data[n] ==0){
            result.add(data.clone());
            return result ;
        }

        // 还在迭代进行中


         int next = n +1;
        if(next >=data.length){
            return result ;
        }

         data[next] = data[n] + 1;
         result.addAll(setData(data,next));


         data[next] = data[n] - 1;

         result.addAll(setData(data,next));

        return result ;

    }

    public Set<String>  transfer(Set<int[]> data){
        Set<String >  strings = new HashSet<>();

        for(int[] ss :data){
            StringBuilder  sb = new StringBuilder();
            for(int i = 0 ; i< ss.length ;i++){
                if(i == 0 ){
                    sb.append("(");
                }else if((ss[i]>=0)&&ss[i] - ss[i-1] ==1){
                    sb.append("(");
                }else if((ss[i]>=0)&&ss[i] - ss[i-1] == -1){
                    sb.append(")");
                }else {
                    sb = null;
                    break;
                }
            }
            if(sb !=null){
                System.out.println(sb.toString());
                strings.add(sb.toString());
                //System.out.println(strings);
            }

        }

        return strings;

    }

    public List<String> generateParenthesis3(int n) {
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        sb.append('(');
        bt(sb,list,1,0,n);
        return list;
    }

    void bt(StringBuilder sb, List<String> list, int open, int close, int maxLevel) {
        //  添加了 相同个数的 open  和 close  符号 并且 都等于总个数 就说明组装成功

        if(open==maxLevel&&close==maxLevel) {
            list.add(sb.toString());
            return;
        }


        // 左括号还没添加到位 ，再加左边括号
        if(open<maxLevel) {
            sb.append('(');
            bt(sb,list,open+1,close,maxLevel);
            sb.deleteCharAt(sb.length()-1);
        }

        //  同时 左边括号比右边多 ，同时添加右边的闭合括号
        if(open>close) {
            sb.append(')');
            bt(sb,list,open,close+1,maxLevel);
            sb.deleteCharAt(sb.length()-1);
        }
    }






}


