package csp;

import java.util.Scanner;

/**
 * @author:yuze
 * @description:灰度直方图
 * @data:2021/9/14
 */
public class Csp202104_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =0,m=0,l=0;
        n=scanner.nextInt();
        m=scanner.nextInt();
        l=scanner.nextInt();
        //System.out.println(n+""+m+""+l);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m ; j++) {
//                System.out.println(arr[i][j]);
//            }
//        }
        int[] h = new int[l];
        for (int i = 0; i < l; i++) {
            h[i] = count(arr,n,m,i);
            if(i!=l-1){
                System.out.print(h[i]+" ");
            }else {
                System.out.print(h[i]);
            }
        }
    }

    public static int count(int[][] arr, int n,int m,int index){
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
               if(arr[i][j]==index){
                   count++;
               }
            }
        }
        return count;
    }
}
