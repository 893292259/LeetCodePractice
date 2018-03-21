public class Problem011 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while (left<right){
            max = Math.max(max,(right-left)*Math.min(height[right],height[left]));
            if (height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
    public static void main(String... args){
        Problem011 main = new Problem011();
        int[] array = {2,3,4,1,2,4};
        System.out.println(main.maxArea(array));
    }
}
