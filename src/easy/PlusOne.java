package easy;

/**
 * @author:yuze
 * @description:给定一个数组，每个数字代表整数的每一位，实现+1操作，[1,2,3]表示123
 * @data:2021/8/22
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        int[] a = plusOne(digits);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
