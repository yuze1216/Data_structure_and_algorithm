package secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:yuze
 * @description:四数之和
 * @data:2021/8/20
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4)
            return new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len-3 ; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;

            for (int j = i+1; j <len-2 ; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int partSum = nums[i] + nums[j];
                int left = j+1;
                int right = len-1;

                while (left<right){
                    int sum = partSum + nums[left] + nums[right];
                    if(sum<target){
                        left++;
                    }else if( sum>target){
                        right--;
                    }else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重
//                        while (left < right && nums[left] == nums[++left]);
//                        while (left < right && nums[right] == nums[--right]);
                        while (left < right) {
                            // 不管前后相不相等，left 都要往前走
                            left++;
                            if (nums[left - 1] != nums[left]) break;
                        }
                        while (left < right) {
                            // 不管前后相不相等，right 都要往后走
                            right--;
                            if (nums[right + 1] != nums[right]) break;
                        }

                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;
        System.out.println(fourSum(nums,target));
    }
}
