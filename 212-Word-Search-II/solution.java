public class Solution {
    
    class Trie {
        Trie[] next = new Trie[26];
        String word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        if (board == null || board.length == 0 || board[0].length == 0) return res;
        Trie root = buildTrie(words);
        int row = board.length;
        int col = board[0].length;
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                dfs(board, i, j, new boolean[row][col], root, set);
            }
        }
        res.addAll(set);
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, boolean[][] visited, Trie cur, Set<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j]) return;
        visited[i][j] = true;
        int index = board[i][j] - 'a';
        if (cur.next[index] != null) {
            cur = cur.next[index];
            if (cur.word != null) res.add(cur.word);
            dfs(board, i + 1, j, visited, cur, res);
            dfs(board, i - 1, j, visited, cur, res);
            dfs(board, i, j + 1, visited, cur, res);
            dfs(board, i, j - 1, visited, cur, res);
        }
        visited[i][j] = false;
    }
    
    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            char[] chs = word.toCharArray();
            Trie cur = root;
            for (char ch : chs) {
                int index = ch - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Trie();
                }
                cur = cur.next[index];
            }
            cur.word = word;
        }
        return root;
    }
}