public class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[i].length;j++) {
                int count = 0;
                count += count(board, i + 1, j + 1);
                count += count(board, i + 1, j);
                count += count(board, i + 1, j - 1);
                count += count(board, i, j + 1);
                count += count(board, i, j - 1);
                count += count(board, i - 1, j + 1);
                count += count(board, i - 1, j);
                count += count(board, i - 1, j - 1);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[i].length;j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int count(int[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && (board[i][j] == 1 || board[i][j] == 2)) {
            return 1;
        } else {
            return 0;
        }
    }
}