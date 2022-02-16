package easy;

import utils.TreeNode;

/**
 * @author:yuze
 * @description:将有序数组转换成二叉搜索树
 * @data:2022/1/23
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sort(nums,0,nums.length-1);
    }
    public static TreeNode sort(int[] nums,int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sort(nums,left,mid-1);
        root.right = sort(nums,mid+1,right);
        return root;
    }

}
