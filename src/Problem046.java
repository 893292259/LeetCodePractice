import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem046 {
    public List<List<Integer>> solve(int[]nums,int restirct){
        List<List<Integer>> results = new ArrayList<>();
        if (restirct==0){
            List<Integer> result = new ArrayList<>();
            result.add(nums[restirct]);
            results.add(result);
        }
        else{
            List<List<Integer>> result = solve(nums,restirct-1);
            for (int i=0;i<result.size();i++){
                List<Integer> item = result.get(i);
                    for (int j=0; j<=restirct;j++){
                        List<Integer> itemPlus = new ArrayList<>(item);
                        itemPlus.add(j,nums[restirct]);
                        results.add(itemPlus);
                    }
            }
        }
        return results;
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length!=0){
            return solve(nums,nums.length-1);
        }
        else{
            return new ArrayList<>();
        }
    }
    public static void main(String... args){
        Problem046 main = new Problem046();
        int[] nums = {1,2,3};
        System.out.println(main.permute(nums).toString());
    }
}
