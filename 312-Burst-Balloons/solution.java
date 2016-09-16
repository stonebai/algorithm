public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length + 2;
        int[] copy = new int[len];
        int[][] dp = new int[len][len];
        copy[0] = 1;
        copy[len - 1] = 1;
        for (int i = 0;i < nums.length;i++) {
            copy[i + 1] = nums[i];
        }
        return helper(copy, 0, len - 1, dp);
    }
    
    private int helper(int[] copy, int start, int end, int[][] dp) {
        if (start == end || start + 1 == end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int res = 0;
        for (int i = start + 1;i < end;i++) {
            int tmp = copy[i] * copy[start] * copy[end];
            tmp += helper(copy, start, i, dp);
            tmp += helper(copy, i, end, dp);
            res = Math.max(res, tmp);
        }
        dp[start][end] = res;
        return res;
    }
}