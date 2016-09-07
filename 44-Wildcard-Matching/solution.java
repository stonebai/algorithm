public class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), 0, p.toCharArray(), 0, new boolean[s.length()][p.length()]);
    }
    
    private boolean dfs(char[] chs, int i, char[] chp, int j, boolean[][] visited) {
        if (j == chp.length) {
            return i == chs.length;
        } else if (i == chs.length) {
            for (;j < chp.length;j++) {
                if (chp[j] != '*') {
                    return false;
                }
            }
            return true;
        }
        if (visited[i][j]) {
            return false;
        }
        int a = i, b = j;
        while (a < chs.length && b < chp.length) {
            if (chp[b] == '*') {
                int c = b + 1;
                while (c < chp.length && chp[c] == '*') {
                    c++;
                }
                return dfs(chs, a, chp, c, visited) || dfs(chs, a + 1, chp, c - 1, visited);
            } else if (chp[b] == '?' || chs[a] == chp[b]) {
                a++;
                b++;
            } else {
                visited[i][j] = true;
                return false;
            }
        }
        boolean res = dfs(chs, a, chp, b, visited);
        if (res) {
            return true;
        } else {
            visited[i][j] = true;
            return false;
        }
    }
}