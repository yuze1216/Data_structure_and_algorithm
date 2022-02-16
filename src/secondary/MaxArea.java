package secondary;


/**
 * @author:yuze
 * @description:盛最多水的容器
 * @data:2021/8/19
 */
public class MaxArea {
    /**
     *
     * 暴力解法 力扣不允许通过
     * @author yuze
     * @date 2021/8/19 20:51
     * @param [height]
     * @return int
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int di = 0;
        int gao = 0;
        int area = 0;
        for (int i = 0; i <len ; i++) {
            for (int j = i+1; j <len ; j++) {
                di = j-i;
                gao = Math.min(height[i],height[j]);
                area = Math.max(area,di*gao);
            }
        }
        return area;
    }
    /**
     *
     * 双指针法
     * @author yuze
     * @date 2021/8/19 20:52
     * @param height
     * @return int
     */
    public static int maxArea2(int[] height) {
        int left = 0,right = height.length-1;
        int maxArea = 0;
        while (left<right){
            maxArea = Math.max (maxArea,(right-left) * Math.min(height[left],height[right]));
            if(height[left]<=height[right]){
                ++left;
            }else{
                --right;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }
}
