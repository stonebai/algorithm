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
            if (p.length() > 0 && p.charAt(0) == '*') {
                return isMatch(s, p.substring(1));
            } else {
                return false;
            }
        }
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            char a = s.charAt(i), b = p.charAt(j);
            if (b == '*') {
                return isMatch(s.substring(i + 1), p.substring(j)) || 
                isMatch(s.substring(i), p.substring(j + 1));
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