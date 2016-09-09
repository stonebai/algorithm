public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int row = A.length, col = B.length;
        int[][] res = new int[row][col];
        if (row == 0 || col == 0) {
            return res;
        }
        int n = A[0].length;
        List[] ma = new List[row];
        for (int i = 0;i < row;i++) {
            ma[i] = new ArrayList<Integer>();
            for (int j = 0;j < n;j++) {
                if (A[i][j] != 0) {
                    ma[i].add(j);
                }
            }
        }
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                for (int index : ma[i]) {
                    res[i][j] += A[i][index] * B[index][j];
                }
            }
        }
        return res;
    }
}