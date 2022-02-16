package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:yuze
 * @description:质因数分解
 * @data:2021/9/12
 */
public class ZhiYinShuFenJie {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] integers = find(n);
        for (int i:integers) {
            if(zhi(i)){
                System.out.println(i);
                break;
            }

        }

    }
    public static Integer[] find(int n ){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = n; i >=1 ; i--) {
            if(n%i==0){
                list.add(i);
            }
        }
        Integer[] num = new Integer[list.size()];
        Integer[] integers = list.toArray(num);
        return integers;
    }
//    public static Integer[] decPrime(int n) {
//        List<Integer> list = new ArrayList<Integer>();
//        for (int i=2;i <= n;i++){
//            while(n != i){
//                if(n%i != 0){
//                    break;//不能整除肯定不是因数，能够整除在这里一定是质数。因为所有的2，3,5,7
//                    //都被除完之后。剩下的因数只能是奇数，且是质数。
//                }
//                list.add(Integer.valueOf(i));
//                n = n/i;
//            }
//        }
//        list.add(Integer.valueOf(n));
//        return list.toArray(new Integer[list.size()]);
//    }
    public static boolean zhi(int n ){

        for (int i = 2; i <n ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
