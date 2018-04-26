package Favorite100Probelms;

public class Problem004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        boolean isOdd = ((length1+length2)%2==1);
        if (length1==0){
            if (isOdd){
                return (nums2[(length2-1)/2]);
            }
            else {
                return ((((double) nums2[(length2-1)/2])+((double)nums2[(length2-1)/2+1]))/2);
            }
        }
        if (length2==0){
            if (isOdd){
                return (nums1[(length1-1)/2]);
            }
            else {
                return ((((double) nums1[(length1-1)/2])+((double)nums1[(length1-1)/2+1]))/2);
            }
        }
        int remain = (length1+length2+1)/2;
        while(remain>=2){
            int split = Math.min(remain/2-1,Math.min(length1-i-1, length2-j-1));
            if (nums1[i+split]>nums2[j+split]){
                j+=split+1;
                if (j==length2){
                    i = i+remain-split-2;
                    if (isOdd){
                        return (double) nums1[i];
                    }
                    else{
                        return ((((double) nums1[i])+((double)nums1[i+1]))/2);
                    }
                }
            }
            else {
                i += split + 1;
                if (i == length1) {
                    j = j + remain - split - 2;
                    if (isOdd) {
                        return (double) nums2[j];
                    } else {
                        return ((((double) nums2[j]) + ((double) nums2[j + 1])) / 2);
                    }
                }
            }
            remain-=split+1;
        }
        if (isOdd){
            return (nums1[i]>nums2[j])? (double) nums2[j]:(double) nums1[i];
        }
        else {
            if (nums1[i]<=nums2[j]){
                if (i+1==length1||nums1[i+1]>=nums2[j]){
                    return ((((double) nums1[i]) + ((double) nums2[j])) / 2);
                }
                else {
                    return ((((double) nums1[i]) + ((double) nums1[i+1])) / 2);
                }

            }
            else{
                if (j+1==length2||nums2[j+1]>=nums1[i]){
                    return ((((double) nums1[i]) + ((double) nums2[j])) / 2);
                }
                else {
                    return ((((double) nums2[j]) + ((double) nums2[j+1])) / 2);
                }

            }

        }
    }


    public static void main(String... args){
        Problem004 main = new Problem004();
        int[] nums1 = {2,3};
        int[] nums2 = {1};
        double result = main.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}
