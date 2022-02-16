package secondary;


/**
 * @author:yuze
 * @description:x的n次幂
 * @data:2021/8/23
 */
public class Pow {
    /**
     *
     * 超时了
     * @author yuze
     * @date 2021/8/23 20:48
     * @param [x, n]
     * @return double
     */
    public static double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        double ans = 1;
        for (int i = 0; i <n ; i++) {
            ans *= x;
        }
        return ans;
    }


    public static double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? myPowHelper(x, N) : 1.0 / myPowHelper(x, -N);
    }
    /**
     *
     * 分治算法：递归
     * @author yuze
     * @date 2021/8/23 20:51
     * @param [x, n]
     * @return double
     */
    public static double myPowHelper(double x, long n) {
        if(n == 0){
            return 1.0;
        }
        double y = myPowHelper(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
    public static void main(String[] args) {
        double x = 2.0000;
        int n = -10;
        System.out.println(myPow2(x,n));
    }
}
