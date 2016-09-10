public class Solution {
    public boolean isMatch(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        boolean[][] dp = new boolean[chs.length + 1][chp.length + 1];
        int i = 0, j = 0;
        return dfs(chs, chp, i, j);
    }
    
    private boolean dfs(char[] chs, char[] chp, int i, int j) {
        while (i < chs.length && j < chp.length) {
            if (j < chp.length - 1 && chp[j + 1] == '*') {
                if (chp[j] == '.' || chs[i] == chp[j]) {
                    return dfs(chs, chp, i, j + 2) || dfs(chs, chp, i + 1, j);
                } else {
                    return dfs(chs, chp, i, j + 2);
                }
            }
            if (chp[j] == '.' || chs[i] == chp[j]) {
                i++;
                j++;
            }
        }
        if (i != chs.length) {
            return false;
        }
        if (j != chp.length) {
            if (j == chp.length - 2 && chp[j + 1] == '*') {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}