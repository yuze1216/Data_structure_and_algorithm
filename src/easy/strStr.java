package easy;

/**
 * @author:yuze
 * @description:判断两个字符串是否存在包含关系
 * @data:2021/8/22
 */
public class strStr {

    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "abcde";
        String needle = "bcd";
        System.out.println(haystack.indexOf(needle));
        System.out.println("===================");
        System.out.println(strStr(haystack,needle));
    }
}
