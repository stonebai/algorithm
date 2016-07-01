public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                int tmp = dfs(matrix, i, j, new boolean[row][col], dp);
                max = Math.max(tmp, max);
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        visited[i][j] = true;
        int a = dfs(matrix, i + 1, j, visited, matrix[i][j], dp);
        int b = dfs(matrix, i - 1, j, visited, matrix[i][j], dp);
        int c = dfs(matrix, i, j + 1, visited, matrix[i][j], dp);
        int d = dfs(matrix, i, j - 1, visited, matrix[i][j], dp);
        visited[i][j] = false;
        dp[i][j] = 1 + Math.max(Math.max(a, b), Math.max(c, d));
        return dp[i][j];
    }
    
    private int dfs(int[][] matrix, int i, int j, boolean[][] visited, int pre, int[][] dp) {
        if (i < 0 || i >= matrix.length
        || j < 0 || j >= matrix[i].length
        || visited[i][j] || matrix[i][j] <= pre) {
            return 0;
        }
        return dfs(matrix, i, j, visited, dp);
    }
}