package easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:yuze
 * @description:数组去重并排序
 * @data:2021/9/12
 */
public class MingMingDeSuiJiShu {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);//排序
//        for (int i = 0; i <n ; i++) {
//            System.out.println(arr[i]);
//        }
        int sum = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) // 如果待输出数字与前面数字重复，则进入下一次循环，实现去重输出
                continue;
            //System.out.print(" "+arr[i]);
            sum+=1;
        }
        System.out.println(sum);
        System.out.print(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) // 如果待输出数字与前面数字重复，则进入下一次循环，实现去重输出
                continue;
            System.out.print(" "+arr[i]);
        }
    }

    public static int[] quChong(int[] arr ){
        int[] ans = new int[arr.length];

        return null;
    }
}
