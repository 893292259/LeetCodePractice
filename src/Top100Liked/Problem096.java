package Top100Liked;

public class Problem096 {
    public int numTrees(int n) {
        if (n==0){
            return 0;
        }
        int[] nums = new int[n+1];
        nums[0]=1;
        for (int i=1;i<=n;i++){
            nums[i] = 0;
            for (int j=1;j<=i;j++){
                nums[i]+=nums[j-1]*nums[i-j];
            }
        }
        return nums[n];
    }
    public static void main(String... args){
        Problem096 main = new Problem096();
        System.out.println(main.numTrees(3));
    }
}
