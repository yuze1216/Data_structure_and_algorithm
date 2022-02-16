package csp;

import java.util.Scanner;

/**
 * @author:yuze
 * @description:csp 2020  12 01
 * @data:2021/9/17
 */
public class Csp202012_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int a=0,b=0;
        for (int i = 0; i <n ; i++) {
            a=scanner.nextInt();
            b=scanner.nextInt();
            sum+=a*b;
        }
        //int x= 0;
        System.out.println(Math.max(0,sum));
    }
}
