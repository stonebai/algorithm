public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] board = new int[n];
        int i = 0, j = 0;
        while (i < n) {
            while (j < n) {
                board[i] = j;
                if (check(board, i)) {
                    break;
                } else {
                    j++;
                }
            }
            if (j == n) {
                i--;
                if (i < 0) break;
                j = board[i] + 1;
            } else {
                if (i == n - 1) {
                    save(res, board, n);
                    j++;
                } else {
                    i++;
                    j = 0;
                }
            }
        }
        return res;
    }
    
    private boolean check(int[] board, int i) {
        for (int j = 0;j < i;j++) {
            if (board[j] == board[i]) return false;
            if (i - j == Math.abs(board[i] - board[j])) return false;
        }
        return true;
    }
    
    private void save(List<List<String>> res, int[] board, int n) {
        List<String> list = new ArrayList<String>();
        for (int index : board) {
            list.add(drawLine(index, n));
        }
        res.add(list);
    }
    
    private String drawLine(int index, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < n;i++) {
            if (i == index) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}