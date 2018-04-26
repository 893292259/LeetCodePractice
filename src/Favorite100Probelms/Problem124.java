package Favorite100Probelms;

import DataStructures.TreeNode;

public class Problem124 {
    int max;
    public int helper(TreeNode root) {
        int currentMax =root.val;
        int singleMax = root.val;
        int leftMax=0,rightMax=0;
        if (root.left!=null){
            leftMax = helper(root.left);
        }
        if (root.right!=null){
            rightMax = helper(root.right);
        }
        singleMax += Math.max(0,Math.max(rightMax,leftMax));
        currentMax += Math.max(0,rightMax)+Math.max(0,leftMax);
        max = Math.max(max,currentMax);
        return singleMax;
    }
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    public static void main(String... args){
        Problem124 main = new Problem124();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left =left;
        root.right =right;
        System.out.println(main.maxPathSum(root));
    }
}
