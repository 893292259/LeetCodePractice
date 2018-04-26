package Top100Liked;

import DataStructures.TreeNode;

public class Problem098 {

    public boolean isValidBST(TreeNode root) {
        return isValidImpl(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidImpl (TreeNode current, long min, long max){
        boolean flag = true;
        if (current!=null){
            int val = current.val;
            flag&=val<max && val>min && isValidImpl(current.left,min,val) && isValidImpl(current.right,val,max);
        }
        return flag;
    }
    public static void main(String... args){
        Problem098 main = new Problem098();
        TreeNode root = new TreeNode(2);
        System.out.println(main.isValidBST(root));
    }
}
