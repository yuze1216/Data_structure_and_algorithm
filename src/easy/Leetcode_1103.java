package easy;

/**
 * @author:yuze
 * @description:分糖果
 * @data:2022/1/9
 */
public class Leetcode_1103 {

    public static void main(String[] args) {
        int candies = 7;
        int num_people = 4;
        int[] ans = new int[num_people];
        int i = 0;
        while (candies!=0){
            ans[i % num_people] += Math.min(candies,i+1);
            candies -= Math.min(candies,i+1);
            i+=1;
        }
        for (int j = 0; j < 4; j++) {
            System.out.println(ans[j]);
        }
    }
}
