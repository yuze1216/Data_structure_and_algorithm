package own;

import java.util.Scanner;

/**
 * @author:yuze
 * @description:质因数分解
 * @data:2021/8/29
 */
public class ZhiFenJie {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i;
        int j=0;
        for (i = 2; i <Math.sqrt(n) ; i++) {
            if(n%i==0){
                j=n/i;
            }
        }
        if(i>j){
            System.out.println(i);
        }else {
            System.out.println(j);
        }
    }
}
