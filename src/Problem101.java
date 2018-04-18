import DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        if (root!=null){
            TreeNode left,right;
            List<TreeNode> rightLast = new ArrayList<>();
            List<TreeNode> leftLast = new ArrayList<>();
            rightLast.add(root);
            leftLast.add(root);
            while (leftLast.size()>0) {
                List<TreeNode> rightCurrent = new ArrayList<>();
                List<TreeNode> leftCurrent = new ArrayList<>();
                for (int i=0;i<leftLast.size();i++){
                    left = leftLast.get(i);
                    right = rightLast.get(i);
                    if (left.left!=null&&right.right!=null&&left.left.val==right.right.val){
                            leftCurrent.add(left.left);
                            rightCurrent.add(right.right);
                    }
                    else if (!(left.left==null&&right.right==null)){
                        return false;
                    }
                    if (left.right!=null&&right.left!=null&&left.right.val==right.left.val){
                            leftCurrent.add(left.right);
                            rightCurrent.add(right.left);
                    }
                    else if (!(left.right==null&&right.left==null)){
                        return false;
                    }
                }
                leftLast = leftCurrent;
                rightLast =rightCurrent;
            }
        }
        return true;
    }
    public static void main(String... args){
     Problem101 main = new Problem101();
     TreeNode root = new TreeNode(2);
     TreeNode left = new TreeNode(2);
     TreeNode right =new TreeNode(1);
     root.left = left;
     root.right =right;
     System.out.println(main.isSymmetric(root));
    }
}
