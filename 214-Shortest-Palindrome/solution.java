public class Solution {
    public String shortestPalindrome(String s) {
        char[] chs = s.toCharArray();
        String res = "";
        for (int i = chs.length - 1;i >= 0;i--) {
            if (isPalindrome(chs, i)) {
                String tail = s.substring(i + 1);
                String reverse = reverse(tail);
                res = reverse + s;
                break;
            }
        }
        return res;
    }
    
    private boolean isPalindrome(char[] chs, int end) {
        int i = 0, j = end;
        while (i < j) {
            if (chs[i++] != chs[j--]) {
                return false;
            }
        }
        return true;
    }
    
    private String reverse(String str) {
        char[] res = str.toCharArray();
        int i = 0, j = res.length - 1;
        while (i < j) {
            swap(res, i++, j--);
        }
        return new String(res);
    }
    
    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}