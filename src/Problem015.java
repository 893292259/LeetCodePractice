import java.util.ArrayList;
import java.util.List;

public class Problem015 {

    public int binarySearch(int[] datas, int target, int head, int tail){
        if (head==tail){
            if (datas[head] == target){
                return head;
            }
            else{
                return -1;
            }
        }
        else {
            int mid = (head + tail) / 2;
            return datas[mid]<target? binarySearch(datas,target,mid+1,tail):binarySearch(datas,target,head,mid);
        }
    }

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

    public List<Integer> newItem (int a,int b, int c){
        List<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        result.add(c);
        return  result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        heapSort(nums);
        int[] negative = new int[nums.length];
        int[] ncount = new int[nums.length];
        int[] positive = new int[nums.length];
        int[] pcount = new int[nums.length];
        int zeroCount = 0;
        int nc = -1;
        int pc = -1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]<0){
                if (i>0&&nums[i-1]==nums[i]){
                    ncount[nc]++;
                }
                else{
                    nc++;
                    negative[nc]=nums[i];
                    ncount[nc]=1;
                }
            }
            else if (nums[i]>0){
                if (i>0&&nums[i-1]==nums[i]){
                    pcount[pc]++;
                }
                else{
                    pc++;
                    positive[pc]=nums[i];
                    pcount[pc]=1;
                }
            }
            else{
                zeroCount++;
            }
        }
        if (zeroCount>=3){
            results.add(newItem(0,0,0));
        }
        if (zeroCount>=1 && pc>=0){
            int tail = pc;
            int index;
            for (int i=0; i<nc+1;i++){
                if ((index=binarySearch(positive,-negative[i],0,tail))!=-1){
                    results.add(newItem(negative[i],0,-negative[i]));
                    tail = index;
                }
            }
        }
        for (int i=0; i<nc+1; i++){
            int head = 0;
            int tail = pc;
            while (head<tail){
                if (positive[head]+positive[tail]==-negative[i]){
                    results.add(newItem(negative[i],positive[head],positive[tail]));
                    head++;
                }
                else if (positive[head]+positive[tail]>-negative[i]){
                    tail--;
                }
                else{
                    head++;
                }
            }
        }
        for (int i=0; i<pc+1; i++){
            int head = 0;
            int tail = nc;
            while (head<tail){
                if (negative[head]+negative[tail]==-positive[i]){
                    results.add(newItem(negative[head],negative[tail],positive[i]));
                    head++;
                }
                else if (negative[head]+negative[tail]>-positive[i]){
                    tail--;
                }
                else{
                    head++;
                }
            }
        }
        int tail = pc;
        if (tail>=0) {
            for (int i = 0; i < nc + 1; i++) {
                if (negative[i] % 2 == 0) {
                    int index = binarySearch(positive, -negative[i] / 2, 0, tail);
                    if (index != -1 && pcount[index] > 1) {
                        results.add(newItem(negative[i], -negative[i] / 2, -negative[i] / 2));
                        tail = index;
                    }
                }
            }
        }
        tail = nc;
        if (tail >=0) {
            for (int i = 0; i < pc + 1; i++) {
                if (positive[i] % 2 == 0) {
                    int index = binarySearch(negative, -positive[i] / 2, 0, tail);
                    if (index != -1 && ncount[index] > 1) {
                        results.add(newItem(-positive[i] / 2, -positive[i] / 2, positive[i]));
                        tail = index;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String... args){
        Problem015 main = new Problem015();
        int[] nums = {1, 1,-2};
        List<List<Integer>> answer =  main.threeSum(nums);
        System.out.println(answer.toString());
    }
}
