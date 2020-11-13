package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-19 下午3:27
 * @desc  汉明距离
 * 汉明距离是以理查德·卫斯里·汉明的名字命名的。
 * 在信息论中，两个等长字符串之间的汉明距离是两个字符串对应位置的不同字符的个数。
 * 换句话说，它就是将一个字符串变换成另外一个字符串所需要替换的字符个数
 **/
public class _477 {

    public static void main(String[] args) {
        _477.totalHammingDistance(new int[]{4,2,14});

    }


    /**
     *
     * O(N^2)
     * 超时 严重
     * @param nums
     * @return
     */
    public int totalHammingDistance2(int[] nums) {

        int sum = 0 ;
        for(int i = 0 ;i<nums.length ;i++){
            for(int j = i+1 ;j<nums.length ;j++){
                sum = sum +getHammingDistance(nums[i], nums[j]);
            }
        }
        return  sum ;
    }

    int getHammingDistance(int a ,int b){
        int result = 14 ^ 2;
        int count = 0 ;
        while(result >0){
            if((result&1)==1 ){
                count++;
            }
            result >>=1 ;
        }
        return count ;
    }


    /**
     * O(n)
     *
     * @param nums
     * @return
     */
    public static  int totalHammingDistance(int[] nums){
        int total = 0 ;

        for(int i = 0 ;i<32 ;i++){
            int isone = 0 ;
            int iszero = 0 ;
            for(int num :nums){
                //先移位运算   在进行 &1  即可求得该位上 为1 的数量
                isone += (num>>i) &1 ;
                iszero = nums.length -isone ;
                //相同  为 0  不同为1
            }
            total += isone*iszero ;
        }
        return  total ;
    }

}
