package easy;

/**
 * @author:yuze
 * @description:leetcode121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @data:2022/2/22
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
    public static int maxProfit2(int[] prices) {//这个方法用时和内存消耗都要比上一个大，不建议
        int len = prices.length;
        int max = 0;
        int[] dp = new int[len];
        dp[0] = prices[0];
        for (int i = 1; i < len; i++) {
            dp[i] = (prices[i] > dp[i - 1]) ? dp[i - 1] : prices[i];
            max =  Math.max(prices[i] - dp[i],max);
        }
        return max;
    }
}
