public class Solution {
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int res = 0;
        for (int i = 0;i < chs.length;i++) {
            int odd = odd(chs, i);
            int even = odd(chs, i);
            res = Math.max(res, Math.max(odd, even));
        }
        return res;
    }
    
    private int odd(char[] chs, int i) {
        int left = i - 1, right = i + 1, count = 1;
        while (left >= 0 && right < chs.length) {
            if (chs[left--] == chs[right++]) {
                count += 2;
            }
        }
        return count;
    }
    
    private int even(char[] chs, int i) {
        int j = i + 1, count = 0;
        while (i >= 0 && j < chs.length) {
            if (chs[i--] == chs[j++]) {
                count += 2;
            }
        }
        return count;
    }
}