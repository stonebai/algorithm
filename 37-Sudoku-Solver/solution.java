public class Solution {
    public void solveSudoku(char[][] board) {
        return validateRows(board) && validateCols(board) && validateBlocks(board);
    }
    
    private boolean validateRows(char[][] board) {
        for (int i = 0;i < 9;i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0;j < 9;j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
    
    private boolean validateCols(char[][] board) {
        for (int j = 0;j < 9;j++) {
            Set<Character> set = new HashSet<Character>();
            for (int i = 0;i < 9;i++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
    
    private boolean validateBlocks(char[][] board) {
        for (int row = 0;row < 9;row += 3) {
            for (int col = 0;col < 9; col += 3) {
                Set<Character> set = new HashSet<Character>();
                for (int i = row;i < row + 3;i++) {
                    for (int j = col;j < col + 3;j++) {
                        if (board[i][j] == '.') {
                            continue;
                        } else if (set.contains(board[i][j])) {
                            return false;
                        } else {
                            set.add(board[i][j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}