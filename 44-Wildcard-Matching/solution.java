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
                return isMatch(s.substring(i), p.substring(i + 1)) || isMatch(s.substring(i + 1), p.substring(i));
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
}