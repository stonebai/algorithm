public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(1, n, dp);
    }
    
    private int helper(int lo, int hi, int[][] dp) {
        if (lo >= hi) {
            return 0;
        } else if (hi == lo + 1) {
            return lo;
        } else if (hi == lo + 2) {
            return lo + 1;
        } else if (hi == lo + 3) {
            return 2 * lo + 2;
        } else if (hi == lo + 4) {
            return 2 * lo + 4;
        }
        if (dp[lo][hi] != 0) {
            return dp[lo][hi];
        }
        int min = Integer.MAX_VALUE;
        for (int i = lo;i <= hi;i++) {
            int a = helper(lo, i - 1);
            int b = helper(i + 1, hi);
            int c = Math.max(a, b);
            min = Math.min(min, c + i);
        }
        dp[lo][hi] = min;
        return min;
    }
}