import java.util.ArrayList;
import java.util.List;

public class Problem136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i=0; i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }
    public static void main(String... args){
        Problem136 main = new Problem136();
        int[] nums = {1,2,3,4,4,5,6};
        System.out.println(main.singleNumber(nums));
    }
}
