package difficulty;

/**
 * @author:yuze
 * @description:寻找两个有序数组的中位数
 * @data:2021/8/19
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1,right = -1;
        int aStart = 0,bStart = 0;
        for (int i = 0; i <=len/2 ; i++) {
            left = right;
            if(aStart < m &&(bStart>=n || nums1[aStart]<nums2[bStart])){
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        if((len & 1) == 0){
            return (left + right)/2.0;
        }
        return right;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }
}
