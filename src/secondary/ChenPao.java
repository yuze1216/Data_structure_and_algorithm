package secondary;

import java.util.Scanner;

/**
 * @author:yuze
 * @description:晨跑 三数字最小公倍数
 * @data:2021/9/12
 */
public class ChenPao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i <3 ; i++) {
            int n = scanner.nextInt();
            arr[i] = n;
        }
        int a = minBei(arr[0],arr[1]);
        int b = minBei(a,arr[2]);
        System.out.println(b);
    }

    public static int minBei(int a,int b){
        int i =0;
        if (a<b){
            i = b;
        }else {
            i=a;
        }
        while (i<a*b){
            if(i%a==0 && i%b==0){
                   return i;
                }
            i++;
        }
        return a*b;
    }
}
