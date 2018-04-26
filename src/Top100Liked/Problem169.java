package Top100Liked;

public class Problem169 {
    int[] nums;
    int remainder;
    public int majorityElement(int[] nums) {
        this.nums = nums;
        return helper(nums.length);
    }
    public int helper (int restrict){
        if (restrict==1){
            return nums[0];
        }
        else if (restrict==0){
            return remainder;
        }
        else{
            int cursor = 0;
            for (int i=0;i<restrict/2;i++){
                if (nums[2*i]==nums[2*i+1]){
                    nums[cursor] = nums[2*i];
                    cursor++;
                }
            }
            if (restrict%2!=0){
                remainder = nums[restrict-1];
            }
            return helper(cursor);
        }
    }
    public static void main(String... args){
        Problem169 main = new Problem169();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(main.majorityElement(nums));
    }
}
