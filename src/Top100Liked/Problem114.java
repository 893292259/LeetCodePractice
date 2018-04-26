package Top100Liked;

import DataStructures.TreeNode;

public class Problem114 {
    public void flatten(TreeNode root) {
        if (root!=null) {
            helper(root);
        }
    }
    public TreeNode helper (TreeNode parent){
        TreeNode lastright = parent.left!=null? helper(parent.left):parent;
        TreeNode lastleft = parent.right!=null? helper(parent.right):lastright;
        TreeNode temp = parent.right;
        parent.right = parent.left;
        lastright.right = temp;
        parent.left = null;
        return lastleft;
    }
    public static void main(String...args){
        Problem114 main = new Problem114();
        TreeNode root = new TreeNode(2);
        main.flatten(root);
    }
}
