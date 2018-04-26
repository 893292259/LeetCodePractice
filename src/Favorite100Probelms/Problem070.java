package Favorite100Probelms;

public class Problem070 {
    public int climbStairs(int n) {
        int a1 = 1;
        int a2 = 0;
        for (int i=0;i<n;i++){
            a1 += a2;
            a2 = a1 - a2;
        }
        return a1;
    }
    public static void main(String... args){
        Problem070 main = new Problem070();
        System.out.println(main.climbStairs(5));
    }
}
