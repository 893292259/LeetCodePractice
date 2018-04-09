import java.util.Stack;

public class Problem085 {
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
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if (matrix.length!=0) {
            int a = matrix.length, b = matrix[0].length;
            int[][] maxHeight = new int[a][b];
            for (int i = 0; i <= b - 1; i++) {
                maxHeight[0][i] = matrix[0][i] == '0' ? 0 : 1;
            }
            for (int i = 1; i <= a - 1; i++) {
                for (int j = 0; j <= b - 1; j++) {
                    maxHeight[i][j] = matrix[i][j] == '0' ? 0 : 1 + maxHeight[i - 1][j];
                }
            }
            for (int i = 0; i <= a - 1; i++) {
                max = Math.max(max, largestRectangleArea(maxHeight[i]));
            }
        }
        return max;
    }
    public static void main(String... args){
        Problem085 main = new Problem085();
        char[][] matrix = {{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','0','0'}};
        System.out.println(main.maximalRectangle(matrix));
    }
}
