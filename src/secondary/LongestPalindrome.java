package secondary;

/**
 * @author:yuze
 * @description:找最长的回文子串
 * @data:2021/8/17
 */
public class LongestPalindrome {

    /**
     *
     * 中心扩散法，遍历每一个字符，分别向两边扩散，判断挨着的字符是否相等
     * @author yuze
     * @date 2021/8/17 20:59
     * @param [s]
     * @return java.lang.String
     */
    public static String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        int start = 0,maxLen = 0;
        int length = s.length();
        for (int i = 0; i <length ; ) {
            if(length-i<=maxLen/2){
                break;
            }
            int left = i,right = i;
            while (right<length-1 && s.charAt(right+1) == s.charAt(right)){
                ++right;//过滤重复的
            }
            //下次在判断的时候从重复的下一个字符开始判断
            i = right + 1;
            //然后往两边判断，找出回文子串的长度
            while (right<length-1 && left>0 && s.charAt(right+1) == s.charAt(left-1)){
                ++right;
                --left;
            }
            if(right-left+1>maxLen){
                start=left;
                maxLen=right-left+1;
            }
        }
        return s.substring(start,start+maxLen);
    }

    public static void main(String[] args) {
        String s = "abba";
        String s1 = longestPalindrome(s);
        System.out.println(s1);

    }
}
