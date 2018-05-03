package Top100Liked;

public class Problem215 {
    int[] nums;
    int k;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.k = nums.length+1-k;
        return helper(0,nums.length-1);
    }
    public int helper(int start,int end) {
        int target =nums[(end+start)/2];
        nums[(end+start)/2]=nums[start];
        int i=start,j=end;
        while (i < j) {
            if (nums[i+1]<target){
                nums[i]=nums[i+1];
                i++;
            }
            else{
                int temp = nums[j];
                nums[j] = nums[i+1];
                nums[i+1] = temp;
                j--;
            }
        }
        if (i+1==k){
            return target;
        }
        else if (i+1<k){
            return helper(i+1,end);
        }
        else{
            return helper(start,i-1);
        }
    }
    public static void main(String... args){
        Problem215 main = new Problem215();
        int[]nums ={3,2,1,5,6,4};
        System.out.println(main.findKthLargest(nums,2));
    }
}
