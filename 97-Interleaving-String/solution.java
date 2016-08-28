public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();
        int i = 0, j = 0, k = 0;
        while (i < chs1.length && j < chs2.length && k < chs3.length) {
            if (chs1[i] == chs3[k] && chs2[j] != chs3[k]) {
                i++;
                k++;
            } else if (chs1[i] != chs3[k] && chs2[j] == chs3[k]) {
                j++;
                k++;
            } else if (chs1[i] == chs3[k] && chs2[j] == chs3[k]) {
                return isInterleave(s1.substring(i + 1), s2.substring(j), s3.substring(k + 1))
                || isInterleave(s1.substring(i), s2.substring(j + 1), s3.substring(k + 1));
            } else {
                return false;
            }
        }
        while (i < chs1.length && k < chs3.length) {
            if (chs1[i++] != chs3[k++]) {
                return false;
            }
        }
        while (j < chs2.length && k < chs3.length) {
            if (chs2[j++] != chs3[k++]) {
                return false;
            }
        }
        return true;
    }
}