package easy;

/**
 * @author:yuze
 * @description:查找元素：二维数组每一行升序排列，每一列升序排列
 * @data:2021/10/25
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row: matrix) {
            int search = search(row, target);
            if(search >=0){
                return true;
            }
        }
        return false;
    }
    /**
     *
     * 二分法，二位数组的每一行进行二分查找
     * @author yuze
     * @date 2021/10/25 19:34
     * @param [nums, target]
     * @return int
     */
    public static int search(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (right-left)/2+left;
            int num = nums[mid];
            if (num > target){
                right = mid-1;
            }else if(num < target){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] m = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean b = searchMatrix(m, 20);
        System.out.println(b);
    }
}
