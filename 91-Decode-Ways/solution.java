public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chs = s.toCharArray();
        if (chs[0] == '0') {
            return 0;
        }
        int p1 = 1, p2 = 0;
        for (int i = 1;i < chs.length;i++) {
            int t1 = 0, t2 = 0;
            if (chs[i] == '0') {
                t1 = 0;
                if (chs[i - 1] == '1' || chs[i - 1] == '2') {
                    t2 = p1;
                } else {
                    return 0;
                }
            } else if (chs[i - 1] == '1' || (chs[i - 1] == '2' && chs[i] <= '6')) {
                t1 = p1 + p2;
                t2 = p1;
            } else {
                t1 = p1 + p2;
                t2 = 0;
            }
            p1 = t1;
            p2 = t2;
        }
        return p1 + p2;
    }
}