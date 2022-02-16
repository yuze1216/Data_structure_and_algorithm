package easy;

/**
 * @author:yuze
 * @description:最长公共前缀
 * @data:2021/8/20
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0){
            return "";
        }
        int len = strs.length;
        String prefix = strs[0];
        for (int i = 0; i <len ; i++) {
            prefix = longestCommonPrefix(strs[i],prefix);
            if(prefix.length()==0){
                break;
            }
        }
        return prefix;
    }
    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static void main(String[] args) {
        String[] s = {"abc","abbbe","abeee"};
        System.out.println(longestCommonPrefix(s));
    }
}
