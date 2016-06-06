public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int i = 0, j = 0;
        int tmpI = -1, tmpJ = -1;
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        while(i < ss.length) {
            if (j == ps.length) {
                if (tmpJ == -1) {
                    return false;
                } else {
                    i = ++tmpI;
                    j = tmpJ;
                }
            } else if (ps[j] == '*') {
                j++;
                while(j < ps.length && ps[j] == '*') {
                    j++;
                }
                tmpI = i;
                tmpJ = j;
            } else if (ps[j] == '?' || ps[j] == ss[i]) {
                i++;
                j++;
            } else if (tmpJ != -1) {
                i = ++tmpI;
                j = tmpJ;
            } else {
                return false;
            }
        }
        while(j < ps.length) {
            if (ps[j] == '*') {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}