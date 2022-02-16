package secondary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:yuze
 * @description:不含有重复字符的最长子串的长度
 * @data:2021/8/17
 */


public class LengthOfLongestSubstring {
    /**
     *
     * 这种方法可以做，但是会超时
     * @author yuze
     * @date 2021/8/17 15:03
     * @param
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (allUnique(s, i, j)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    public static boolean allUnique(String s , int start , int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i <=end ; i++) {
            if(set.contains(s.charAt(i))){
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        int length2 = lengthOfLongestSubstring2(s);
        int length3 = lengthOfLongestSubstring3(s);
        int length4 = lengthOfLongestSubstring4(s);
        System.out.println(length);
        System.out.println(length2);
        System.out.println(length3);
        System.out.println(length4);
    }
    /**
     *
     * 滑动窗口
     * @author yuze
     * @date 2021/8/17 15:14
     * @param [s]
     * @return int
     */
    public static int lengthOfLongestSubstring2(String s){
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        int left = 0,right = 0;
        Set<Character> window = new HashSet<>();
        while (right<n){
            char c = s.charAt(right);
            while (window.contains(c)){
                window.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            window.add(c);
            right++;
        }
        return maxLen;
    }

    /**
     *
     * 优化滑动窗口
     * 因为如果有重复元素left是一个一个右移，如果知道重复元素的索引就可以一步跳过
     * @author yuze
     * @date 2021/8/17 15:15
     * @param
     * @return
     */
    public static int lengthOfLongestSubstring3(String s){
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        int left = 0,right = 0;
        Map<Character,Integer> window = new HashMap<>();
        while (right<n){
            char c = s.charAt(right);
            int rightCIndex = window.getOrDefault(c,0);//如果存在c返回c对应的value即我们存的索引，不存在默认0
            left = Math.max(left,rightCIndex);
            maxLen = Math.max(maxLen, right - left + 1);
            window.put(c,right+1);
            right++;
        }
        return maxLen;
    }
    /**
     *
     * 追求程序的极致性能
     * s 由英文字母、数字、符号和空格组成，128个字符
     * @author yuze
     * @date 2021/8/17 15:33
     * @param [s]
     * @return int
     */
    public static int lengthOfLongestSubstring4(String s){
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        int left = 0, right = 0;
        int[] window = new int[128];
        while (right < n) {
            char rightChar = s.charAt(right);
            int rightCharIndex = window[rightChar];
            left = Math.max(left, rightCharIndex);
            maxLen = Math.max(maxLen, right - left + 1);
            window[rightChar] = right + 1;
            right++;
        }
        return maxLen;
    }
}
