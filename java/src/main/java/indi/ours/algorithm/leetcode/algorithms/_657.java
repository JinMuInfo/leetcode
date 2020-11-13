package indi.ours.algorithm.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangheng
 * @create 2018-10-11 上午12:05
 * @desc
 * ，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束
 **/
public class _657 {
    public boolean judgeCircle2(String moves) {
        char[] c = moves.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('U' ,0);
        map.put('D', 0);
        map.put('L', 0);
        map.put('R', 0);
        for(char tmp:c) {
            map.replace(tmp, map.get(tmp) +1);
        }
        if(map.get('U').equals(map.get('D')) &&map.get('L').equals(map.get('R')) ) return true;
        return false;
    }

    public boolean judgeCircle(String moves) {
        // NOTE: maintain two variable x and y
        // "L": y--, "R" y++, "U": x++, "D": x--
        // Finally, check if x==0 and y ==0
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;
                case 'U':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
            }
        }
        return x == 0 && y== 0;
    }


    public boolean judgeCircle3(String moves) {
        int[] chr = new int[86];
        for (char c : moves.toCharArray()){
            chr[c]++;
        }
        if (chr['L'] != chr['R']){
            return false;
        }
        if (chr['U'] != chr['D']){
            return false;
        }
        return true;
    }
}
