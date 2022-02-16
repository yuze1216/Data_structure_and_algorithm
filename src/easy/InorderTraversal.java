package easy;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:yuze
 * @description:返回中序遍历结果
 * @data:2021/8/22
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root.left!=null){
            inorderTraversal(root.left);
        }
        list.add(root.data);
        if(root.right!=null){
            inorderTraversal(root.right);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
