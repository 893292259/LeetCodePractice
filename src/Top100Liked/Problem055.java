package Top100Liked;

public class Problem055 {
    public boolean canJump(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[0]=true;
        int farthest = 0;
        int i=0;
        while (i<nums.length-1){
            if (canReach[i]) {
                if (farthest<i+nums[i]){
                    for (int j=farthest+1;j<=Math.min(nums.length-1,i+nums[i]);j++){
                        canReach[j]=true;
                    }
                    farthest = i+nums[i];
                    if (farthest>=nums.length-1){
                        return true;
                    }
                }
            }
            else{
             return false;
            }
            i++;
        }
        return canReach[nums.length-1];
    }
    public static void main(String...args){
        Problem055 main = new Problem055();
        int[] nums = {3,2,1,0,4};
        System.out.println(main.canJump(nums));
    }
}
