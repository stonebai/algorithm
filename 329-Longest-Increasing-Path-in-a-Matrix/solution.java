public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0;j < matrix[i].length;j++) {
                max = Math.max(max, dfs(matrix, i, j, Integer.MIN_VALUE, dp));
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j, int num, int[][] dp) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length && num < matrix[i][j]) {
            if (dp[i][j] != 0) {
                return dp[i][j];
            }
            int a = dfs(matrix, i + 1, j, matrix[i][j], dp);
            int b = dfs(matrix, i, j + 1, matrix[i][j], dp);
            int c = dfs(matrix, i - 1, j, matrix[i][j], dp);
            int d = dfs(matrix, i, j - 1, matrix[i][j], dp);
            dp[i][j] = 1 + Math.max(Math.max(a, b), Math.max(c, d));
            return dp[i][j];
        } else {
            return 0;
        }
    }
}