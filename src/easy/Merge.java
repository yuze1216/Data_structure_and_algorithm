package easy;

/**
 * @author:yuze
 * @description:合并两个有序数组
 * @data:2021/8/17
 */
/**
 *  题目：给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 *输出：[1,2,2,3,5,6]
 * @author yuze
 * @date 2021/8/17 16:28
 * @param
 * @return
 */

public class Merge {
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] temp= new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i<m && j<n){
            if(nums1[i]>=nums2[j]){
                temp[index++] = nums2[j++];
            }else{
                temp[index++] = nums1[i++];
            }
        }
        for (;i<m;){
            temp[index++] = nums1[i++];
        }
        for (;j<n;){
            temp[index++] = nums2[j++];
        }
        for (int k = 0; k <temp.length ; k++) {
            nums1[k] = temp[k];
        }
    }

    /**
     *
     * 从右边一次排序
     * @author yuze
     * @date 2021/8/17 16:42
     * @param
     * @return
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;//num1数组的最右边索引值
        int j = n-1;//num2数组的最右边索引值
        int sum = m+n-1;//合并数组的总长度
        while (j>=0){
            nums1[sum--] = (i>=0 && nums1[i]>nums2[j])?nums1[i--]:nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3,n = 2;
        merge2(nums1,m,nums2,n);
        for (int i = 0; i <nums1.length ; i++) {
            System.out.println(nums1[i]);
        }
    }

}
