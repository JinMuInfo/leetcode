package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-05 上午11:40
 * @desc  将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数
 *
 * 下 到底  右上上升  在下到底。。。。
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 **/
public class _6 {

    public static void main(String[] args) {
        _6  test = new _6();
        System.out.println(test.convert("PAYPALISHIRING",3));
    }



    /**
     * 在研究一次 发现 每行的数字的下表都是有规律的 （numrow 为4）
     * 0    6           12          18     N* (2ROW-2)  +0 /-0
     * 1   5  7       11  13    17          N* (2ROW-2) +1 /-1
     * 2  4   8   10      14  16            N* (2ROW-2) +2 /-2
     * 3         9          15          N* (2ROW-2) +3/-3
     *
     * （numrow 为3）
     * 0        4           8               N* (2ROW-2)
     * 1    3       5      7    9
     * 2                6           10
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows ==1) return s ;
        StringBuilder sb = new StringBuilder( );
        int stander = (numRows -1)*2 ;

        for(int i = 0 ; i<numRows ; i++){

            //j 的跨越范围还可以在优化  比如找到前一个 就直接找到了后一个
            for(int j = i ; j<s.length() ; j++){
               if( j%stander == i ||j%stander ==stander-i  ){
                   sb.append(s.charAt(j));
               }
            }

        }

        return sb.toString();
    }


}
