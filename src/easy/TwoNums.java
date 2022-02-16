package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:yuze
 * @description:两数之和
 * @data:2021/8/17
 */
public class TwoNums {
    /**
     *
     * 暴力法,时间复杂度O(n^2)
     * @author yuze
     * @date 2021/8/17 11:27
     * @param [nums, target]
     * @return int[]
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] answer = new int[2];
        for(int i=0;i<nums.length;i++){
            answer[0] = i;
            for(int j=i+1;j<nums.length;j++){
                answer[1] = j;
                if(nums[i]+nums[j]==target){
                    return answer;
                }
            }
        }
        return answer;
    }
    /**
     *
     * 二分查找时间复杂度要低，但是二分查找的前提是有序的数组，如果先排序了，索引会发生变化，代码也就复杂了
     * @author yuze
     * @date 2021/8/17 11:29
     * @param [args]
     * @return void
     */

    /**
     *  哈希查找优化
     * 时间复杂度O(n),实际是O(2n),空间复杂度O(n),空间换时间
     * @author yuze
     * @date 2021/8/17 11:31
     * @param [nums, target]
     * @return int[]
     */
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        // 数据预处理
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // O(n)
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) { // O(n)
            int x = nums[i];
            // 哈希查找 - O(1)
            if (map.containsKey(target - x)) {
                int index = map.get(target - x);
                // i 和 index 不是同一个元素，同一个元素不能使用两次
                if (i != index) return new int[]{i, index};
            }
        }

        return new int[0];
    }

    /**
     *  对哈希查找再次优化
     *
     * @author yuze
     * @date 2021/8/17 11:32
     * @param [nums, target]
     * @return int[]
     */
    public static int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) { // O(n)
            int x = nums[i];
            // 哈希查找
            if (map.containsKey(target - x)) {
                int index = map.get(target - x);
                return new int[]{i, index};
            }
            //这里不需要判断相同重复元素，因为当前元素实在哈希查找之后才放入map的
            map.put(x, i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] answer1 = twoSum1(nums,target);
        int[] answer2 = twoSum2(nums,target);
        int[] answer3 = twoSum3(nums,target);
//        for (int i = 0; i <answer1.length ; i++) {
//            System.out.println(answer1[i]);
//        }
//        for (int i = 0; i <answer1.length ; i++) {
//            System.out.println(answer2[i]);
//        }
        for (int i = 0; i <answer1.length ; i++) {
            System.out.println(answer3[i]);
        }
    }
}
