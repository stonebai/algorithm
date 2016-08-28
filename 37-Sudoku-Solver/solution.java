public class Solution {
    
    private Set<Character> all = new HashSet<Character>();
    
    static {
        all.add('1');
        all.add('2');
        all.add('3');
        all.add('4');
        all.add('5');
        all.add('6');
        all.add('7');
        all.add('8');
        all.add('9');
    }
    
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int i, int j) {
        while (i < 9 && j < 9 && board[i][j] != '.') {
            if (j < 8) {
                j++;
            } else {
                j = 0;
                i++;
            }
        }
        if (i == 9) {
            return true;
        }
        Set<Character> available = findAvailable(board, i, j);
        for (Character cha : available) {
            board[i][j] = cha.charValue();
            if (solve(board, i, j)) {
                return true;
            }
        }
        board[i][j] = '.';
        return false;
    }
    
    private static Set<Character> findAvailable(char[][] board, int x, int y) {
        Set<Character> res = new HashSet<Character>(all);
        int row = findRowOrCol(x);
        int col = findRowOrCol(y);
        for (int i = row;i < row + 3;i++) {
            for (int j = col;j < col + 3;j++) {
                if (board[i][j] != '.') {
                    res.remove(board[i][j]);
                }
            }
        }
        for (int i = 0;i < 9;i++) {
            if (board[i][y] != '.') {
                res.remove(board[i][y]);
            }
        }
        for (int j = 0;j < 9;j++) {
            if (board[x][j] != '.') {
                res.remove(board[x][j]);
            }
        }
        return res;
    }
    
    private static int findRowOrCol(int x) {
        int res = 6;
        while (res > x) {
            res -= 3;
        }
        return res;
    }
}