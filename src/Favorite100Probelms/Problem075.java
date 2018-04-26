package Favorite100Probelms;

public class Problem075 {
    public void sortColors(int[] nums) {
        int [] data = new int[3];
        for (int i=0;i<3;i++){
            data[i] = 0;
        }
        for (int i=0;i<nums.length;i++){
            data[nums[i]]++;
        }
        int count =0,i,j;
        for (i=0;i<3;i++ ){
            for (j=count;j-count<data[i];j++){
                nums[j]=i;
            }
            count = j;
        }
    }
    public static void main(String... args){
        Problem075 main = new Problem075();
        int[] nums = {1,2,0,2,1,0};
        main.sortColors(nums);
    }
}
