package Favorite100Probelms;

import java.util.Stack;

public class Problem084 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i=0;i<heights.length;i++){
            if (stack.empty()||stack.peek()<=heights[i]){
                stack.push(heights[i]);
            }
            else {
                int count = 0;
                while (!stack.isEmpty()&&(stack.peek()>heights[i])){
                    int k = stack.pop();
                    count++;
                     while (!stack.isEmpty()&&stack.peek()<0){
                         count -= stack.pop();
                     }
                    max = Math.max(max,count*k);
                }
                stack.push(-count);
                stack.push(heights[i]);
            }
        }
        int count = 0;
        while (!stack.isEmpty()){
            int k =stack.pop();
            count++;
            while (!stack.isEmpty()&&stack.peek()<0){
                count -= stack.pop();
            }
            max = Math.max(max,count*k);
        }
        return max;
    }
    public static void main (String... args){
        Problem084 main = new Problem084();
        int[] heights = {4,2,0,3,2,5};
        System.out.println(main.largestRectangleArea(heights));
    }
}
