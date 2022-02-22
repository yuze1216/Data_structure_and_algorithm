package secondary;

/**
 * @author:yuze
 * @description:LeetCode55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 * @data:2022/2/17
 */
public class CanJump {

    public static   boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if(i <= rightmost){
                rightmost = Math.max(rightmost,i + nums[i]);
                if(rightmost >= n-1){
                    return true;
                }
            }
        }

        return false;
    }
    public boolean canJump2(int[] nums) {
        if (nums==null || nums.length==0) return false;

        int i,j,len;
        len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (i=1; i<len; i++) {
            if (dp[i-1] && nums[i-1]>0) {//上一个元素可以到达，且上一个元素怒>0，则当前元素必然可以到达
                dp[i] = true;
            } else {//上一个元素可以到达，但是上一个元素值为0
                for (j=0; j<i; j++) {
                    if (dp[j] && nums[j]>=(i-j)) {//遍历上一个元素之前的元素，看是否可以通过某一个元素躲开元素为0的元素直接到达
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[len-1];
    }

}
