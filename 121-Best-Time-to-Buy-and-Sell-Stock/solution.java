public class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for (int i = 0;i < prices.length;i++) {
            buy = Math.min(prices[i], buy);
            sell = Math.max(prices[i] - buy, sell);
        }
        return sell;
    }
}