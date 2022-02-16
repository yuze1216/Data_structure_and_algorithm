package secondary;

import utils.TreeNode;

/**
 * @author:yuze
 * @description:二叉搜索树转换成累加树
 * @data:2022/1/13
 */
public class ConvertBST {
    public static int sum = 0;
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,6,0,2,5,7,3,8};
        TreeNode root = new TreeNode();
         root.initTree(arr);//给树初始化赋值，方便测试
        //System.out.println(root);
        System.out.println(convertBST(root));
    }
    public static TreeNode convertBST(TreeNode root){
        if(root!=null){
            convertBST(root.right);
            sum += root.data;//节点值累加
            root.data = sum;//更新当前节点的值
            convertBST(root.left);
        }
        return root;
    }
}
