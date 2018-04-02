import java.util.*;

public class Problem049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,Map<Integer,List<String>>> sumMap = new HashMap<>();
        for (int i =0;i<strs.length;i++){
            int sum = 0;
            int prod = 1;
            for (int j=0;j<strs[i].length();j++){
                sum += strs[i].charAt(j);
                prod*= strs[i].charAt(j);
            }
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum,new HashMap<>());
            }
            Map<Integer,List<String>> prodMap = sumMap.get(sum);
            if (!prodMap.containsKey(prod)){
                prodMap.put(prod,new ArrayList<>());
            }
            prodMap.get(prod).add(strs[i]);
        }
        List<List<String>> results = new ArrayList<>();
        for (int i:sumMap.keySet()){
            results.addAll(sumMap.get(i).values());
        }
        return results;
    }
    public static void main(String... args){
        Problem049 main = new Problem049();
        String[] strs = new String[6];
        strs[0] = "asd";
        strs[1] = "ads";
        strs[2] = "bat";
        strs[3] = "abb";
        strs[4] = "bba";
        strs[5] = "aee";
        System.out.println(main.groupAnagrams(strs));
    }
}
