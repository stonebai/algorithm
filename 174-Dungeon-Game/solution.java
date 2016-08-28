public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.legnth;
        int col = dungeon[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = dungeon[row][col] >= 0 ? 0 : dungeon[row][col];
        for (int i = row - 1;i >= 0;i--) {
            int tmp = dungeon[i][col] + dp[i + 1][col];
            dp[i][col] = tmp >= 0 ? 0 : tmp;
        }
        for (int j = col - 1;j >= 0;j--) {
            int tmp = dungeon[row][j] + dp[row][j + 1];
            dp[row][j] = tmp >= 0 ? 0 : tmp;
        }
        for (int i = row - 1;i >= 0;i--) {
            for (int j = col - 1;j >= 0;j--) {
                int a = dungeon[i][j] + dp[i][j + 1];
                int b = dungeon[i][j] + dp[i + 1][j];
                int tmp = Math.max(a, b);
                dp[i][j] = tmp >= 0 ? 0 : tmp;
            }
        }
        return -dp[0][0] + 1;
    }
}