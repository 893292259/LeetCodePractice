package Favorite100Probelms;

import DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            while (!stack.isEmpty()){
                TreeNode current = stack.pop();
                result.add(current.val);
                if (current.right!=null){
                    current = current.right;
                    while (current!=null){
                        stack.push(current);
                        current = current.left;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String... args){
        Problem094 main = new Problem094();
        TreeNode root = new TreeNode(2);
        main.inorderTraversal(root);
    }
}
