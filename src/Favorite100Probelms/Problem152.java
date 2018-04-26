package Favorite100Probelms;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problem152 {
    public int maxProduct(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int max = 0;
        int rightMax = 1;
        int leftMax =1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0) {
                rightMax *= nums[i];
                max = Math.max(max,rightMax);
            }
            else{
                rightMax=1;
            }
        }
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i]!=0) {
                leftMax *= nums[i];
                    max = Math.max(max,leftMax);
            }
            else{
                leftMax=1;
            }
        }
        return max;
    }
    public static void main(String... args){
        Problem152 main = new Problem152();
        int[] nums = {2,3,-2};
        System.out.println(main.maxProduct(nums));
    }
}
