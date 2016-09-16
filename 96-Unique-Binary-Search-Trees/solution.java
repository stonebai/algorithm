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
        for (int i = 1;i <= n;i++) {
            int left = count(i - 1, dp);
            int right = count(n - i, dp);
            res += left * right;
        }
        dp[n] = res;
        return res;
    }
}