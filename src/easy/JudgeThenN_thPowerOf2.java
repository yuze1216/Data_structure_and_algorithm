package easy;

/**
 * @author:yuze
 * @description:判断2的N次方，要求效率尽可能的高
 * @data:2022/1/6
 */
public class JudgeThenN_thPowerOf2 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(judge2(n));
    }

    public static boolean judge2(int n){
        if(n==0){
            return false;
        }
        if((n & (n-1)) == 0){
            return true;
        }
        return false;

    }
//    public static boolean judge3(int n){
//        int a = Integer.parseInt(Integer.toString(n,3));
////        int b = Integer.parseInt(Integer.toString(n-1,3));
//        int b = n-1;
//        System.out.println(a);
//        System.out.println(b);
//        if( ( a & b ) == 0){
//            return true;
//        }
//        return false;
//
//    }
}
