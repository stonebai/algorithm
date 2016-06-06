public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int i = 0, j = 0;
        int tmpI = -1, tmpJ = -1;
        while(i < s.length()) {
            char a = s.charAt(i), b = p.charAt(j);
            if (b == '*') {
                j++;
                while(j < p.length() && p.charAt(j) == '*') {
                    j++;
                }
                tmpI = i;
                tmpJ = j;
            } else if (b == '?' && b == a) {
                i++;
                j++;
            } else if (tmpJ != -1) {
                i = ++tmpI;
                j = tmpJ;
            } else {
                return false;
            }
        }
        while(j < p.length()) {
            if (p.charAt(j) == '*') {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}