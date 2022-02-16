package easy;

/**
 * @author:yuze
 * @description:搜索插入位置:给定一个排序数组和一个目标值,如果存在目标值返回索引，不存在返回应该插入位置的索引
 * @data:2021/8/22
 */
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i <nums.length ;) {
            while (nums[i]<target ){
                i++;
                if(i==nums.length){
                    return i;
                }
            }
            return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums,target));
    }
}
