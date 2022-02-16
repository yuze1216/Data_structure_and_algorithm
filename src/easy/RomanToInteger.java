package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:yuze
 * @description:罗马数字转换成阿拉伯数字
 * @data:2021/8/20
 */
public class RomanToInteger {
    public static int romanToInteger(String s){
        Map<Character,Integer> map = new HashMap<Character,Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };
        int len = s.length();
        int ans = 0;
        for (int i = 0; i <len ; i++) {
            int value = map.get(s.charAt(i));
            if(i<len-1 && value<map.get(s.charAt(i+1))){
                ans-=value;
            }else {
                ans+=value;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "IV";
        System.out.println(romanToInteger(s));
    }
}
