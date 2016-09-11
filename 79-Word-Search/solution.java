public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return word.length() == 0;
        }
        char[] chs = word.toCharArray();
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (dfs(board, i, j, chs, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, char[] chs, int pos, boolean[][] visited) {
        if (pos == chs.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j] || chs[pos] != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res =   dfs(board, i + 1, j, chs, pos + 1, visited) ||
                        dfs(board, i - 1, j, chs, pos + 1, visited) ||
                        dfs(board, i, j + 1, chs, pos + 1, visited) ||
                        dfs(board, i, j - 1, chs, pos + 1, visited);
        visited[i][j] = false;
        return res;
    }
}