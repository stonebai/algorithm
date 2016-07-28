public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();
        return helper(chs1, chs2, chs3, 0, 0, 0, new short[chs1.length + 1][chs2.length + 1][chs3.length + 1]);
    }
    
    private boolean helper(char[] chs1, char[] chs2, char[] chs3, int i, int j, int k, short[][][] dp) {
        if (dp[i][j][k] != 0) {
            if (dp[i][j][k] == 1) return true;
            else return false;
        }
        int ii = i, jj = j, kk = k;
        while (k < chs3.length && i < chs1.length && j < chs2.length) {
            if (chs3[k] == chs1[i] && chs3[k] == chs2[j]) {
                if (ihelper(chs1, chs2, chs3, i + 1, j, k + 1, dp)) return true;
                else return helper(chs1, chs2, chs3, i, j + 1, k + 1, dp);
            } else if (chs3[k] == chs1[i]) {
                i++;
            } else if (chs3[k] == chs2[j]) {
                j++;
            } else {
                dp[ii][jj][kk] = -1;
                return false;
            }
            k++;
        }
        while (k < chs3.length && i < chs1.length) {
            if (chs3[k++] != chs1[i++]) {
                dp[ii][jj][kk] = -1;
                return false;
            }
        }
        while (k < chs3.length && j < chs2.length) {
            if (chs3[k++] != chs2[j++]) {
                dp[ii][jj][kk] = -1;
                return false;
            }
        }
        dp[ii][jj][kk] = 1;
        return true;
    }
}