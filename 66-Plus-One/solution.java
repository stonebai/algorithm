public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int i = digits.length - 1;
        while (i < digits.length) {
            digits[i]++;
            if (digits[i] == 10) {
                digits[i--] = 0;
            } else {
                break;
            }
        }
        if (i != -1) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
    }
}