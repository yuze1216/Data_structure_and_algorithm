package secondary;

import java.util.Arrays;

/**
 * @author:yuze
 * @description:最接近的三数之和
 * @data:2021/8/20
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE-target;
        for (int i = 0; i <n-2 ; i++) {
            int l = i + 1;
            int r = n-1;
            if(l==r){
                continue;
            }
            while (l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    if(Math.abs(sum-target)<Math.abs(res-target)){
                        res = sum;
                    }
                    l++;
                }else{
                    if(Math.abs(sum-target)<Math.abs(res-target)){
                        res = sum;
                    }
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 2;
        System.out.println(threeSumClosest(nums,target));
    }
}
