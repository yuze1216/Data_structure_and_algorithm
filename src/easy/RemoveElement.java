package easy;


/**
 * @author:yuze
 * @description:原地移除指定元素，不能开辟新的空间
 * @data:2021/8/22
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int slow=0;
        for (int fast = 0; fast <nums.length ; fast++) {
            if(nums[fast]!=val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums,val));
    }
}
