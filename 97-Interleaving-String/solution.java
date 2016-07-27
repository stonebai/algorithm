public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();
        int i = 0, j = 0, k = 0;
        while (k < chs3.length && i < chs1.length && j < chs2.length) {
            if (chs3[k] == chs1[i] && chs3[k] == chs2[j]) {
                boolean b1 = isInterleave(s1.substring(i + 1), s2.substring(j), s3.substring(k + 1));
                boolean b2 = isInterleave(s1.substring(i), s2.substring(j + 1), s3.substring(k + 1));
                return b1 || b2;
            } else if (chs3[k] == chs1[i]) {
                i++;
            } else if (chs3[k] == chs2[j]) {
                j++;
            } else {
                return false;
            }
            k++;
        }
        while (k < chs3.length && i < chs1.length) {
            if (chs3[k++] != chs1[i++]) return false;
        }
        while (k < chs3.length && j < chs2.length) {
            if (chs3[k++] != chs2[j++]) return false;
        }
        return true;
    }
}