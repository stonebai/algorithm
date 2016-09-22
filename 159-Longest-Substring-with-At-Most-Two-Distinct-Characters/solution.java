public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        char[] chs = s.toCharArray();
        Character[] cs = new Character[2];
        int[] ps = new int[2];
        int i = 0, j = 0;
        while (j < chs.length) {
            boolean found = false;
            for (int k = 0;k < 2;k++) {
                if (cs[k] == null || cs[k] == chs[j]) {
                    found = true;
                    ps[k] = j;
                    cs[k] = chs[j++];
                    break;
                }
            }
            if (!found) {
                res = Math.max(res, j - i);
                System.out.println(i + " " + j);
                int min = Integer.MAX_VALUE;
                int minIndex = Integer.MAX_VALUE;
                for (int k = 0;k < 2;k++) {
                    if (ps[k] < min) {
                        min = ps[k];
                        minIndex = k;
                    }
                }
                i = min + 1;
                ps[minIndex] = j;
                cs[minIndex] = chs[j++];
            }
        }
        return Math.max(res, j - i);
    }
}