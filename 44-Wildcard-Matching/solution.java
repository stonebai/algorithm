public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            if (s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (s.length() == 0) {
            if (s.length() > 1 && s.charAt(1) == '*') {
                return isMatch(s, p.substring(2));
            } else {
                return false;
            }
        }
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            char a = s.charAt(i), b = p.charAt(j);
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                if (b == '.' && a == b) {
                    return isMatch(s, p.substring(j + 2)) ||
                    isMatch(s.substring(i + 1), p.substring(j + 2) ||
                    isMatch(s.substring(i + 1), p.substring(j));
                } else {
                    j += 2;
                }
            } else if (b == '.' || a == b) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return i == s.length() && j == p.length();
    }
}