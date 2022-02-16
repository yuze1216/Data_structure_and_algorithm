package easy;

/**
 * @author:yuze
 * @description:删除有序数组中的重复项，不可开辟新的数组，只能原地修改，返回删除后的数组长度
 * @data:2021/8/21
 */
public class removeNumsDuplicates {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left=1;
        int right=1;
        while (right<len){
            if(nums[right] != nums[right-1]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,2,2,3,4,5,5};
        System.out.println(removeDuplicates(arr));
    }
}
