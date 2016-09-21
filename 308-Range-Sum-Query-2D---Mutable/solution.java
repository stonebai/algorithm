public class NumMatrix {
    
    private int[][] matrix;
    private long[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        this.matrix = new int[row][col];
        this.sum = new long[row + 1][col + 1];
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        long delta = val - this.matrix[row][col];
        this.matrix[row][col] = val;
        for (int i = row + 1;i < this.sum.length;i += i & (-i)) {
            for (int j = col + 1;j < this.sum[i].length;j += j & (-j)) {
                this.sum[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (int) (sumRegion(row2, col2) -
        sumRegion(row1 - 1, col2) -
        sumRegion(row2, col1 - 1) +
        sumRegion(row1 - 1, col1 - 1));
    }
    
    private long sumRegion(int x, int y) {
        long sum = 0;
        for (int i = x + 1;i > 0;i -= i & (-i)) {
            for (int j = y + 1;j > 0;j -= j & (-j)) {
                sum += this.sum[i][j];
            }
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);