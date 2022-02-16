package secondary;

/**
 * @author:yuze
 * @description:有序数组中差绝对值之和，leetcode1685题
 * @data:2022/1/8
 */
public class GetSumAbsoluteDifferences {

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0]=1;
        nums[1]=4;
        nums[2]=6;
        nums[3]=8;
        nums[4]=10;
        int sum = 0;
        int len = nums.length;
        int[] preSum = new int[len];
        //计算前缀和
        for(int i=0;i<len;i++){
            sum += nums[i];
            preSum[i] = sum;
        }
        //计算每个数的差绝对值之和
        int[] result = new int[len];
        for(int i=0;i<len;i++){
            // int sumOfLeftDifferences = (i+1)*nums[i]-prefixSum[i];
            // int sumOfRightDifferences = prefixSum[nums.length-1]-prefixSum[i]-nums[i]*(nums.length-1-i);
            // sumOfDifferences =  sumOfLeftDifferences+sumOfRightDifferences;
            result[i] = (i+1)*nums[i]-preSum[i]+ preSum[len-1]-preSum[i]-nums[i]*(len-1-i);
        }
        for (int i = 0; i <len ; i++) {
            System.out.println(result[i]);
        }


    }
}
