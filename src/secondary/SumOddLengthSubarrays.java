package secondary;


/**
 * @author:yuze
 * @description:计算所有奇数长度子数组的和
 * @data:2021/8/29
 */
public class SumOddLengthSubarrays {
    /**
     *
     * 暴力法
     * @author yuze
     * @date 2021/8/29 20:57
     * @param [arr]
     * @return int
     */
    public static int sumOddLengthSubarrays1(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }
    /**
     *  
     * 前缀和法
     * @author yuze
     * @date 2021/8/29 20:58
     * @param [arr]
     * @return int
     */
    public static int sumOddLengthSubarrays2(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                sum += prefixSums[end + 1] - prefixSums[start];
            }
        }
        return sum;
    }

    /**
     *
     * 数学法
     * @author yuze
     * @date 2021/8/29 20:58
     * @param [arr]
     * @return int
     */
    public static int sumOddLengthSubarrays3(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int leftCount = i, rightCount = n - i - 1;
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = leftCount / 2 + 1;
            int rightEven = rightCount / 2 + 1;
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays1(arr));
    }

}
