public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int row = A.length, n = B.length, col = B[0].length;
        int[][] res = new int[row][col];
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
                for (Object index : ma[i]) {
                    res[i][j] += A[i][(int) index] * B[(int) index][j];
                }
            }
        }
        return res;
    }
}