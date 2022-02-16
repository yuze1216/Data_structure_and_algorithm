package easy;

/**
 * @author:yuze
 * @description:二进制求和，结果范围和的二进制
 * @data:2021/10/25
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(),b.length());
        int al = a.length();
        int bl = b.length();
        int carry = 0;//表示进位
        for (int i = 0; i < n ; ++i) {
            carry += i<al ? (a.charAt(al - 1 - i)-'0') : 0;
            carry += i<bl ? (b.charAt(bl - 1 - i)-'0') : 0;
            ans.append((char)(carry % 2 + '0'));
            carry /=2;
        }
        if(carry>0){
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String s = addBinary(a, b);
        System.out.println(s);

    }

}
