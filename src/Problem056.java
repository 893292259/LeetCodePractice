import DataStructures.Interval;

import java.util.ArrayList;
import java.util.List;

public class Problem056 {

    public void maxHeapify(Interval[] array, int i, int size){
        if (i*2+2>=size){
            if (i*2+1>=size) {
                return;
            }
            else if (array[i].start<array[i*2+1].start){
                Interval t =array[i*2+1];
                array[i*2+1] = array[i];
                array[i] = t;
                maxHeapify(array,i*2+1,size);
            }
        }
        else if (array[i].start<array[i*2+2].start||array[i].start<array[i*2+1].start){
            if (array[i*2+2].start<array[i*2+1].start){
                Interval t =array[i*2+1];
                array[i*2+1] = array[i];
                array[i] = t;
                maxHeapify(array,i*2+1,size);
            }
            else {
                Interval t =array[i*2+2];
                array[i*2+2] = array[i];
                array[i] = t;
                maxHeapify(array,i*2+2,size);
            }
        }
    }

    public void heapSort (Interval[]array){
        for (int i=(array.length-1)/2;i>=0;i--){
            maxHeapify(array,i,array.length);
        }
        for (int i =array.length-1;i>0;i--){
            Interval t =array[0];
            array[0] = array[i];
            array[i] = t;
            maxHeapify(array,0,i);
        }

    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> results = new ArrayList<>();
        if(intervals.size()>0) {
            Interval[] array = new Interval[intervals.size()];
            int i=0;
            for (Interval interval:intervals){
                array[i] = interval;
                i++;
            }
            heapSort(array);
            int curStart = array[0].start;
            int curEnd = array[0].end;
            for (i = 1; i < array.length; i++) {
                if (array[i].start<=curEnd){
                    curEnd = Math.max(curEnd,array[i].end);
                }
                else{
                    results.add(new Interval(curStart,curEnd));
                    curStart = array[i].start;
                    curEnd = array[i].end;
                }
            }
            results.add(new Interval(curStart,curEnd));
        }
        return results;
    }
    public static void main (String...args){
        Problem056 main = new Problem056();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        System.out.println(main.merge(intervals));
    }
}
