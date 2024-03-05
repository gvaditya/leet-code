// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int max = prices[0];
        int min =prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(max<prices[i]){
                max = prices[i];
                profit = Math.max(max-min, profit);
            }
            if(min> prices[i]){
                min = prices[i];
                max = prices[i];
            }
        }
        return profit;
    }
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{2,4,1}));
    }
}
