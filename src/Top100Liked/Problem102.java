package Top100Liked;

import DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root!=null){
            List<TreeNode> last = new ArrayList<>();
            last.add(root);
            while (last.size()!=0){
                List<Integer> result = new ArrayList<>();
                List<TreeNode> current = new ArrayList<>();
                result = new ArrayList<>();
                for (TreeNode now:last){
                    if (now.left!=null){
                        current.add(now.left);
                    }
                    if (now.right!=null){
                        current.add(now.right);
                    }
                    result.add(now.val);
                }
                results.add(result);
                last = current;
            }
        }
        return results;
    }
    public static void main(String... args){
        Problem102 main = new Problem102();
        TreeNode root = new TreeNode(2);
        System.out.println(main.levelOrder(root));
    }
}
