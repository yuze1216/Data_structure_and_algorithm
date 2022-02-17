package easy;


import utils.TreeNode;

/**
 * @author:yuze
 * @description:判断两棵树是否相同
 * @data:2021/8/28
 * 输入：p=[1,2,3]  q=[1,2,3]   输出：true
 * 输入：p=[1,2]  q=[1,null,2]   输出：false
 * 输入：p=[1,2,1]  q=[1,1,2]   输出：false
 */
public class isSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.data != q.data) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}
