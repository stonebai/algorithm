public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix.length;
        int res = 0;
        if (row < col) {
            int[] dp = new int[row];
            for (int j = 0;j < col;j++) {
                for (int i = 0;i < row;i++) {
                    if (matrix[i][j] == '0') {
                        dp[i] = 0;
                    } else {
                        dp[i]++;
                    }
                }
                res = Math.max(res, histogram(dp));
            }
        } else {
            int[] dp = new int[col];
            for (int i = 0;i < row;i++) {
                for (int j = 0;j < col;j++) {
                    if (matrix[i][j] == '0') {
                        dp[j] = 0;
                    } else {
                        dp[j]++;
                    }
                }
                res = Math.max(res, histogram(dp));
            }
        }
        return res;
    }
    
    private int histogram(int[] dp) {
        Stack<Integer> h = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();
        int max = 0;
        for (int i = 0;i < dp.length;i++) {
            if (h.isEmpty() || h.peek() < dp[i]) {
                h.push(dp[i]);
                index.push(i);
            } else {
                int pre = index.peek();
                while (!h.isEmpty() && h.peek() >= dp[i]) {
                    int hi = h.pop();
                    int in = index.pop();
                    int area = dp[i] * (i - in + 1);
                    max = Math.max(area, max);
                    pre = in;
                }
                h.push(dp[i]);
                index.push(pre);
            }
        }
        while (!h.isEmpty()) {
            int hi = h.pop();
            int in = index.pop();
            int area = hi * (dp.length - in);
            max = Math.max(area, max);
        }
        return max;
    }
}