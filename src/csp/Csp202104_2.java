package csp;

import java.util.Scanner;

/**
 * @author:yuze
 * @description:邻域均值
 * @data:2021/9/14
 */
public class Csp202104_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =0,l=0,r=0,t=0;
        n=scanner.nextInt();
        l=scanner.nextInt();
        r=scanner.nextInt();
        t=scanner.nextInt();

        //System.out.println(n+" "+l+" "+r+" "+t);
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                boolean flag = find(arr,i,j,r,t);
                if(flag){
                    count+=1;
                }else {
                    continue;
                }
            }
        }
        System.out.println(count);

    }

    public static boolean find(int[][] arr,int index1,int index2,int r,int t){
        int xmax=0,xmin=0,ymax=0,ymin=0;
        int[] aaa = range(index1, index2, r, arr);
        xmin = aaa[0];
        xmax =aaa[1];
        ymin = aaa[2];
        ymax = aaa[3];
        int count=0;
        for (int i = xmin; i <= xmax; i++) {
            for (int j = ymin; j <= ymax ; j++) {
                count+=arr[i][j];
            }
        }
        double avg =(double) count/((xmax-xmin+1)*(ymax-ymin+1));
        if(avg<=t){
            return true;
        }
        return false;
    }

    public static int[] range(int index1,int index2,int r,int[][] arr){
        int xmax=0,xmin=0,ymax=0,ymin=0;
        if(r+index1<=arr.length-1){
            xmax = r+index1;
        }else {
            xmax = arr.length-1;
        }
        if(index1-r>=0){
            xmin = index1-r;
        }else {
            xmin = 0;
        }
        if(r+index2<=arr.length-1){
            ymax = r+index2;
        }else {
            ymax = arr.length-1;
        }
        if(index2-r>=0){
            ymin = index2-r;
        }else {
            ymin = 0;
        }
//        System.out.println(xmin+" "+xmax+" "+ymin+" "+ymax);
        int[] len = new int[4];
        len[0] = xmin;
        len[1] = xmax;
        len[2] = ymin;
        len[3] = ymax;
        return len;
    }

}
