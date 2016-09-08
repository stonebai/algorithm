public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        int row = A.length, col = B[0].length, len = B.length;
        int[][] res = new int[row][col];
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                int sum = 0;
                for (int k = 0;k < len;k++) {
                    sum += A[i][k] * B[k][j];
                }
                res[i][j] = sum;
            }
        }
        return res;
    }
}