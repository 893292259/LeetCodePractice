package Top100Liked;

public class Problem053 {
    public int maxSubArray(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        else {
            int[] largest = new int[nums.length];
            largest[0] = nums[0];
            int max = largest[0];
            for (int i=1;i<nums.length;i++){
                largest[i] = Math.max(nums[i],largest[i-1]+nums[i]);
                max = Math.max(max,largest[i]);
            }
            return max;
        }
    }
    public static void main(String... args){
        Problem053 main = new Problem053();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(main.maxSubArray(nums));
    }
}
