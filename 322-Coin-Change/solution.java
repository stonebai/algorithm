public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        return helper(coins, amount, new HashMap<Integer, Integer>());
    }
    
    private int helper(int[] coins, int amount, Map<Integer, Integer> dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp.containsKey(amount)) {
            return dp.get(amount);
        }
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for (int coin : coins) {
            int tmp = helper(coins, amount - coin, dp);
            if (tmp != -1) {
                found = true;
                min = Math.min(min, tmp);
            }
        }
        if (found) {
            min++;
            dp.put(amount, min);
            return min;
        }
        return -1;
    }
}