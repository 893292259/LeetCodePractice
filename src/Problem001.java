
public class Problem001 {

    public class data{
        public int value;
        public int intice;
    }

    public int binarySearch(data[] datas, int target, int head, int tail){
        if (head==tail){
            if (datas[head].value == target){
                return datas[head].intice;
            }
            else{
                return -1;
            }
        }
        else {
            int mid = (head + tail) / 2;
            return datas[mid].value<target? binarySearch(datas,target,mid+1,tail):binarySearch(datas,target,head,mid);
        }
    }

    public void maxHeapify(data[] array, int i, int size){
        if (i*2+2>=size){
            if (i*2+1>=size) {
                return;
            }
            else if (array[i].value<array[i*2+1].value){
                data t =array[i*2+1];
                array[i*2+1] = array[i];
                array[i] = t;
                maxHeapify(array,i*2+1,size);
            }
        }
       else if (array[i].value<array[i*2+2].value||array[i].value<array[i*2+1].value){
            if (array[i*2+2].value<array[i*2+1].value){
                data t =array[i*2+1];
                array[i*2+1] = array[i];
                array[i] = t;
                maxHeapify(array,i*2+1,size);
            }
            else {
                data t =array[i*2+2];
                array[i*2+2] = array[i];
                array[i] = t;
                maxHeapify(array,i*2+2,size);
            }
        }
    }

    public void heapSort (data[]array){
        for (int i=(array.length-1)/2;i>=0;i--){
            maxHeapify(array,i,array.length);
        }
        for (int i =array.length-1;i>0;i--){
            data t =array[0];
            array[0] = array[i];
            array[i] = t;
            maxHeapify(array,0,i);
        }

    }

    public int[] twoSum(int[] nums,int target){
        data[] datas = new data[nums.length];
        for (int i=0;i<nums.length;i++){
            datas[i] = new data();
            datas[i].value = nums[i];
            datas[i].intice = i;
        }
        heapSort(datas);
        int first = -1;
        int second = -1;
        for (int i=0; i<=(nums.length-2); i++){
            second = binarySearch(datas,target-datas[i].value,i+1,datas.length-1);
            if (second!=-1 ){
                first = datas[i].intice;
                break;
            }
        }
        return first>second?  new int[]{second, first}:new int[]{first, second};
    }

    public static void main(String... args){
            Problem001 main = new Problem001();
            int [] array = {3,2,3};
            int [] result = main.twoSum(array,6);
    }
}
