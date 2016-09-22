public class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "";
        }
        for (int i = 0;i < k;i++) {
            if (num.length() == 0) {
                break;
            }
            char[] chs = num.toCharArray();
            int j = 0;
            while (j < chs.length - 1 && chs[j] <= chs[j + 1]) i++;
            if (j == 0) {
                int m = j + 1;
                while (m < chs.length && chs[m] == '0') m++;
                num = num.substring(m);
            } else {
                num = num.substring(0, j) + num.substring(j + 1);
            }
        }
        if (num.length() == 0) {
            return "0";
        } else {
            return num;
        }
    }
}