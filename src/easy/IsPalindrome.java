package easy;

/**
 * @author:yuze
 * @description:回文数
 * @data:2021/8/19
 */
public class IsPalindrome {
    /**
     *
     * 暴力法，直接算出转换后的数字 判断是否相等
     * @author yuze
     * @date 2021/8/19 19:24
     * @param x
     * @return boolean
     */
    public static boolean isPalindrome(int x) {
        int num = x;
        int a = 0;
        int b = 0;
        while(x!=0){
            b = x%10;
            //反转溢出肯定不是回文数
            if(a>Integer.MAX_VALUE/10||(a==Integer.MAX_VALUE/10&&b>Integer.MAX_VALUE%10)) return false;
            if(a<Integer.MIN_VALUE/10||(a==Integer.MIN_VALUE/10&&b<Integer.MIN_VALUE%10)) return false;
            //判断条件不满足的时候才进行计算
            a = a*10+b;
            //继续倒着取下一位
            x = x/10;
        }
        if (a == num && num>=0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        System.out.println(isPalindrome(-1211));
    }
}
