package easy;

/**
 * @author:yuze
 * @description:爬楼梯，假设你正在爬楼梯。
 * 需要 n 阶你才能到达楼顶。  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 这道题有一个规律
 * 我们用 f(x)表示爬到第 x级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
 * f(x)=f(x−1)+f(x−2)
 * @data:2022/1/22
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
        System.out.println(climbStairs2(n));
        System.out.println(climbStairs3(n));
    }

    public static int climbStairs(int n) {//递归法
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
    public static int climbStairs2(int n) {//动态规划
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] dp = new int[n+1];//这里申请了n+1个长度数组，但是代码发现我们只需要记录三个数字就好了，所以可以改进
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static int climbStairs3(int n) {//动态规划改进
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int first = 1;
        int second = 2;
        int third;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}
