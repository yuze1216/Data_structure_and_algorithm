package easy;
import java.util.Scanner;

/**
 * @author:yuze
 * @description:独一无二的数字
 * @data:2021/9/12
 */
public class OneNumber {

    public static void main(String[] args) {
        int n,i,a,s;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(;;n--)
        {
            for(i=0;i<n;i++)
            {
                s=0;
                if(n==0)
                    break;
                for(i=0;i<n;i++)
                {
                    a=sc.nextInt();
                    s^=a;
                }
                System.out.println(s);
            }
        }

    }
}
