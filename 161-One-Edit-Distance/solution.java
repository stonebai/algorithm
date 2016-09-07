public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t) || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        boolean oneChance = true;
        if (chs.length == cht.length) {
            for (int i = 0;i < chs.length;i++) {
                if (chs[i] != cht[i]) {
                    if (oneChance) {
                        oneChance = false;
                    } else {
                        return false;
                    }
                }
            }
        } else if (chs.length > cht.length) {
            int i = 0, j = 0;
            while (j < cht.length) {
                if (chs[i] != cht[j]) {
                    if (oneChance) {
                        oneChance = false;
                        i++;
                    } else {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                }
            }
            if (i < chs.length) {
                if (oneChance) {
                    oneChance = false;
                } else {
                    return false;
                }
            }
        } else {
            int i = 0, j = 0;
            while (i < chs.length) {
                if (chs[i] != cht[j]) {
                    if (oneChance) {
                        oneChance = false;
                        j++;
                    } else {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                }
            }
            if (j < cht.length) {
                if (oneChance) {
                    oneChance = false;
                } else {
                    return false;
                }
            }
        }
        return !oneChance;
    }
}