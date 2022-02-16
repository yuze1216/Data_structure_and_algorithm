package secondary;

import java.util.Random;

/**
 * @author:yuze
 * @description:数组排序
 * @data:2021/9/1
 */
public class SortArray {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] num = {5,2,3,1,1,12,32,431,53,6543,653,653,4234,6535,73,5435,53,45,2345,234,4234,4234235,643524,64352,5425234,524,4324,};
        int[] ints = sortArray2(num);
        long endTime = System.nanoTime();
        for (int i = 0; i < ints.length ; i++) {
            System.out.println(ints[i]);
        }
        System.out.println("程序运行时间：" +(endTime-startTime) + "ns");
        //在需要排序的数量很大 的情况下快排才会更快
    }
    /**
     *
     * 暴力法
     * @author yuze
     * @date 2021/9/1 18:41
     * @param
     * @return
     */
    public static int[] sortArray1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i <= len-2 ; i++) {
            for (int j = i+1; j <=len-1 ; j++) {
                if(nums[i]>=nums[j]){
                    swap(nums,i,j);
                }
            }
        }
        return nums;
    }
    private static void swap(int[] nums, int i, int j) {//交换函数
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /**
     *
     * 快速排序
     * @author yuze
     * @date 2021/9/1 21:33
     * @param [nums]
     * @return int[]
     */
    public static int[] sortArray2(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public static int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }


}
