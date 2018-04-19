public class Problem121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length>0) {
            int currentMin = prices[0];
            for (int i = 1; i < prices.length; i++) {
                max = Math.max(prices[i] - currentMin, max);
                currentMin = Math.min(currentMin, prices[i]);
            }
        }
        return max;
    }
    public static void main(String... args){
        Problem121 main = new Problem121();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(main.maxProfit(prices));
    }
}
