package secondary;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:yuze
 * @description:二叉树的右视图。给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @data:2022/2/16
 */
public class RightSideView {
    static List<Integer> res = new ArrayList<>();
    /**
     *
     * 广度优先搜索BFS，层层遍历
     * @author yuze
     * @date 2022/2/16 9:31
     * @param
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(i == size - 1){
                    list.add(node.data);
                }
            }
        }
        return list;
    }
    /**
     *
     * 深度优先搜索dfs解法，每次先访问根节点的右边节点
     * @author yuze
     * @date 2022/2/16 9:31
     * @param [root]
     * @return java.util.List<java.lang.Integer>
     */
    public static List<Integer> rightSideView2(TreeNode root) {
        dfs(root,0);
        return res;
    }
    public static void dfs(TreeNode root,int deapth){
        if(root == null){
            return;
        }
        if(deapth == res.size()){
            res.add(root.data);
        }
        deapth++;
        dfs(root.right,deapth);
        dfs(root.left,deapth);
    }
    public static void main(String[] args) {

    }
}
