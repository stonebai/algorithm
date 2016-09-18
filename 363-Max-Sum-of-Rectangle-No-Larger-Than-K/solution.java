public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int left = 0;left < col;left++) {
            int[] dp = new int[row];
            for (int j = left;j < col;j++) {
                for (int i = 0;i < row;i++) {
                    dp[i] = dp[i] + matrix[i][j];
                }
                int tmp = helper(dp, k);
                res = Math.max(res, tmp);
            }
        }
        return res;
    }
    
    private int helper(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1;i < nums.length;i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < nums.length;i++) {
            for (int j = i;j < nums.length;j++) {
                int tmp = sum[j] - sum[i] + nums[i];
                if (tmp <= k) {
                    max = Math.max(tmp, max);
                }
            }
        }
        return max;
    }
}