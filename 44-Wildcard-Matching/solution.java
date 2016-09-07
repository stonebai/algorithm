public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        } else if (s.length() == 0) {
            char[] chp = p.toCharArray();
            for (char ch : chp) {
                if (ch != '*') {
                    return false;
                }
            }
            return true;
        }
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        int i = 0;
        for (;i < chs.length && i < chp.length;i++) {
            if (chp[i] == '*') {
                int j = i + 1;
                while (j < chp.length && chp[j] == '*') {
                    j++;
                }
                return isMatch(s.substring(i), p.substring(j)) || isMatch(s.substring(i + 1), p.substring(j - 1));
            } else if (chp[i] == '?' || chs[i] == chp[i]) {
                continue;
            } else {
                return false;
            }
        }
        if (i == chp.length) {
            return i == chs.length;
        } else {
            for (;i< chp.length;i++) {
                if (chp[i] != '*') {
                    return false;
                }
            }
            return true;
        }
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