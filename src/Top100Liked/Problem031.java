package Top100Liked;

public class Problem031 {
    public void nextPermutation(int[] nums) {
        if (nums.length>1) {
            int i,t,j;
            for (i = nums.length-2;i>=0&&nums[i]>=nums[i+1];i--){
            }
            if (i==-1){
                for (i=0;i<nums.length/2;i++){
                   t = nums[i];
                   nums[i] = nums[nums.length-1-i];
                   nums[nums.length-1-i]=t;
                }
            }
            else{
                int index=0;
                for (j=nums.length-1;j>i;j--){
                    if (nums[j]>nums[i]){
                        index = j;

                    }
                }
                t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                i++;
                j=nums.length-1;
                while (i<j){
                    t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    i++;
                    j--;
                }
            }
        }
    }

    public static void main(String... args){
        Problem031 main = new Problem031();
        int[] nums = {2,3,4,1,2,3,3,2};
        main.nextPermutation(nums);
    }
}
