package Top100Liked;

public class Problem198 {
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int[] data = new int[nums.length];
        data[0] = nums[0];
        data[1] = Math.max(nums[0],nums[1]);
        int max = data[1];
        for (int i=2;i<nums.length;i++){
            data[i] = Math.max(nums[i]+data[i-2],data[i-1]);
            max = Math.max(max,data[i]);
        }
        return max;

    }
    public static void main(String... args){
        Problem198 main = new Problem198();
        int[] nums = {2,3,5,6,3,2,1,4,2};
        System.out.println(main.rob(nums));
    }
}
