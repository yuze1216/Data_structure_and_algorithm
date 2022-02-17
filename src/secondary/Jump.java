package secondary;

/**
 * @author:yuze
 * @description:leetcode45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 * @data:2022/2/17
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,2,3};
        int jump = jump(nums);
        System.out.println(jump);
    }
    /**
     *  如果我们「贪心」地进行正向查找，每次找到可到达的最远位置，就可以在线性时间内得到最少的跳跃次数。
     * 在具体的实现中，我们维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。
     *
     * 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
     * @author yuze
     * @date 2022/2/17 14:32
     * @param [nums]
     * @return int
     */
    public static int jump(int[] nums) {
        int len = nums.length;
        int end = 0;//根据当前元素确定的步数能到达的最远下标(下标+元素值)
        int max = 0;//下一步能到达的最远下标(下标+小于等于元素的值)
        int step = 0;
        for (int i = 0; i < len -1; i++) {
            max = Math.max(max,nums[i] + i);
            if(i == end){//下标到达上次取到的最云下标，这时候肯定是要走一步了
                end = max;//重新为能走的最远下标位置赋值
                step++;
            }
        }
        return step;
    }

    /**
     *
     * 从后向前找，找到可以一步跳到最后一个的元素，可能会找到多个，按照贪心的想法我们找最靠前的那个，但是时间复杂度On2超时了
     * @author yuze
     * @date 2022/2/17 14:11
     * @param [nums]
     * @return int
     */
    public static int jump2(int[] nums) {
        int n = nums.length - 1;
        int steps = 0;
        while (n > 0){
            for (int i = 0; i < n; i++) {
                if(i+nums[i] >= n){
                    n = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
