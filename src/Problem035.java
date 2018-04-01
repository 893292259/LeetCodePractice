import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem035 {
    public void maxHeapify(int[] array, int i, int size){
        if (i*2+2>=size){
            if (i*2+1>=size) {
                return;
            }
            else if (array[i]<array[i*2+1]){
                int t =array[i*2+1];
                array[i*2+1] = array[i];
                array[i] = t;
                maxHeapify(array,i*2+1,size);
            }
        }
        else if (array[i]<array[i*2+2]||array[i]<array[i*2+1]){
            if (array[i*2+2]<array[i*2+1]){
                int t =array[i*2+1];
                array[i*2+1] = array[i];
                array[i] = t;
                maxHeapify(array,i*2+1,size);
            }
            else {
                int t =array[i*2+2];
                array[i*2+2] = array[i];
                array[i] = t;
                maxHeapify(array,i*2+2,size);
            }
        }
    }

    public void heapSort (int[]array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            maxHeapify(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            int t = array[0];
            array[0] = array[i];
            array[i] = t;
            maxHeapify(array, 0, i);
        }
    }

    public List<List<Integer>> search(int[]candidates,int target, int restrict){
        List<List<Integer>> results = new ArrayList<>();
        if (target==0){
            results.add(new ArrayList<>());
        }
        else {
            int i = restrict;
            while (i<candidates.length &&target-candidates[i]>=0){
                if (target - candidates[i] >= 0) {
                    List<List<Integer>> result = search(candidates, target - candidates[i], i);
                    for (List<Integer> item : result) {
                        item.add(candidates[i]);
                    }
                    results.addAll(result);
                }
                i++;
            }
        }
        return results;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        heapSort(candidates);
        return search(candidates,target,0);
    }
    public static void main(String... args){
        Problem035 main = new Problem035();
        int[] candidates = {2,3,5,7};
        System.out.println(main.combinationSum(candidates,7).toString());
    }
}
