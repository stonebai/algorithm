public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        return k * helper(n - 1, k, false, dp);
    }
    
    private int helper(int n, int k, boolean same, int[][] dp) {
        if (n == 0) {
            return 1;
        }
        if (same) {
            if (dp[n][0] != 0) {
                return dp[n][0];
            }
            dp[n][0] = (k - 1) * helper(n - 1, k, false);
            return dp[n][0];
        } else {
            if (dp[n][1] != 0) {
                return dp[n][1];
            }
            dp[n][1] = (k - 1) * helper(n - 1, k, false) + helper(n - 1, k, true);
            return dp[n][1];
        }
    }
}