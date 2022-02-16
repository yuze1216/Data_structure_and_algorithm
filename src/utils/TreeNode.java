package utils;

import java.util.LinkedList;

/**
 * @author:yuze
 * @description:树
 * @data:2022/2/16
 */
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.data = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
    public static void main(String[] args) {//插入树
        int [] arr = new int[] {23,45,67,12,55,13,14,50};
        TreeNode tree =new TreeNode();
        TreeNode treeNode = tree.initTree(arr);
        treeNode.add(treeNode,1);
        System.out.println(treeNode);
//        tree.xian(tree);
//        System.out.println();
//        tree.zhong(tree);
//        System.out.println();
//        tree.hou(tree);
//        tree.CheckTree(tree,100);
//        tree.binaryTreeLevelOrder(tree);
    }
    public TreeNode initTree(int[] arr){
        TreeNode tree =new TreeNode();
        tree.data=arr[0];
        for(int i=1;i<arr.length;i++){
            TreeNode n=new TreeNode(arr[i]);
            TreeNode flag=tree;
            for(;;){
                if(flag.data<=n.data) {
                    if(flag.right==null) {
                        flag.right=n;
                        break;
                    } else {
                        flag = flag.right;
                    }
                }else {
                    if(flag.left==null) {
                        flag.left=n;
                        break;
                    }else {
                        flag=flag.left;
                    }
                }
            }
        }
        return tree;
    }
    public void add(TreeNode tree,int x){//添加单个数字

        if(x>tree.data){
            if(tree.right==null){
                tree.right = new TreeNode();
            }else {
                add(tree.right,x);
            }
        }else {
            if(tree.left==null){
                tree.left = new TreeNode(x);
            }else {
                add(tree.left,x);
            }
        }
    }
    public void CheckTree(TreeNode flag,int x) {//查找指定元素
        for(;;) {
            if(flag==null) {
                System.out.println("没有这个数据");
                break;
            }
            if(flag.data==x) {
                System.out.println("找到了");
                break;
            }else if(flag.data>x){
                flag=flag.left;
            }else {
                flag=flag.right;
            }
        }
    }
    /**
     *
     * 深度优先遍历的三种方式
     * @author yuze
     * @date 2021/8/22 16:19
     * @param [tree]
     * @return void
     */
    public void xian(TreeNode tree){
        System.out.print(tree.data+",");
        if(tree.left!=null){
            xian(tree.left);
        }
        if(tree.right!=null){
            xian(tree.right);
        }
    }
    public void zhong(TreeNode tree){

        if(tree.left!=null){
            zhong(tree.left);
        }
        System.out.print(tree.data+",");
        if(tree.right!=null){
            zhong(tree.right);
        }
    }
    public void hou(TreeNode tree){
        if(tree.left!=null){
            hou(tree.left);
        }
        if(tree.right!=null){
            hou(tree.right);
        }
        System.out.print(tree.data+",");
    }
    public void binaryTreeLevelOrder(TreeNode tree){
        if(tree == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur;
        queue.offer(tree);
        while (!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur.data + " ");
            if(cur.left != null)//如果当前节点的左节点不为空入队
            {
                queue.offer(cur.left);
            }
            if(cur.right != null)//如果当前节点的右节点不为空，把右节点入队
            {
                queue.offer(cur.right);
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
