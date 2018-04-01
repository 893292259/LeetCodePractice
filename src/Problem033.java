public class Problem033 {
    public int binarySearch( int[]datas, int target, int head, int tail){
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
    public int search(int[] nums, int target) {
        if (nums.length ==0){
            return -1;
        }
        else if (nums[0]<=nums[nums.length-1]){
            return binarySearch(nums,target,0,nums.length-1);
        }
        else {
            int head = 0;
            int tail = nums.length - 1;
            int mid = (head + tail)/2;
            while (mid<nums.length-1&&nums[mid] < nums[mid + 1]) {
                if (nums[mid]<nums[0]){
                    tail = mid -1;
                }
                else{
                    head = mid+1;
                }
                mid = (head+tail)/2;
            }
            if (target<nums[0]){
                return binarySearch(nums,target,mid+1,nums.length-1);
            }
            else{
                return binarySearch(nums,target,0,mid);
            }
        }
    }
    public static void main(String... args){
        Problem033 main = new Problem033();
        int[] nums = {1,3};
        int target = 0;
        System.out.println(main.search(nums,target));
    }
}
