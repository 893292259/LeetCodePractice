package Top100Liked;

import java.util.HashMap;
import java.util.Map;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer,Integer> data = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (!data.containsKey(nums[i])){
                if (data.containsKey(nums[i]-1)&&data.containsKey(nums[i]+1)){
                    data.put(nums[i],nums[i]);
                    int begin = data.get(nums[i]-1);
                    int end = data.get(nums[i]+1);
                    data.put(begin,end);
                    data.put(end,begin);
                    max = Math.max(max,end-begin+1);
                }
                else if (data.containsKey(nums[i]-1)){
                    int begin = data.get(nums[i]-1);
                    data.put(begin,nums[i]);
                    data.put(nums[i],begin);
                    max = Math.max(max,nums[i]-begin+1);
                }
                else if (data.containsKey(nums[i]+1)){
                    int end = data.get(nums[i]+1);
                    data.put(nums[i],end);
                    data.put(end,nums[i]);
                    max = Math.max(max,end-nums[i]+1);
                }
                else{
                    data.put(nums[i],nums[i]);
                    max = Math.max(max,1);
                }
            }
        }
        return max;
    }
    public static void main(String... args){
        Problem128 main = new Problem128();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(main.longestConsecutive(nums));
    }
}
