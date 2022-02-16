package secondary;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:yuze
 * @description:输出第n个丑数（因子只有2，3，5，7）
 * @data:2021/8/28
 */
public class UglyNumber {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        List elements = new LinkedList<Integer>();
        //int[] n = new int[5842];
        //int i =0;
        while (in.hasNext()){
            int element = in.nextInt();
            if(element==0){
                break;
            }else {
                elements.add(element);
            }
        }
        //这种方式list转数组也可以
//        Integer[] iii =new Integer[elements.size()];
//        elements.toArray(iii);
//        for (int j = 0; j <iii.length ; j++) {
//            System.out.println(iii[j]);
//        }
        for (Object a:elements) {
            findUgly(Integer.parseInt(a.toString()));
        }

    }
    public static void findUgly(int n){
        int flag = 0;
        int count ;
        for (count = 1; flag <n ; count++) {
            boolean juge = isUgly(count);
            if(juge){
                flag++;
            }
        }
        count = count-1;
        if (n%10 ==1){
            System.out.println("The "+n+"st humble number is "+count+".");
        }else if(n%10 ==2){
            System.out.println("The "+n+"nd humble number is "+count+".");
        }else if(n%10 ==3){
            System.out.println("The "+n+"rd humble number is "+count+".");
        }else {
            System.out.println("The "+n+"th humble number is "+count+".");
        }

    }
    public static boolean isUgly(int count){
        while (count % 2 == 0) {
            count /= 2;
        }
        while (count % 3 == 0) {
            count /= 3;
        }
        while (count % 5 == 0) {
            count /= 5;
        }
        while (count % 7 ==0){
            count /=7;
        }
        return count == 1 ? true : false;
    }
}
