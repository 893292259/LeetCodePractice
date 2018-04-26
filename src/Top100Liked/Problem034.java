package Top100Liked;

public class Problem034 {

    public int[] binarySearchRange(int[] nums, int target, int head, int tail){
        if (head==tail) {
            if (nums[head] == target) {
                return new int[]{head, head};
            }
            else return new int[]{-1, -1};
        }
        else if ((head==0||nums[head-1]<nums[head])&&(tail==nums.length-1||nums[tail]<nums[tail+1])&&nums[head]==target&&nums[tail]==target){
            return new int[]{head,tail};
        }
        else {
            int mid = (head+tail)/2;
            if (nums[mid]<target){
                return binarySearchRange(nums,target,mid+1,tail);
            }
            else if (nums[mid]>target){
                return binarySearchRange(nums,target,head,mid);
            }
            else{
                int mid1=nums[head]==target? head:mid,mid2=nums[tail]==target?tail:mid;
                if (nums[head]!=target) {
                    while (nums[mid1] == target) {
                        mid1 = (head + mid1) / 2;
                    }
                    mid1++;
                }
                if (nums[tail]!=target) {
                    while (nums[mid2] == target) {
                        mid2 = (mid2 + tail + 1) / 2;
                    }
                    mid2--;
                }
                return binarySearchRange(nums,target,mid1,mid2);
            }
        }
    }

    public int[] searchRange(int[] nums, int target){
        if (nums.length==0) {
            return new int[]{-1, -1};
        }
        else {
            return binarySearchRange(nums,target,0,nums.length-1);
        }
    }
    public static void main (String...args){
        Problem034 main = new Problem034();
        int[] nums = {5,7,7,8,8,10};
        System.out.println(main.searchRange(nums,2));
    }
}
