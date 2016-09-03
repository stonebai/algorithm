public class Solution {
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int max = 0;
        String res = "";
        for (int i = 0;i < chs.length;i++) {
            int odd = odd(chs, i);
            int even = even(chs, i);
            if (odd > even && odd > max) {
                max = odd;
                int radix = (odd - 1) / 2;
                res = s.substring(i - radix, i + radix + 1);
            } else if (even > odd && even > max) {
                max = even;
                int radix = even / 2;
                res = s.substring(i - radix + 1, i + radix + 1);
            }
        }
        return res;
    }
    
    private int odd(char[] chs, int i) {
        int left = i - 1, right = i + 1, count = 1;
        while (left >= 0 && right < chs.length) {
            if (chs[left--] == chs[right++]) {
                count += 2;
            } else {
                break;
            }
        }
        return count;
    }
    
    private int even(char[] chs, int i) {
        int j = i + 1, count = 0;
        while (i >= 0 && j < chs.length) {
            if (chs[i--] == chs[j++]) {
                count += 2;
            } else {
                break;
            }
        }
        return count;
    }
}