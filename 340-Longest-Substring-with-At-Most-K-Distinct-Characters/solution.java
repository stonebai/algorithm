public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int i = 0, j = 0;
        int res = 0;
        int[] count = new int[26];
        while (j < chs.length) {
            int index = chs[j] - 'a';
            if (count[index] == 0) {
                if (k > 0) {
                    k--;
                } else {
                    res = Math.max(res, j - i);
                    while (true) {
                        int idx = chs[i++] - 'a';
                        count[idx]--;
                        if (count[idx] == 0) {
                            break;
                        }
                    }
                }
            }
            count[index]++;
            j++;
        }
        return res;
    }
}