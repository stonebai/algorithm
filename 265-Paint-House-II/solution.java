public class Solution {
    public int minCostII(int[][] costs) {
        int row = costs.length;
        if (row <= 0) {
            return 0;
        }
        int col = costs[0].length;
        if ((col <= 0) || (row >= 2 && col <= 1)) {
            return 0;
        }
        int[][] dp = new int[row][col];
        int index1 = 0, sum1 = Integer.MAX_VALUE;
        int index2 = 0, sum2 = Integer.MAX_VALUE;
        for (int j = 0;j < col;j++) {
            dp[0][j] = costs[0][j];
            if (dp[0][j] < sum1) {
                index2 = index1;
                sum2 = sum1;
                index1 = j;
                sum1 = dp[0][j];
            } else if (dp[0][j] < sum2) {
                index2 = j;
                sum2 = dp[0][j];
            }
        }
        for (int i = 1;i < row;i++) {
            int i1 = 0, s1 = Integer.MAX_VALUE;
            int i2 = 0, s2 = Integer.MAX_VALUE;
            for (int j = 0;j < col;j++) {
                if (j == index1) {
                    dp[i][j] = costs[i][j] + sum2;
                } else {
                    dp[i][j] = costs[i][j] + sum1;
                }
                if (dp[i][j] < s1) {
                    i2 = i1;
                    s2 = s1;
                    i1 = j;
                    s1 = dp[i][j];
                } else if (dp[i][j] < s2) {
                    i2 = j;
                    s2 = dp[i][j];
                }
            }
            index1 = i1;
            index2 = i2;
            sum1 = s1;
            sum2 = s2;
        }
        return sum1;
    }
}