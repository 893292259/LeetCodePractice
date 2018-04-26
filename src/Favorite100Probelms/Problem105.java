package Favorite100Probelms;

import DataStructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem105 {
    int[] preorder;
    int[] inorder;
    Map<Integer,Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder =preorder;
            this.inorder = inorder;
            inorderMap = new HashMap<>();
            for (int i=0;i<inorder.length;i++){
                inorderMap.put(inorder[i],i);
            }
            return helper(0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode helper (int pstart, int pend, int istart, int iend){
        if (pstart>pend){
            return null;
        }
        else if (pstart==pend){
            return new TreeNode(preorder[pstart]);
        }
        else {
            int target = preorder[pstart];
            int i = inorderMap.get(target);
            TreeNode result = new TreeNode(target);
            TreeNode left = helper(pstart+1,pstart+i-istart,istart,i-1);
            TreeNode right =helper(pstart+i-istart+1,pend,i+1,iend);
            result.left = left;
            result.right =right;
            return result;
        }
    }
    public static void main(String... args){
        Problem105 main = new Problem105();
        int[] preorder= {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = main.buildTree(preorder,inorder);
        return;
    }
}
