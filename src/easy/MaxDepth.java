package easy;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:yuze
 * @description:计算二叉树的深度
 * @data:2022/1/21
 */
public class MaxDepth {
    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (! queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
