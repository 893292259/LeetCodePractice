package Favorite100Probelms;

import DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem104 {
    public int maxDepth(TreeNode root) {
        int level = 0;
        if (root!=null){
            List<TreeNode> last = new ArrayList<>();
            last.add(root);
            while (last.size()!=0){
                level++;
                List<TreeNode> current = new ArrayList<>();
                for (TreeNode now:last){
                    if (now.left!=null){
                        current.add(now.left);
                    }
                    if (now.right!=null){
                        current.add(now.right);
                    }
                }
                last = current;
            }
        }
        return level;
    }
    public static void main(String... args){
        Problem104 main = new Problem104();
        TreeNode root = new TreeNode(2);
        System.out.println(main.maxDepth(root));
    }

}
