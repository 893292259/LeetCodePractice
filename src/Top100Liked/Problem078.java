package Top100Liked;

import java.util.ArrayList;
import java.util.List;

public class Problem078 {
    public List<List<Integer>> sub(int[] nums,int restirct){
        List<List<Integer>> results = new ArrayList<>();
      if (restirct==nums.length){
          List<Integer> result = new ArrayList<>();
          results.add(result);
      }
      else{
          List<List<Integer>> oldResults = sub(nums,restirct+1);
          results.addAll(oldResults);
          for (List<Integer> item : oldResults){
               List<Integer> result = new ArrayList<>(item);
               result.add(nums[restirct]);
               results.add(result);
          }
      }
      return results;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return sub(nums,0);
    }
    public static void main(String... args){
           Problem078 main = new Problem078();
           int[] nums = {};
           System.out.println(main.subsets(nums));
    }
}
