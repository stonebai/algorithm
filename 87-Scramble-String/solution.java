public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        if (!validate(s1, s2)) return false;
        int len = s1.length();
        for (int i = 1;i < len;i++) {
            String pre1 = s1.substring(0, i);
            String suf1 = s1.substring(i);
            String p21 = s2.substring(0, i);
            String s21 = s2.substring(i);
            String p22 = s2.substring(0, len - i);
            String s22 = s2.substring(len - i);
            if (isScramble(pre1, p21) && isScramble(suf1, s21)) return true;
            if (isScramble(pre1, s22) && isScramble(suf1, p22)) return true;
        }
        return false;
    }
    
    private boolean validate(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[] count = new int[26];
        for (int i = 0;i < chs1.length;i++) {
            int index1 = chs1[i] - 'a';
            int index2 = chs2[i] - 'a';
            count[index1]++;
            count[index2]--;
        }
        for (int i = 0;i < 26;i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}