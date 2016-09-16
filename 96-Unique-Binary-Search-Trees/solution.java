public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        return count(n, dp);
    }
    
    private int count(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int res = 0;
        for (int i = 0;i <= n;i++) {
            int left = count(i, dp);
            int right = count(n - i - 1, dp);
            res += left * right;
        }
        dp[n] = res;
        return res;
    }
}