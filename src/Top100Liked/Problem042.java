package Top100Liked;

public class Problem042 {


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

    class data{
        public int value;
        public int index;
        public data(int height, int index) {
            this.value = height;
            this.index = index;
        }
    }
    public int trap(int[] height) {
        int len = height.length;
        if (len<=1){
            return  0;
        }
        else {
            data[] moutains = new data[len];
            boolean[] ischecked = new boolean[len];
            int sum = 0;
            for (int i = 0; i < len; i++) {
                moutains[i] = new data(height[i], i);
                ischecked[i] = false;
            }
            heapSort(moutains);
            int head = Math.min(moutains[len-1].index,moutains[len-2].index);
            int tail = Math.max(moutains[len-1].index,moutains[len-2].index);
            for (int i=head+1;i<tail;i++){
                sum+=moutains[len-2].value-height[i];
                ischecked[i] = true;
            }
            for (int i = height.length - 3; i >= 0; i--) {
                if (!ischecked[moutains[i].index]) {
                    if (moutains[i].index<head){
                        for (int j=moutains[i].index+1;j<head;j++){
                            sum+=moutains[i].value-height[j];
                            ischecked[j] = true;
                        }
                        head = moutains[i].index;
                    }
                    else{
                        for (int j=tail+1;j<moutains[i].index;j++){
                            sum+=moutains[i].value-height[j];
                            ischecked[j] = true;
                        }
                        tail = moutains[i].index;
                    }
                }
            }
            return sum;
        }
    }
    public static void main(String... args){
       Problem042 main = new Problem042();
       int[] height = {4,4,4,7,1,0};
       System.out.println(main.trap(height));
    }
}
