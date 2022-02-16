package secondary;

/**
 * @author:yuze
 * @description:友好字符串，s1中两个元素交换等于s2则返回true，反之返回false
 * @data:2022/1/20
 */
public class FriendlyString {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "aa";
        System.out.println(judge(s1,s2));
    }
    public static boolean judge(String s1,String s2){
        if(s1.equals(s2)){
            return true;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        int difCount = 0;
        int m = -1;//统计到的第一个字符下标
        int n = -1;//统计到的第二个字符的下标
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                difCount++;
                if(difCount ==1){
                    m = i;
                }else if(difCount == 2){
                    n = i;
                }
            }
            if(difCount > 2){
                return false;
            }
        }

        return m != -1 && n != -1 && s1.charAt(m) == s2.charAt(n) && s1.charAt(n) == s2.charAt(m);
    }
}
