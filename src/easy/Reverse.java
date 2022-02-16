package easy;

/**
 * @author:yuze
 * @description:整数反转
 * @data:2021/8/17
 */
public class Reverse {
//    public static int reverse(int x) {
//        if(x>=10){
//            int a = x%10;//3
//            x=(x-a)/10;//12
//            int b = 0;
//            while (x>=10){
//                b=x%10;//2
//                x=(x-b)/10;//1
//                a=a*10+b;//32
//            }
//            return a*10+x;
//        }else if(x<0){
//            x=-(x);
//            int a = x%10;//3
//            x=(x-a)/10;//12
//            int b = 0;
//            while (x>=10){
//                b=x%10;//2
//                x=(x-b)/10;//1
//                a=a*10+b;//32
//            }
//            return -(a*10+x);
//        }else {
//            return x;
//        }
//
//    }
    public static int reverse(int x) {
        int a = 0;
        int b = 0;
        while(x!=0){
            b = x%10;

            if(a>Integer.MAX_VALUE/10||(a==Integer.MAX_VALUE/10&&b>Integer.MAX_VALUE%10)) return 0;
            if(a<Integer.MIN_VALUE/10||(a==Integer.MIN_VALUE/10&&b<Integer.MIN_VALUE%10)) return 0;
            //判断条件不满足的时候才进行计算
            a = a*10+b;
            //继续倒着取下一位
            x = x/10;
        }
        return a;
    }
    public static void main(String[] args) {
        int x = -1234560;
        int reverse = reverse(x);
        System.out.println(reverse);
    }


}
