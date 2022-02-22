package secondary;

/**
 * @author:yuze
 * @description:leetcode122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * @author yuze
 * @date :2022/2/22
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * @param
 * @return
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] arrr = {6,1,3,2,4,7};
        System.out.println(maxProfit(arrr));
    }
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i] > prices[i+1]) {
                max += prices[i] - min;
                min = Integer.MAX_VALUE;
            }
            if((i+1) == prices.length-1 && max != 0 && prices[i+1]>=prices[i]){
                max += prices[i+1] - min;
            }
            if((i+1) == prices.length-1 && max == 0 && prices[i+1]>=prices[i]){//递增
                max = prices[i+1] - min;
            }
            if((i+1) == prices.length-1 && max == 0 && prices[i+1]<prices[i]){//递减
                max = 0;
            }
        }
        return max;
    }
}
