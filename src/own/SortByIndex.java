package own;

import java.util.Scanner;

/**
 * @author:yuze
 * @description:根据二维数组下标0进行排序(就是第一列数字，然后交换行)
 * @data:2021/8/29
 */
public class SortByIndex {

    public static void main(String[] args) {
        Scanner c1=new Scanner(System.in);
        int length=c1.nextInt();
        int[][] arrnew=new int[length][2];
        for (int i = 0; i <length ; i++) {
            int s1=c1.nextInt();
            int s2=c1.nextInt();
            arrnew[i][0]=s1;
            arrnew[i][1]=s2;
        }
        sort(arrnew);
        for (int i = 0; i <arrnew.length ; i++) {
            System.out.print(arrnew[i][0]);
            System.out.print(" ");
            System.out.print(arrnew[i][1]);
            System.out.println();
        }
    }
    public static void sort(int[][] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if(arr[j][0]>arr[j+1][1]){
                    int[] temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
