package secondary;

/**
 * @author:yuze
 * @description:两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * @data:2021/9/24
 */
public class Divide {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 1;
        System.out.println(divide(dividend,divisor));
    }
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        int sine = (dividend>0)^(divisor>0)?-1:1;
        if(dividend>0){//这里都转成负数，因为int类型的最小值转为整数会越界溢出
            dividend = -dividend;
        }
        if(divisor>0){
            divisor = -divisor;
        }
        int res = 0;
        while (dividend<=divisor){
            dividend -= divisor;
            res++;
        }
        return sine==1?res:-res;
    }
}
