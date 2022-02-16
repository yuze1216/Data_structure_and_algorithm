package csp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author:yuze
 * @description:Csp 2020 12 2
 * @data:2021/9/17
 */
public class Csp202012_2 {

    public static void main(String[] args) {//超时了
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int ans=0,max=0;
        for (int i = 0; i <n ; i++) {
            int count = 0;
            for (int j = 0; j <n ; j++) {
                if(j<i&&arr[j][1]==0&&arr[j][0]!=arr[i][0] || j<i&&arr[j][0]==arr[i][0]&&arr[j][1]==1){
                    count++;
                }
                if(j>=i&&arr[j][1]==1){
                    count++;
                }
            }
            if(count>=max){
                max=count;
                ans=arr[i][0];
            }
        }
        System.out.println(a(arr));
    }

    public static int a(int[][] arr) {//不超时，强哥教的
        int len = arr.length;
        int ans = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            count += arr[i][1];//初始化count值
        }
        max=count;
        ans = arr[0][0];
        for (int j = 1; j < len; j++) {
            if (arr[j - 1][1] == 1) {
                count--;
            } else {
                count++;
            }
            if(count>=max && arr[j-1][0]!=arr[j][0]){
                max = count;
                ans = arr[j][0];
            }
        }
        return ans;
    }

}
