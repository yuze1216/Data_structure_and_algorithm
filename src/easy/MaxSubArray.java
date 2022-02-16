package easy;

/**
 * @author:yuze
 * @description:最大子数组和问题，子数组是连续的
 * @data:2022/1/20
 */
public class MaxSubArray {
    //https://blog.csdn.net/m0_53611007/article/details/122610324，查看博客思路
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));
    }
    public static int maxSubArray(int[] nums) {//贪心算法
        int len = nums.length;
        int preSum = nums[0];
        int curSum = 0;
        int maxAns = nums[0];
        for (int i = 1; i < len; i++) {
            if (preSum < 0){
                preSum = nums[i];
            }else {
                curSum = preSum + nums[i];
                preSum = curSum;
            }
            maxAns = Math.max(maxAns,preSum);
        }
        return maxAns;
    }
    public static int maxSubArray2(int[] nums){//动态规划

        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] >= 0){
                nums[i] = nums[i-1] + nums[i];
            }
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
        }
        return max;
    }
}
